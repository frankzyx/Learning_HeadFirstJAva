public class Cat extends Feline{
	
	public void makeNoise() {
		System.out.println("Meow");
	}
	
	public void eat() {
		hunger -= 8;
		if (hunger < 0) {
			hunger = 0;
		}
	}
}