// beat box
import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox {
	
	// instance variables
	JPanel mainPanel;
	ArrayList<JCheckBox> checkBoxList;
	Sequencer player;
	Sequence seq;
	Track track;
	JFrame theFrame;
	
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	
	// main method
	public static void main(String[] args) {
		new BeatBox().buildGUI();
	}
	
	
	// buildGUI method
	public void buildGUI() {
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel background = new JPanel(new BorderLayout());
		// aesthetic purposes
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		checkBoxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		// 4 control buttons into buttonBox (EAST)
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);
		
		JButton tempoUp = new JButton("Tempo Up");
		tempoUp.addActionListener(new MyTempoUpListener());
		buttonBox.add(tempoUp);
		
		JButton tempoDown = new JButton("Tempo Down");
		tempoDown.addActionListener(new MyTempoDownListener());
		buttonBox.add(tempoDown);
		
		
		// names into nameBox (WEST)
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < 16; i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);
		
		theFrame.getContentPane().add(background);
		
		// checkBoxes (CENTER)
		GridLayout grid = new GridLayout(16,16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);
		
		// put checkBoxes into mainPanel
		for (int i = 0; i < 256; i++) {
			JCheckBox c= new JCheckBox();
			c.setSelected(false);
			checkBoxList.add(c);
			mainPanel.add(c);
		}
		
		setUpMidi();
		
		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
		
	}	// end buildGUI
	
	// setUpMidi method
	public void setUpMidi() {
		try {
			player = MidiSystem.getSequencer();
			player.open();
			seq = new Sequence(Sequence.PPQ, 4);
			track = seq.createTrack();
			player.setTempoInBPM(120);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	// buildTrackAndStart method
	public void buildTrackAndStart() {
		int[] trackList = null;
		seq.deleteTrack(track);
		track = seq.createTrack();
		
		for (int i = 0; i < 16; i++) {	// for each of 16 instruments
			trackList = new int[16];
			int key = instruments[i];	// set key for that instrument
			
			for (int j = 0; j < 16; j++) {	// for each of 16 beats
				JCheckBox jc = (JCheckBox) checkBoxList.get(j + 16 * i);
				if (jc.isSelected())
					trackList[j] = key;
				else
					trackList[j] = 0;
			}
			
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
		}
		
		// make sure there is event at beat 16
		track.add(makeEvent(192,9,1,0,15));
		try {
			player.setSequence(seq);
			player.setLoopCount(player.LOOP_CONTINUOUSLY);
			player.start();
			player.setTempoInBPM(120);
		} catch (Exception ex) {ex.printStackTrace(); }
	}
	
	
	
	
	// inner classes to deal with events
	class MyStartListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			buildTrackAndStart();
		}
	}
	
	class MyStopListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			player.stop();
		}
	}
	
	class MyTempoUpListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			float tempoFactor = player.getTempoFactor();
			player.setTempoFactor((float) (1.03 * tempoFactor));
		}
	}
	
	class MyTempoDownListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			float tempoFactor = player.getTempoFactor();
			player.setTempoFactor((float) (0.97 * tempoFactor));			
		}
	}
	
	
	// makeTracks and makeEvent
	public void makeTracks(int[] list) {
		for (int i = 0; i < 16; i++) {
			int key = list[i];
			if (key != 0) {
				// note on
				track.add(makeEvent(144,9,key,100,i));
				// note off
				track.add(makeEvent(128,9,key,100,i+1));
			}
		}
	}
	
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			// what to do
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			// when to do
			event = new MidiEvent(a, tick);
		} catch (Exception ex) {
			ex.printStackTrace(); 
		}
		
		return event;
	}
	
}	// end class BeatBox