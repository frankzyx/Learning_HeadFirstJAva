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
		
		Pet c = new Dog();
		c.beFriendly();
		c.play();
		System.out.println();
		
		// test constructors
		// Hippo constructors called first, finished last (stack: LIFO)
		Hippo h = new Hippo("Buffy");
		
	}
}