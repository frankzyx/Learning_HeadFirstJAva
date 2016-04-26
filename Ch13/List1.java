// JTextArea

import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class List1 {
	
	JTextArea area;
	JList list;
	static int count = 0;
	
	public static void main(String[] args) {
		List1 gui = new List1();
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
		
		// list
		String[] theList = {"+1", "+2", "+3", "+4", "+5", "+100"};
		list = new JList(theList);
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListListener());
		
		JScrollPane scroller2 = new JScrollPane(list);
		scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.NORTH, scroller2);
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String selection = (String) list.getSelectedValue();
			switch (selection) {
				case "+1" : count++; break;
				case "+2" : count+=2; break;
				case "+3" : count+=3; break;
				case "+4" : count+=4; break;
				case "+5" : count+=5; break;
				case "+100" : count+=100; break;
			}			
			area.append(count+"\n");
		}
	}
	
	class ListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent lse) {
			if (!lse.getValueIsAdjusting()) {
				area.append(list.getSelectedValue() + "\n");
			}
		}
	}
	
}