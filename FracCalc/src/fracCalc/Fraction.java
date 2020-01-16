// Ethan Robson
// Started January 13, 2020
// Fraction object, used by FracCalc client code

package fracCalc;

public class Fraction {
	private int whole;
	private int numerator;
	private int denominator;

	public Fraction(String frac) {
		if (!frac.contains("/")) {
			whole = Integer.parseInt(frac);
		}
		if (frac.contains("_")) {
			whole = Integer.parseInt(frac.substring(0, frac.indexOf("_")));
		}
		if (frac.contains("/")) {
			numerator = Integer.parseInt(frac.substring(frac.indexOf("/") - 1, frac.indexOf("/")));
			denominator = Integer.parseInt(frac.substring(frac.indexOf("/"), frac.indexOf("/") + 1));
		}
	}

	public Fraction(int whole, int num, int den) {
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
		for (int i = 1; i <= denominator; i++) {
			if (numerator % i == 0 && denominator % i == 0) {
				gcf = i;
			}
		}
		numerator = numerator / gcf;
		denominator = denominator / gcf;
	}
	
	public String toString(int integer) {
		return integer + "";
	}
	
	public void multiply(Fraction frac) {
		numerator = numerator * frac.getNumerator();
		denominator = denominator * frac.getDenominator();
	}
	
	public void divide(Fraction frac) {
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
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public int getWhole() {
		return whole;
	}
	
	

}
