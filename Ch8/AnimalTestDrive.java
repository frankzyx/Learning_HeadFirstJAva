public class AnimalTestDrive {
	public static void main(String[] args) {
		MyAnimalList list = new MyAnimalList();
		Dog d = new Dog();
		Cat c = new Cat();
		Animal t = new Tiger();
		Animal h = new Hippo();
		list.add(d);
		list.add(c);
		list.add(t);
		list.add(h);
	}
}