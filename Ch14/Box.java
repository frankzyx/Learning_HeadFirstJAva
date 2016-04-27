// serialization

import java.io.*;	// io package

// implement Serializable interface to make the class serializable
public class Box implements Serializable {
	
	private int width;
	private int height;
	
	public void setWidth(int w) {
		width = w;
	}
	
	public void setHeight(int h) {
		height = h;
	}
	
	public static void main(String[] args) {
		Box myBox = new Box();
		myBox.setWidth(50);
		myBox.setHeight(20);
		
		try {
			// connection stream
			FileOutputStream fs = new FileOutputStream("foo.ser");
			
			// object
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(myBox);
			os.close();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
} 