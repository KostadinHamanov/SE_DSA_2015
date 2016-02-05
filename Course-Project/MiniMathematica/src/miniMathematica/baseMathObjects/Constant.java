package miniMathematica.baseMathObjects;

import javafx.util.Pair;

public class Constant extends BaseMathObject {

	private double value;
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public Constant(String name) {
		super(name);
		this.setValue(ConstantEnum.getConstantEntryByName(name).getValue());
	}
	
	public Constant(Double value) {
		super(String.valueOf(value));
		this.value = value;
	}
	
	public static Pair<String, Boolean> isConstant(String startSymbol, int startSymbolIndex, String expression) {
		int endIndex = startSymbolIndex + 1;

		while (endIndex < expression.length() && Character.isAlphabetic(expression.charAt(endIndex))) {
			endIndex++;
		}

		String possibleConstantName = expression.substring(startSymbolIndex, endIndex);
		Pair<String, Boolean> isTokenConstant;
		
		if (ConstantEnum.containsConstant(possibleConstantName)) {
			isTokenConstant = new Pair<String, Boolean>(possibleConstantName, true);
		} else {
			isTokenConstant = new Pair<String, Boolean>(possibleConstantName, false);
		}

		return isTokenConstant;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
