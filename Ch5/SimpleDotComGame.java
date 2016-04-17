// SimpleDotCom

class SimpleDotCom {
	private int[] locationCells;
	private int numOfHits = 0;
	
	public String checkYourself(String StringGuess) {
		// convert a String to int first
		int guess = Integer.parseInt(StringGuess);
		String result = "miss";
		
		for (int cell : locationCells) {
			if (guess == cell) {
				result = "hit";
				numOfHits++;
				break;
			}
		}
		
		if (numOfHits == locationCells.length) {
			result = "kill";
		}
		System.out.println(result);
		return result;
	}
	
	public void setLocationCells(int[] loc) {
		locationCells = loc;
	}
}

class SimpleDotComGame {
	int numOfGuesses = 0;
	boolean isGameOver = false;
	
	public void startGame() {
		SimpleDotCom dot = new SimpleDotCom();
		GameHelper helper = new GameHelper();
		
		// random number between 0 and 4
		int initialPoint = (int) (Math.random() * 5);
		int[] locations = {initialPoint, initialPoint+1, initialPoint+2};
		dot.setLocationCells(locations);
		
		while(!isGameOver) {
			String guess = helper.getUserInput("enter a number: ");
			String result = dot.checkYourself(guess);
			numOfGuesses++;
			if (result.equals("kill")) {
				isGameOver = true;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
		}
	}
	
	public static void main(String[] args) {
		SimpleDotComGame game = new SimpleDotComGame();
		game.startGame();
	}
}