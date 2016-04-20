// Wrappers
// treat a primitive as an object
import java.util.ArrayList;

public class autoBox {
	public void doOldWay() {
		ArrayList list = new ArrayList();
		list.add(new Integer(3));
		Integer one = (Integer) list.get(0);
		int intOne = one.intValue();
		System.out.println("intOne = " + intOne);
	}
	
	public void doNewWay() {
		// must be Integer, not int!
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5); 	// can pass int or Integer object
		int num = list.get(0);
		System.out.println("num = " + num);
	}
	
	public static void main(String[] args) {
		autoBox a = new autoBox();
		a.doOldWay();
		a.doNewWay();
	}
}