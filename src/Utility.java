import java.util.Scanner;

public class Utility {

	public static int askForInt(Scanner scan, String prompt) {
		do {
			try {
				String answer = Utility.askForString(scan, prompt);
				int number = Integer.parseInt(answer);
				return number;
			} catch (NumberFormatException ex) {
				System.out.println("---Sorry, you must enter an Integer.");
			}
		} while(true);
	}

	public static int askForInt(Scanner scan, String prompt, int min) {
		while (true) {
			int number = askForInt(scan, prompt);
			if (number >= min)
				return number;
			System.out.println("Minimum allowed is " + min);
		}
	}

	public static String askForString(Scanner scan, String prompt) {
		System.out.println(prompt);
		String answer = scan.nextLine();
		return answer;
	}

	public static boolean isUnique(int arr[]) {
	    for (int i = 0; i <= arr.length-2; i++)
	      for (int j = i + 1; j < arr.length; j++)
	        if (arr[i] == arr[j])
	          return false;
	    return true;
	  }

	public static int randBetween(int lower, int upper) {
		return (int) (Math.random() * ((upper-lower) + 1)) + lower;
	}

	public static int[] uniqueArrayInt(int length, int lower, int upper) {
		int[] numbers = new int[length];
		do {
			for (int i = 0; i < numbers.length; i++)
				numbers[i] = randBetween(lower, upper);
		} while (!Utility.isUnique(numbers));
		return numbers;
	}

}
