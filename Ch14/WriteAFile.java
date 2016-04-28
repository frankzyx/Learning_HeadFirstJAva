// write to a text file
// use FileWriter to output String

import java.io.*;

class WriteAFile {
	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("Foo1.txt");
			writer.write("hello foo!");
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
}