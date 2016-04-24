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