public class Cat extends Feline implements Pet {
	
	public void makeNoise() {
		System.out.println("Meow");
	}
	
	public void eat() {
		hunger -= 8;
		if (hunger < 0) {
			hunger = 0;
		}
	}
	
	public void roam() {
		super.roam();
		System.out.println("'cause I'm a kitty");
	}
	
	public void beFriendly() {
		System.out.println("I'm a nice cat");
	}
	
	public void play() {
		System.out.println("Let's play hide-and-seek");
	}
	
}