// polymorphism

public class MyDogList {
	private Dog[] dogs = new Dog[5];
	private int nextIndex = 0;
	
	public void add(Dog d) {
		System.out.println("Dog added at " + nextIndex);
		dogs[nextIndex++] = d;
	}
}