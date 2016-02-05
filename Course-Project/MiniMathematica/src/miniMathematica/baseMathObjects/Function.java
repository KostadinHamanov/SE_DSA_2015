package miniMathematica.baseMathObjects;

import javafx.util.Pair;

public class Function extends OperatorBase {

	public static final String FUNCTION_ARGUMENT_SEPARATOR = ",";

	public Function(String name, int numberOfArguments) {
		super(name, numberOfArguments);
	}

	public static Function parseFunction(String possibleFunction) {
		Function func = null;

		if (FunctionsEnum.POW.getName().equals(possibleFunction)) {
			func = new Function(possibleFunction, FunctionsEnum.POW.getNumberOfArgument());
			
		} else if (FunctionsEnum.SQRT.getName().equals(possibleFunction)) {
			func = new Function(possibleFunction, FunctionsEnum.SQRT.getNumberOfArgument());
			
		} else if (FunctionsEnum.LOG.getName().equals(possibleFunction)) {
			func = new Function(possibleFunction, FunctionsEnum.LOG.getNumberOfArgument());
			
		} else if (FunctionsEnum.SIN.getName().equals(possibleFunction)) {
			func = new Function(possibleFunction, FunctionsEnum.SIN.getNumberOfArgument());
			
		} else if (FunctionsEnum.COS.getName().equals(possibleFunction)) {
			func = new Function(possibleFunction, FunctionsEnum.COS.getNumberOfArgument());
			
		} else if (FunctionsEnum.TG.getName().equals(possibleFunction)) {
			func = new Function(possibleFunction, FunctionsEnum.TG.getNumberOfArgument());
			
		} else if (FunctionsEnum.COTG.getName().equals(possibleFunction)) {
			func = new Function(possibleFunction, FunctionsEnum.COTG.getNumberOfArgument());
			
		}  else if (FunctionsEnum.MAX.getName().equals(possibleFunction)) {
			func = new Function(possibleFunction, FunctionsEnum.MAX.getNumberOfArgument());
	
		}  else if (FunctionsEnum.MIN.getName().equals(possibleFunction)) {
			func = new Function(possibleFunction, FunctionsEnum.MIN.getNumberOfArgument());
		}

		return func;
	}
	
	public static Pair<String, Boolean> isFunction(String startSymbol, int startSymbolIndex, String expression) {
		int endIndex = startSymbolIndex + 1;

		while (endIndex < expression.length() && Character.isAlphabetic(expression.charAt(endIndex))) {
			endIndex++;
		}

		String possibleFunctionName = expression.substring(startSymbolIndex, endIndex);
		Pair<String, Boolean> isTokenFunction;

		if (FunctionsEnum.containsFunction(possibleFunctionName)) {
			isTokenFunction = new Pair<String, Boolean>(possibleFunctionName, true);
		} else {
			isTokenFunction = new Pair<String, Boolean>(possibleFunctionName, false);
		}

		return isTokenFunction;
	}

	@Override
	public String toString() {
		return name;
	}

}
