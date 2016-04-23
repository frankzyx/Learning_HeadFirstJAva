// Handle or Declare exceptions

class Washer {
	Laundry ld = new Laundry();
	
	public void foo() throws ClothingException {
		ld.doLaundry();
	}
	
	public static void main(String[] args) throws ClothingException {
		Washer ws = new Washer();
		ws.foo();
	}
}

class Laundry {
	public void doLaundry() throws ClothingException {
		throw new ClothingException();
	}
}

class ClothingException extends Exception {}