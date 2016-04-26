// JTextField

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Text1 {
	
	JTextField field2;
	
	public static void main(String[] args) {
		Text1 gui = new Text1();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		
		JLabel label = new JLabel("Cat's name: ");
		
		JTextField field = new JTextField(10);
		field.setText("(name)");
		field.addActionListener(new fieldListener());
		field.selectAll();
		field2 = new JTextField(10);
		
		panel.add(label);
		panel.add(field);
		panel.add(field2);
		
		frame.setContentPane(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
	}
	
	class fieldListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			field2.setText("HAHA");
		}
	}
}