public class Formats {
	public void str2num() {
		String s1 = "1";
		int x1 = Integer.parseInt(s1);
		System.out.println(x1);
		
		String s2 = "3.14";
		double x2 = Double.parseDouble(s2);
		System.out.println(x2);
	}
	
	public void num2str() {
		double d = 42.5;
		// Anything added to a String becomes Stringified...
		String doubleString = "" + d;
		System.out.println(doubleString);
	}
	
	public static void main(String[] args) {
		Formats fm = new Formats();
		fm.str2num();
		fm.num2str();
	}
}