import java.util.Scanner;
import java.text.DecimalFormat;

public class BingoUI {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean keepPlaying = true;
		while (keepPlaying) {
			Bingo theGame = new Bingo();
			// displayRules(theGame);
			int cardsToMake = howManyCards();
			theGame.createBingoCards(cardsToMake);
			boolean isBingo = false;
			while (!isBingo) {
			    displayMasterBoard(theGame);
				Utility.askForString(scan, "Press Enter to draw the next Ball");
				theGame.drawBall();
				announceLastBall(theGame);
				if (theGame.hasWinner()) {
				    isBingo = true;
					System.out.println();
					System.out.println("BINGO!  We have " + theGame.winningCards().size() + " winners.");
					displayWinningCards(theGame);
				} else {
					System.out.println("No winners yet out of " + theGame.cards().length + " cards");
				}
			}
			keepPlaying = playAgain();
		}
		System.out.println("Thank you for playing");
		scan.close();
	}

	private static void announceLastBall(Bingo theGame) {
		System.out.println("The last ball drawn was: " + theGame.lastBallDrawn());
	}

	private static void displayCard(Bingo theGame, Card card) {
		System.out.println();
		System.out.println("Here is a winning card");
		System.out.println(" B    I    N    G    O");
		// #TODO format two digits
		for (int i = 0; i < card.BColumn.length; i++) {
			System.out.print(formatCardNumber(card.BColumn[i], theGame.isBallDrawn(card.BColumn[i])));
			System.out.print(formatCardNumber(card.IColumn[i], theGame.isBallDrawn(card.IColumn[i])));
			System.out.print(formatCardNumber(card.NColumn[i], theGame.isBallDrawn(card.NColumn[i])));
			System.out.print(formatCardNumber(card.GColumn[i], theGame.isBallDrawn(card.GColumn[i])));
			System.out.print(formatCardNumber(card.OColumn[i], theGame.isBallDrawn(card.OColumn[i])));
			System.out.println();
		}
		System.out.println();
	}

	private static void displayMasterBoard(Bingo theGame) {
		System.out.println();
		System.out.println("Here are all the drawn balls");
		System.out.println("B\tI\tN\tG\tO");
		for (int i=1; i<=15; i++) {
			formatMasterBoardNumber(theGame.masterBoard()[i]);
			formatMasterBoardNumber(theGame.masterBoard()[i+15]);
			formatMasterBoardNumber(theGame.masterBoard()[i+30]);
			formatMasterBoardNumber(theGame.masterBoard()[i+45]);
			formatMasterBoardNumber(theGame.masterBoard()[i+60]);
			System.out.println();
		}
		System.out.println();
	}

	private static void displayWinningCards(Bingo theGame) {
		for (WinningCard winner : theGame.winningCards()) {
			System.out.println("This card won by: " + winner.winningRule);
			displayCard(theGame, winner.card());
		}
	}


	private static String formatCardNumber(int number, boolean isBallDrawn) {
		if (number == -1)
			return "Free ";
		String formattedNumber = (new DecimalFormat("00").format(number));
		if (isBallDrawn)
			return "(" + formattedNumber + ") ";
		return " " + formattedNumber + "  ";
	}


	private static void formatMasterBoardNumber(int number) {
		if (number == 0)
			System.out.print("--\t");
		else
			System.out.print((new DecimalFormat("00").format(number)) + "\t");
	}

	private static int howManyCards() {
		int cardsToMake = Utility.askForInt(scan, "How many Bingo cards do you want to play?", 1);
		return cardsToMake;
	}

	private static boolean playAgain() {
		System.out.println();
		String again = Utility.askForString(scan, "Play Again (Y/N)?");
		return again.toLowerCase().equals("y");
	}

}
