import java.util.Date;
import java.util.Calendar;

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
	
	public void formatting() {
		String s = String.format("The rank is %,d out of %,.2f", 20256543, 100567890.25234);
		System.out.println(s);
		// dates
		String date1 = String.format("%tc", new Date());
		System.out.println(date1);
		
		Date today = new Date();
		String date2 = String.format("%tA, %<tB %<td", today);
		System.out.println(date2);
	}
	
	public void calendar() {
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 11, 21, 3, 14, 15);		// month is zero-based
		System.out.println(cal.getTime());
		cal.add(cal.DATE, 35);
		System.out.println("add 35 days: " + cal.getTime());
	}
	
	public static void main(String[] args) {
		Formats fm = new Formats();
		fm.str2num();
		fm.num2str();
		System.out.println();
		fm.formatting();
		System.out.println();
		fm.calendar();
	}
}