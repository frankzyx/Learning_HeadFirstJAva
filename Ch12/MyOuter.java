// inner class

class MyOuter {
	private int x;
	
	MyInner inner = new MyInner();
	
	public void doStuff() {
		inner.go();
		System.out.println("x = " + x);
	}
	
	
	class MyInner {
		void go() {
			x = 42;
		}
	}
	
	public static void main(String[] args) {
		MyOuter outer = new MyOuter();
		outer.doStuff();
	}
}