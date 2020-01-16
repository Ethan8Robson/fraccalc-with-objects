// Ethan Robson
// Started January 13, 2020
// Fraction calculator


package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// Asks for user input and calls the methods.
		Scanner scan = new Scanner(System.in);
		String decision = "";
		do {
			System.out.println("What do you want to input?");
			System.out.println(produceAnswer(scan.nextLine()));
			System.out.println("Do you want to quit? (Type \"quit\" to quit)");
			decision = scan.nextLine();
		} while (!decision.toUpperCase().equals("QUIT"));
		scan.close();
	}

	public static String produceAnswer(String input) {
		
		return "";
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
