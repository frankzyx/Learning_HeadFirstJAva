public class AnimalTests {
	public static void main(String[] args) {
		Animal a = new Dog();
		a.getName();
		a.sleep();
		a.sleep();
		a.makeNoise();
		a.getHunger();
		a.eat();
		a.getHunger();
		a.roam();
		System.out.println();
		
		// test interface
		Pet c = new Dog("Max");
		c.beFriendly();
		c.play();
		System.out.println();
		
		Animal d = new Dog("Max");
		d.getName();
		System.out.println();
		
		// Hippo constructors called first, finished last (stack: LIFO)
		Animal h = new Hippo("Buffy");
		h.getName();
		
	}
}