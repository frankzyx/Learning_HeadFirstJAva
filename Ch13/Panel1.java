// Panel: FlowLayout

import javax.swing.*;
import java.awt.*;

public class Panel1 {
	
	public static void main(String[] args) {
		Panel1 gui = new Panel1();
		gui.go();
	} 
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		// use BoxLayout on panel for vertical alignment
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		// add a button to the panel
		JButton button = new JButton("shock me");
		panel.add(button);
		
		// another button
		JButton button2 = new JButton("bliss");
		panel.add(button2);
		
		JButton button3 = new JButton("huh?");
		panel.add(button3);
		
		// still BorderLayout on frame...
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}