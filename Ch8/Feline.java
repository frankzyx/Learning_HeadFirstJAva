abstract public class Feline extends Animal {
	
	
	public abstract void makeNoise();
	public void eat() {
		hunger -= 3;
		if (hunger < 0) {
			hunger = 0;
		}
	}

	public void roam() {
		super.roam();
		System.out.println("But...On my own...");
	}
}