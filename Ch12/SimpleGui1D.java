// drawing widgets

import java.awt.*;
import javax.swing.*;

class SimpleGui1D {
	public void go() {
		JFrame frame = new JFrame();
		MyDrawPanel panel = new MyDrawPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		
		frame.setSize(300,300);
		frame.setVisible(true);	
	}
	
	public static void main(String[] args) {
		SimpleGui1D gui = new SimpleGui1D();
		gui.go();
	}
	
}

class MyDrawPanel extends JPanel {
	// override paintComponent(Graphics g) for different purposes
	// now draw random color circle
	public void paintComponent(Graphics g) {
		// fill with black (default color)
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color randColor = new Color(red, green, blue);
		g.setColor(randColor);
		g.fillOval(70,70,100,100);
	}
}