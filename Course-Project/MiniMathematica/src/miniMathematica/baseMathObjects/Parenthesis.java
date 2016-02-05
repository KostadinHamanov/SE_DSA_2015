package miniMathematica.baseMathObjects;

public class Parenthesis extends BaseMathObject {
	
	public static final String LEFT_PARENTHESIS_SIGN = "(";
	public static final String RIGHT_PARENTHESIS_SIGN = ")";

	public Parenthesis(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return name;
	}

}
