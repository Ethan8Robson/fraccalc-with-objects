// Ethan Robson
// Started January 13, 2020
// Fraction object, used by FracCalc client code

package fracCalc;

public class Fraction {
	private int whole;
	private int numerator;
	private int denominator;

	public Fraction(String frac) {
		// Separates the fraction into numerator, denominator, and whole
		denominator = 1;
		String fraction = frac;
		if (!frac.contains("/")) {
			whole = Integer.parseInt(frac);
		}
		if (frac.contains("_")) {
			whole = Integer.parseInt(frac.substring(0, frac.indexOf("_")));
			fraction = frac.substring(frac.indexOf("_")+1);
		}
		if (frac.contains("/")) {
			String[] separateNumDen = fraction.split("/");
			numerator = Integer.parseInt(separateNumDen[0]);
			denominator = Integer.parseInt(separateNumDen[1]);
		}
	}

	public Fraction(int whole, int num, int den) {
		// Assigns the fraction into numerator, denominator, and whole
		this.whole = whole;
		this.numerator = num;
		this.denominator = den;
	}
	
	public void toMixedNum() {
		// Converts the fraction to a mixed number.
		whole = numerator / denominator;
		numerator = (numerator % denominator);
	}
	
	public void toImproperFrac() {
		// Converts the number to an improper fraction.
		if (whole >= 0) {
			numerator = denominator * whole + numerator;
		} else {
			numerator = denominator * whole - numerator;
		}
		whole = 0;
	}
	
	public void reduceFrac() {
		// Runs a for-loop to find the simplest fraction.
		int gcf = 1;
		for (int i = 1; i <= Math.max(Math.abs(numerator), Math.abs(denominator)); i++) {
			if (numerator % i == 0 && denominator % i == 0) {
				gcf = i;
			}
		}
		numerator = numerator / gcf;
		denominator = denominator / gcf;
	}
	
	public String toString() {
		// Returns the fraction in thew form of a string.
		if (numerator == 0) {
			return whole + "";
		}
		if (whole == 0) {
			return numerator + "/" + denominator;
		}
		return whole + "_" + numerator + "/" + denominator;
	}
	
	public void multiply(Fraction frac) {
		// Multiplies the fractions together
		numerator = numerator * frac.getNumerator();
		denominator = denominator * frac.getDenominator();
	}
	
	public void divide(Fraction frac) {
		// Divides the fractions.
		numerator = numerator * frac.getDenominator();
		denominator = denominator * frac.getNumerator();
	}
	
	public void add(Fraction frac) {
		// Adds the two fractions.
		numerator = (numerator * frac.getDenominator()) + (frac.getNumerator() * denominator);
		denominator = (denominator * frac.getDenominator());
	}

	public void subtract(Fraction frac) {
		// Subtracts the two fractions.
		numerator = (numerator * frac.getDenominator()) - (frac.getNumerator() * denominator);
		denominator = (denominator * frac.getDenominator());
	}
	public int getNumerator() {
		// Retrieves the numerator.
		return numerator;
	}
	
	public int getDenominator() {
		// Retrieves the denominator.
		return denominator;
	}
	
	public int getWhole() {
		// Retrieves the whole.
		return whole;
	}
	
	public void setNumerator(int num) {
		// Sets the numerator.
		numerator = num;
	}
	
	public void setDenominator(int den) {
		// Sets the denominator.
		denominator = den;
	}
	
	public void setWhole(int wholeNum) {
		// Sets the whole.
		whole = wholeNum;
	}
	
	public void negativeChecker() {
		// Checker for if negative is in wrong place(ex. when it is in the denominator).
		if (whole < 0) {
			numerator = Math.abs(numerator);
			denominator = Math.abs(denominator);
		} else if (whole > 0) {
			if (numerator < 0 && denominator < 0) {
				numerator = Math.abs(numerator);
				denominator = Math.abs(denominator);
			}
		} else if (denominator < 0 && numerator > 0) {
			numerator *= -1;
			denominator *= -1;
		}
	}
	
}
