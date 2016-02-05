package miniMathematica.baseMathObjects;

public class Operator extends OperatorBase {
	protected int associativity;
	protected int precedence;

	public final static int ADDITION_PRECEDENCE = 0;
	public final static int SUBSTRACTION_PRECEDENCE = 0;
	public final static int MULTIPLICATION_PRECEDENCE = 1;
	public final static int DIVISION_PRECEDENCE = 1;
	public final static int NEGATION_PRECEDENCE = 2;
	public final static int EXPONENTIATION_PRECEDENCE = 3;

	public final static int RIGHT_ASSOCIATIVITY = 0;
	public final static int LEFT_ASSOCIATIVITY = 1;
	
	public final static String ADDITION_SIGN = "+";
	public final static String SUBSTRACTION_SIGN = "-";
	public final static String MULTIPLICATION_SIGN = "*";
	public final static String DIVISION_SIGN = "/";
	public final static String NEGATION_SIGN = "-";
	public final static String EXPONENT_SIGN = "^";

	public int getAssociativity() {
		return associativity;
	}

	public void setAssociativity(int associativity) {
		this.associativity = associativity;
	}

	public int getPrecedence() {
		return precedence;
	}

	public void setPrecedence(int precedence) {
		this.precedence = precedence;
	}

	public Operator(String name, int associativity, int precedence, int numberOfArguments) {
		super(name, numberOfArguments);
		this.associativity = associativity;
		this.precedence = precedence;
	}

	public static Operator parseOperator(char symbol, boolean isNegation) {

		Operator op = null;

		if (symbol == '+') {
			op = new Operator(Operator.ADDITION_SIGN, Operator.LEFT_ASSOCIATIVITY, Operator.ADDITION_PRECEDENCE, 2);
			
		} else if (symbol == '-' && isNegation == true) {
			op = new Operator(Operator.NEGATION_SIGN, Operator.RIGHT_ASSOCIATIVITY, Operator.NEGATION_PRECEDENCE, 1);
			
		} else if (symbol == '-') {
			op = new Operator(Operator.SUBSTRACTION_SIGN, Operator.LEFT_ASSOCIATIVITY, Operator.SUBSTRACTION_PRECEDENCE, 2);
			
		} else if (symbol == '*') {
			op = new Operator(Operator.MULTIPLICATION_SIGN, Operator.LEFT_ASSOCIATIVITY, Operator.MULTIPLICATION_PRECEDENCE, 2);
			
		} else if (symbol == '/') {
			op = new Operator(Operator.DIVISION_SIGN, Operator.LEFT_ASSOCIATIVITY, Operator.DIVISION_PRECEDENCE, 2);
			
		} else if (symbol == '^') {
			op = new Operator(Operator.EXPONENT_SIGN, Operator.RIGHT_ASSOCIATIVITY, Operator.EXPONENTIATION_PRECEDENCE, 2);
		}

		return op;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static boolean isOperator(String expression) {
		boolean res = expression.matches("\\+|-|\\/|\\*|\\^");
		return res;
	}
}
