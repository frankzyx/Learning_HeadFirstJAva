// wildcards

import java.util.*;

public class TestGenerics {
	
	public static void main(String[] args) {
		new TestGenerics().go();
	}
	
	public void go() {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog());
		animals.add(new Cat());
		takeAnimals(animals);
	}
	
	public <T extends Animal> void takeAnimals(ArrayList<T> animals) {
		for (Animal a : animals) {
			a.eat();
		}
	}
}

abstract class Animal {
	void eat() {
		System.out.println("animal eating");
	}
}

class Dog extends Animal {}
class Cat extends Animal {}