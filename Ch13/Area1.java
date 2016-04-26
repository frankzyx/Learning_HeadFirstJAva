// JTextArea

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Area1 {
	
	JTextArea area;
	JCheckBox check;

	static int count = 0;
	
	public static void main(String[] args) {
		Area1 gui = new Area1();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// button
		JButton button = new JButton("Click me");
		button.addActionListener(new ButtonListener());
		
		// panel
		JPanel panel = new JPanel();
		
		// new text area on panel
		area = new JTextArea(10,20);
		area.setLineWrap(true);
		// give the text area to the scroll pane!!!
		JScrollPane scroller = new JScrollPane(area);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// and only add the scroller
		panel.add(scroller);
		
		// check box
		check = new JCheckBox("double increment");
		check.addItemListener(new CheckListener());
		check.setSelected(false);
		
		frame.getContentPane().add(BorderLayout.CENTER, check);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (check.isSelected())
				count += 2;
			else
				count++;
			area.append(count+"\n");
		}
	}
	
	class CheckListener implements ItemListener {
		public void itemStateChanged(ItemEvent ev) {
			String status = "off";
			if (check.isSelected())  status = "on";
			area.append("CheckBox is " + status + "\n");
		}
	}
	
}