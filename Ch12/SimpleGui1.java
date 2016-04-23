// first GUI

import javax.swing.*; 		// for GUI


public class SimpleGui1 {
	public static void main(String[] args) {
		// create a frame
		JFrame frame = new JFrame();
		// create widgets, like button
		JButton button = new JButton("click me");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add widgets to frame
		frame.getContentPane().add(button);
		// display it
		frame.setSize(300, 300);		// in pixels
		frame.setVisible(true);
	}
	
}