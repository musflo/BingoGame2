
public class Card {

	public static int length;
	final int[] BColumn;
	final int[] IColumn;
	final int[] NColumn;
	final int[] GColumn;
	final int[] OColumn;

	public Card() {
		BColumn = Utility.uniqueArrayInt(5, 1, 15);
		IColumn = Utility.uniqueArrayInt(5, 16, 30);
		NColumn = Utility.uniqueArrayInt(5, 31, 45);
		NColumn[2] = -1; // Free space
		GColumn = Utility.uniqueArrayInt(5, 46, 60);
		OColumn = Utility.uniqueArrayInt(5, 61, 75);
	}

}
