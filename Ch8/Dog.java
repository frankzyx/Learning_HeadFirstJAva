public class Dog extends Canine implements Pet {
	

	public Dog() {
		System.out.println("Making a dog");
	}

	public Dog(String nm) {
		super(nm);
		System.out.println("Making an dog with a name");
	}	

	
	public void makeNoise() {
		System.out.println("Ruff! Ruff!");
	}
	
	public void beFriendly() {
		System.out.println("I'm a friendly dog");
	}
	
	public void play() {
		System.out.println("Let's play ball outside");
	}
}