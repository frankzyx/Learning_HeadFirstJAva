// abstract

abstract public class Animal {
	protected int age;
	protected String name;
	protected int hunger = 10;
	
	public void getHunger() {
		System.out.println("hunger = " + hunger);
	}
	
	public abstract void makeNoise();
	public abstract void eat();
	public void sleep() {
		hunger += 5;
	}
	public void roam() {
		System.out.println("I'm roaming around");
	}
}