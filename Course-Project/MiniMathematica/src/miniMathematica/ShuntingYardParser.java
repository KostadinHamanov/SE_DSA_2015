package miniMathematica;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import miniMathematica.baseMathObjects.BaseMathObject;
import miniMathematica.baseMathObjects.Constant;
import miniMathematica.baseMathObjects.Function;
import miniMathematica.baseMathObjects.Number;
import miniMathematica.baseMathObjects.Operator;
import miniMathematica.baseMathObjects.OperatorBase;
import miniMathematica.baseMathObjects.Parenthesis;

public class ShuntingYardParser {
	private Stack<BaseMathObject> operatorStack;
	private Queue<BaseMathObject> outputRPN;

	public Queue<BaseMathObject> getOutputRPN() {
		return outputRPN;
	}

	public void setOutputRPN(Queue<BaseMathObject> outputRPN) {
		this.outputRPN = outputRPN;
	}

	public Stack<BaseMathObject> getOperatorStack() {
		return operatorStack;
	}

	public void setOperatorStack(Stack<BaseMathObject> operatorStack) {
		this.operatorStack = operatorStack;
	}

	public ShuntingYardParser() {
		this.operatorStack = new Stack<>();
		this.outputRPN = new LinkedList<>();
	}

	/**
	 * Parsing the expressing entered by user using "Shunting Yard" algorithm
	 * The output expression in reverse polish notation
	 * @param inputString
	 * @exception IllegalArgumentException - if the user enters an invalid input
	 */
	public void convertInput(String inputString) {
		String input = new String(inputString.replaceAll("\\s+", "")
				.replaceAll("^\\+", "")
				.toLowerCase());

		int expressionLength = input.length();

		for (int i = 0; i < expressionLength; i++) {

			char symbol = input.charAt(i);

			// Check for a number
			if (Character.isDigit(symbol)) {
				int startIndex = i;
				int endIndex = i + 1;

				while (endIndex < expressionLength
						&& (input.charAt(endIndex) == '.' || Character.isDigit(input.charAt(endIndex)))) {
					endIndex++;
				}

				String numberString = input.substring(startIndex, endIndex);

				if (Number.isNumber(numberString)) {
					Number realNumber = new Number(numberString);
					this.outputRPN.add(realNumber);
					i = endIndex - 1;

				} else {
					throw new IllegalArgumentException("Not a valid number!");
				}

			}
			// Check for left parenthesis
			else if (symbol == '(') {
				this.operatorStack.add(new Parenthesis(Parenthesis.LEFT_PARENTHESIS_SIGN));
			}
			// Check for right parenthesis
			else if (symbol == ')') {
				while (!operatorStack.isEmpty() && !operatorStack.peek().getName().equals(Parenthesis.LEFT_PARENTHESIS_SIGN)) {
					if (operatorStack.peek() instanceof OperatorBase) {
						int numberOfArguments = ((OperatorBase) operatorStack.peek()).getNumberOfArguments();
						outputRPN.add(new OperatorBase(operatorStack.pop().getName(), numberOfArguments));
					}
				}

				if (operatorStack.isEmpty()) {
					throw new IllegalArgumentException("Mismatched parentheses");
				}

				operatorStack.pop();

				if (!operatorStack.isEmpty() && operatorStack.peek() instanceof Function) {
					Function func = (Function) operatorStack.pop();
					this.outputRPN.add(func);
				}
			}
			// Check for an operator
			else if (Operator.isOperator(String.valueOf(symbol))) {
				
				//Check if the operator is negation
				boolean isNegation = false;
				
				if (i == 0) { 
					isNegation = true;
				} else if (i > 0) {
					String prev = String.valueOf(input.charAt(i - 1));
					boolean conditionOne = Parenthesis.LEFT_PARENTHESIS_SIGN.equals(prev);
					boolean conditionTwo = Function.FUNCTION_ARGUMENT_SEPARATOR.equals(prev);
					
					if (conditionOne || conditionTwo) {
						isNegation = true;
					}
				}
				
				Operator currentOperator = Operator.parseOperator(symbol, isNegation);

				while (!operatorStack.isEmpty()) {
					if (operatorStack.peek() instanceof Parenthesis) {
						break;
					}
					if (operatorStack.peek() instanceof Function) {
						this.outputRPN.add(operatorStack.pop());
						break;
					}
					Operator topStackOperator = (Operator) operatorStack.peek();

					boolean valueOne = currentOperator.getAssociativity() == Operator.LEFT_ASSOCIATIVITY
							&& currentOperator.getPrecedence() <= topStackOperator.getPrecedence();
					boolean valueTwo = currentOperator.getAssociativity() == Operator.RIGHT_ASSOCIATIVITY
							&& currentOperator.getPrecedence() < topStackOperator.getPrecedence();

					if (valueOne || valueTwo) {
						this.outputRPN.add(topStackOperator);
						this.operatorStack.pop();
					} else {
						break;
					}
				}
				operatorStack.push(currentOperator);
			}
			// Check for a function
			else if (Function.isFunction(String.valueOf(symbol), i, input).getValue()) {
				String functionName = Function.isFunction(String.valueOf(symbol), i, input).getKey();
				Function currentFunction = Function.parseFunction(functionName);
				this.operatorStack.add(currentFunction);

				i += functionName.length() - 1;
			}
			// Check for a constant
			else if (Constant.isConstant(String.valueOf(symbol), i, input).getValue()) {
				String constantName = Constant.isConstant(String.valueOf(symbol), i, input).getKey();
				this.outputRPN.add(new Constant(constantName));
				
				i += constantName.length() - 1;
			}
			// Check for a function argument separator
			else if (String.valueOf(symbol).equals(Function.FUNCTION_ARGUMENT_SEPARATOR)) {
				while (!operatorStack.isEmpty() && !operatorStack.peek().getName().equals(Parenthesis.LEFT_PARENTHESIS_SIGN)) {
					int numberOfArguments = ((OperatorBase) operatorStack.peek()).getNumberOfArguments();
					outputRPN.add(new OperatorBase(operatorStack.pop().getName(), numberOfArguments));
				}

				if (operatorStack.isEmpty()) {
					throw new IllegalArgumentException("Error! Either the separator is misplaced or paranthesis are mismathced");
				}
			} 
		}

		while (!operatorStack.empty()) {
			if (this.operatorStack.peek().getName().equals(Parenthesis.LEFT_PARENTHESIS_SIGN)) {
				throw new IllegalArgumentException("Mismatched parenthesis.");
			}
			this.outputRPN.add(this.operatorStack.pop());
		}
	}
}
