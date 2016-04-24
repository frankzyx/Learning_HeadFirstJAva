// animation using inner class

import java.awt.*;
import javax.swing.*;

public class SimpleAnimation {
	
	int x = 70;
	int y = 70;
	
	public static void main(String[] args) {
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}
		
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawPanel panel = new DrawPanel();
		
		frame.getContentPane().add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		// real animation
		for (int i = 0; i < 100; i++) {
			x++;
			y++;
			panel.repaint();
			try {
				Thread.sleep(50);
			} catch (Exception ex) {}
		}
	}
	
	// inner class
	
	class DrawPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.green);
			g.fillOval(x,y,200-x,200-y);
		}
	}
	
}