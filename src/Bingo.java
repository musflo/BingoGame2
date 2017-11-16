public class Bingo {

	private int[] masterBoard;
	public Card[] cardsCreated;
	private Object lastBallDrawn;
	int ball = 0;
	public Bingo() {
		  // We will ignore index 0
	}

	public void drawBall() {
		
		boolean stillDrawing = true;
		while (stillDrawing) {
			this.ball = Utility.randBetween(1, 75);
			if (!isBallDrawn(ball))
				stillDrawing = false;
		}
		this.masterBoard[ball] = ball;
		this.lastBallDrawn = letterFor(ball) + "-" + ball;
		checkforWinners();
	}

	public boolean checkforWinners(Card cardsCreated) {
	    int count1=0,count2=0,i,j;
	    for(i=0;i < Card.length; i++) {
	        for(j=0;j<Card.length;j++) {
	            if(Card[i][j]==0)
	                count1++;
	            if(Card[j][i]==0)
	                count2++;
	        }
	        if(count1==5)
	        	
	        }
	    	
			
		}
		
	}

	private String letterFor(int ball) {
		if (ball >=1 && ball <=15)
			return "B";
		if (ball >=16 && ball <=30)
			return "I";
		if (ball >=31 && ball <=45)
			return "N";
		if (ball >=46 && ball <=60)
			return "G";
		if (ball >=61 && ball <=75)
			return "O";
		return null;
			
		}
	

	public boolean isBallDrawn(int number) {
			if (number ==-1)
				return true;
			if (masterBoard[number] != 0)
				return true;
		return false;
	}

	public void createBingoCards(int cardsToMake) {
		this.cardsCreated = new Card[cardsToMake];
		for (int i = 0; i < this.cardsCreated.length; i++)
			this.cardsCreated[i] = new Card();
		
	}

	public Object lastBallDrawn() {
		this.lastBallDrawn = letterFor(this.ball) + "-" + ball;
		return this.lastBallDrawn;

	}

	public int[] masterBoard() {
		this.masterBoard = new int[76];
		return null;
	}

	public boolean hasWinner() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object winningCards() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object cards() {
		// TODO Auto-generated method stub
		return null;
	}
}
