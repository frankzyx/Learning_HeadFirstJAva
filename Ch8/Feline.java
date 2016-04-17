abstract public class Feline extends Animal {
	
	
	public abstract void makeNoise();
	public void eat() {
		hunger -= 3;
		if (hunger < 0) {
			hunger = 0;
		}
	}

	public void roam() {
		System.out.println("I'm roaming around on my own...");
	}
}