// Classes and objects - 1

// real class
class Dog {
	// instance variables
	int size;
	String breed;
	String name;
	// methods
	void bark() {
		System.out.println("Ruff! Ruff!");
	}
}

// tester class
class DogTestDrive {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.size = 40;
		d.bark();
	}
}