// Layout Manager
// Frame: BorderLayout

import javax.swing.*;
import java.awt.*;

public class Button1 {
	
	public static void main(String[] args) {
		Button1 gui = new Button1();
		gui.go();
	} 
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("click like you mean it");
		frame.getContentPane().add(BorderLayout.EAST, button);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}