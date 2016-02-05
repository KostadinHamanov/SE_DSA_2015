package miniMathematica.baseMathObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number extends BaseMathObject {

	private double value;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Number(String name) {
		super(String.valueOf(name));
		this.value = Double.parseDouble(name);
	}
	
	public Number(Double value) {
		super(String.valueOf(value));
		this.value = value;
	}

	public static boolean isNumber(String expression) {
//		String numberRegExpr = "-\\d+(\\.\\d+)?";
		String numberRegExpr = "([-+]?\\d+(\\.?\\d+)?)([Ee][+-]?\\d+)?";
		Pattern numberPattern = Pattern.compile(numberRegExpr);
		Matcher numberMatcher = numberPattern.matcher(expression);

		return numberMatcher.matches();
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
