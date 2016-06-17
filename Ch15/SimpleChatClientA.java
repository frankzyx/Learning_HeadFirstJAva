// a chat client

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClientA {
	
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public void go() {
		// make gui
		JFrame frame = new JFrame("Simple Chat Client");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new sendButtonListener());
		
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		
		setUpNetworking();
		
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
	
	private void setUpNetworking() {
		try {
			sock = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("Networking established");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	// inner class for listeners
	public class sendButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			try {
				writer.println(outgoing.getText());
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new SimpleChatClientA().go();
	}
}