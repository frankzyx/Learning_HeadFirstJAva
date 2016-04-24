// multiple widgets
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class SimpleGui2 implements ActionListener {
	
	JFrame frame;
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("change color");
		button.addActionListener(this);
		
		MyDrawPanel panel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		
		frame.setSize(300,300);
		frame.setVisible(true);	
	}
	
	// remember to override abstract methods in the interface ActionListener
	public void actionPerformed(ActionEvent e) {
		// draw again when clicked button
		frame.repaint();
	}
	
	public static void main(String[] args) {
		SimpleGui2 gui = new SimpleGui2();
		gui.go();
	}
	
}