public class Hippo extends Animal {
	public Hippo() {
		this("defaultHippo");
	}
	
	public Hippo(String nm) {
		super(nm);
		System.out.println("Making a hippo");
	}
	
	public void makeNoise() {
		System.out.println("Hippo...Hippo...");
	}
	public void eat() {
		hunger = 0;
	}
}