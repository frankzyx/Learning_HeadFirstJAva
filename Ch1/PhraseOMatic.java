public class PhraseOMatic {
	public static void main(String[] args) {
		// make 3 sets of words to choose from
		String[] wordListOne = {"24/7", "multi-Tier", "30,000 foot", "B-to-B", "win-win", "front-end", "web-based", "pervasive", "smart", "six-sigma", "critical-path", "dynamic" };
		String[] wordListTwo = {"empowered", "sticky", "value-added", "oriented", "centric", "focused", "targeted", "cooperative", "accelerated", "leveraged", "shared", "branded"};
		String[] wordListThree = {"process", "tipping-point", "solution", "architecture", "core competency", "strategy", "mindshare", "portal", "space", "vision", "paradigm", "mission"};
		
		int oneLen = wordListOne.length;
		int twoLen = wordListTwo.length;
		int threeLen = wordListThree.length;
		
		int rand1 = (int) (Math.random() * oneLen);
		int rand2 = (int) (Math.random() * twoLen);
		int rand3 = (int) (Math.random() * threeLen);
		
		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
		System.out.println("What we need is " + phrase);
	}
}