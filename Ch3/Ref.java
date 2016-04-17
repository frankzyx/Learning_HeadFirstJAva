// an array is an object

class Cat {
	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(int a) {
		if (a > 0) 
			age = a;
		else
			System.out.println("Invalid age!");
	}
	public void setName(String n) {
		name = n;
	}
	
	
	void meow() {
		System.out.println("I'm " + name);
		System.out.println("meow!");
	}
	void hiss() {
		System.out.println("I'm " + name);
		System.out.println("HA!!!");
	}
}


public class Ref {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = 2 * i + 1;
			System.out.println(arr[i]);
		}
		
		Cat[] catArr = new Cat[2];
		catArr[0] = new Cat();
		catArr[1] = new Cat();
		catArr[0].setAge(7);
		catArr[0].setName("Reba");
		catArr[1].setAge(2);
		catArr[1].setName("Berry");
		catArr[0].meow();
		catArr[1].hiss();
	}
}