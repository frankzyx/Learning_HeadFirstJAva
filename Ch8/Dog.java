public class Dog extends Canine implements Pet {
	

	public Dog() {
		this("defaultDog");
	}

	public Dog(String nm) {
		super(nm);
		System.out.println("Making an dog");
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