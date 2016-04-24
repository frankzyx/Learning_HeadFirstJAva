// listen to non-GUI events
// first step: adding MIDI events
// second step: register and get ControllerEvents
// third step: draw panels with music

import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MiniMusicPlayer1 {
	
	static JFrame f = new JFrame("My First Music Video");
	static DrawPanel panel;
	
	public static void main(String[] args) {
		MiniMusicPlayer1 mini = new MiniMusicPlayer1();
		mini.go();
	}
	
	public void setUpGui() {
		panel = new DrawPanel();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(panel);
		f.setBounds(30,30, 300,300);
		f.setVisible(true);
	}
	
	public void go() {
		
		setUpGui();
		
		try {
			// 1. get a sequencer and register for events
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			int[] eventsIWant = {127};
			player.addControllerEventListener(panel, eventsIWant);
			
			// 2. create a sequence
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			// 3. create a track from the sequence
			Track track = seq.createTrack();
			
			// 4. add MIDI events to the track
			for (int i = 0; i < 60; i+=4) {
				// random notes
				int r = (int) (Math.random() * 40 + 40);
				
				track.add(makeEvent(144, 1, r, 100, i));
				
				// 176 for event type ControllerEvent, just to get events
				track.add(makeEvent(176, 1, 127, 0, i));
				
				track.add(makeEvent(128, 1, r, 100, i+2));
			}
			
			player.setSequence(seq);
			player.setTempoInBPM(120);
			player.start();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	// static utility method to make messages and return MidiEvents
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			// what to do
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			// when to do
			event = new MidiEvent(a, tick);
		} catch (Exception ex) {}
		
		return event;
	}
	
	// inner class for DrawPanel
	class DrawPanel extends JPanel implements ControllerEventListener {
		
		boolean msg = false;	// true only when getting an event
		
		// event handler method, from the ControllerEventListener interface
		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();
		}
		
		public void paintComponent(Graphics g) {
			if (msg) {
				
				Graphics2D g2 = (Graphics2D) g;
				// random color
				int red = (int) (Math.random() * 255);
				int green = (int) (Math.random() * 255);
				int blue = (int) (Math.random() * 255);
				
				g2.setColor(new Color(red, green, blue));
				
				// random rectangle
				int ht = (int) (Math.random() * 120 + 10);
				int wd = (int) (Math.random() * 120 + 10);
				int x = (int) (Math.random() * 40 + 10);
				int y = (int) (Math.random() * 40 + 10);
				
				g2.fillRect(x,y,wd,ht);
				msg = false;		// reset msg
			}
		}
		
		
		
	}
	
	
}