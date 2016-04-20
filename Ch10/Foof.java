// final

public class Foof {
	public static final int FOOX;
	public final int size = 3;
	final int x = 12;
	
	// this runs as soon as class is loaded
	static {
		FOOX = 42;
	}
	
	public void go(final int x) {
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		System.out.println("FOOX = " + FOOX);
	}
	
}