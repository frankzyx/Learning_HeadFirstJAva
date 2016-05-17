import java.util.*;

public class TestTree {
	public static void main(String[] args) {
		new TestTree().go();
	}
	
	public void go() {
		Book b1 = new Book("How cats work");
		Book b2 = new Book("Remix your body");
		Book b3 = new Book("Finding emo");
		
		TreeSet<Book> tree = new TreeSet<Book>();
		tree.add(b1);
		tree.add(b2);
		tree.add(b3);
		System.out.println(tree);
	}
	

}

class Book implements Comparable<Book> {
	String title;
	Book(String t) {
		title = t;
	}
	
	public int compareTo(Book book) {
		Book b = (Book) book;
		return title.compareTo(b.title);
	}
}