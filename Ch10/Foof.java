// final

public class Foof {
	public static final int FOOX;
	public final int size = 3;
	
	// this runs as soon as class is loaded
	static {
		FOOX = 42;
	}
	
	public static void main(String[] args) {
		System.out.println("FOOX = " + FOOX);
	}
	
}