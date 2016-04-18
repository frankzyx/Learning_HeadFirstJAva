public class AnimalTests {
	public static void main(String[] args) {
		Animal a = new Cat();
		
		a.sleep();
		a.sleep();
		a.makeNoise();
		a.getHunger();
		a.eat();
		a.getHunger();
		a.roam();
		System.out.println();
		
		// test constructors
		Pet c = new Dog("Max");
		c.beFriendly();
		c.play();
		
		
	}
}