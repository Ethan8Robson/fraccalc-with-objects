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
		// Creates the fractions, calls the methods to do the calculations and returns the answer.
		String[] answer = input.split(" ");
		Fraction separateFrac1 = new Fraction(answer[0]);
		Fraction separateFrac2 = new Fraction(answer[2]);
		separateFrac1.toImproperFrac();
		separateFrac2.toImproperFrac();
		String returnAnswer = "";
		if (answer[1].equals("*") == true) {
			separateFrac1.multiply(separateFrac2);
		} else if (answer[1].equals("/") == true) {
			separateFrac1.divide(separateFrac2);
		} else if (answer[1].equals("+") == true) {
			separateFrac1.add(separateFrac2);
		} else if (answer[1].equals("-") == true) {
			separateFrac1.subtract(separateFrac2);
		}
		separateFrac1.reduceFrac();
		separateFrac1.toMixedNum();
		separateFrac1.negativeChecker();
		returnAnswer = separateFrac1.toString();
		return returnAnswer;
	}

}
