// maps
// could have duplicate values, but no same keys
import java.util.*;

public class TestMap {
	
	public static void main(String[] args) {
		new TestMap().go();
	}
	
	public void go() {
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("Corgi", 20);
		scores.put("Husky", 40);
		scores.put("Golden", 90);
		
		System.out.println(scores);
		System.out.println(scores.get("Husky"));
	}
}