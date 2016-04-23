// multiple widgets
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class SimpleGui2 implements ActionListener {
	
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