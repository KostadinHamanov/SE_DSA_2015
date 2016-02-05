package miniMathematica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import miniMathematica.baseMathObjects.BaseMathObject;
import miniMathematica.baseMathObjects.Constant;
import miniMathematica.baseMathObjects.FunctionsEnum;
import miniMathematica.baseMathObjects.Number;
import miniMathematica.baseMathObjects.Operator;
import miniMathematica.baseMathObjects.OperatorBase;

public class RPNCalculator {
	private Stack<BaseMathObject> resultStack;
	private Queue<BaseMathObject> expressionRPN;

	public Stack<BaseMathObject> getResultStack() {
		return resultStack;
	}

	public void setResultStack(Stack<BaseMathObject> resultStack) {
		this.resultStack = resultStack;
	}

	public Queue<BaseMathObject> getInputInRPN() {
		return expressionRPN;
	}

	public void setInputInRPN(Queue<BaseMathObject> expressionRPN) {
		this.expressionRPN = expressionRPN;
	}

	public RPNCalculator() {
		this.resultStack = new Stack<>();
		this.expressionRPN = new LinkedList<>();
	}

	/**
	 * Calculating the an expression in reverse notation using the algorithm 
	 * for calculating reverse polish notation expressions
	 * @param expressionRPN - reverse polish notation expression
	 * @return the calculated expression(<>)
	 * @exception IllegalArgumentException - if there is an error in the expression
	 * resulted by input of the user
	 */
	public Double calculateRpnExpression(Queue<BaseMathObject> expressionRPN) {

		while (!expressionRPN.isEmpty()) {
			BaseMathObject currentToken = expressionRPN.poll();

			// The token is a number or a constant.
			if (currentToken instanceof Number || currentToken instanceof Constant) {
				resultStack.push(currentToken);
			}
			// The token is an operator (including both operators and
			// functions).
			else if (currentToken instanceof OperatorBase) {
				int numberOfArguments = ((OperatorBase) currentToken).getNumberOfArguments();

				if (resultStack.size() < numberOfArguments) {
					throw new IllegalArgumentException(
							"Error! The user has not input sufficient values in the expression.");
				}

				ArrayList<Double> argumentsList = new ArrayList<>();

				for (int i = 0; i < numberOfArguments; i++) {
					boolean isNumber = Number.isNumber(resultStack.peek().getName());

					if (isNumber) {
						Number token = new Number(resultStack.pop().getName());
						argumentsList.add(token.getValue());
					} else {
						Constant token = new Constant(resultStack.pop().getName());
						argumentsList.add(token.getValue());
					}
				}

				BaseMathObject operatorEvaluatedResult = evaluateOperator((OperatorBase) currentToken, argumentsList);
				resultStack.push(operatorEvaluatedResult);
			}
		}

		if (resultStack.size() == 1) {
			return Double.parseDouble(resultStack.peek().getName());
		} else {
			throw new IllegalArgumentException("The user input has too many values.");
		}
	}

	/**
	 * Calculating arguments with their corresponding operator
	 * @param currentToken - operator or function
	 * @param argumentsList - list of arguments
	 * @return the result of the argument operation(currentToken) over argumentsList
	 */
	private BaseMathObject evaluateOperator(OperatorBase currentToken, ArrayList<Double> argumentsList) {
		Collections.reverse(argumentsList);
		Double finalResult = 0.0;
		String tokenAsString = currentToken.getName();

		if (Operator.ADDITION_SIGN.equals(tokenAsString) && currentToken.getNumberOfArguments() == 2) {
			finalResult = argumentsList.get(0) + argumentsList.get(1);

		} else if (Operator.NEGATION_SIGN.equals(tokenAsString) && currentToken.getNumberOfArguments() == 1) {
			finalResult -= argumentsList.get(0);
			
		} else if (Operator.SUBSTRACTION_SIGN.equals(tokenAsString) && currentToken.getNumberOfArguments() == 2) {
			finalResult = argumentsList.get(0) - argumentsList.get(1);

		} else if (Operator.MULTIPLICATION_SIGN.equals(tokenAsString) && currentToken.getNumberOfArguments() == 2) {
			finalResult = argumentsList.get(0) * argumentsList.get(1);

		} else if (Operator.DIVISION_SIGN.equals(tokenAsString) && currentToken.getNumberOfArguments() == 2) {
			finalResult = argumentsList.get(0) / argumentsList.get(1);

		} else if (Operator.EXPONENT_SIGN.equals(tokenAsString) && currentToken.getNumberOfArguments() == 2) {
			finalResult = Math.pow(argumentsList.get(0), argumentsList.get(1));

		} else if (FunctionsEnum.POW.getName().equals(tokenAsString) && currentToken.getNumberOfArguments() == 2) {
			finalResult = Math.pow(argumentsList.get(0), argumentsList.get(1));

		} else if (FunctionsEnum.SQRT.getName().equals(tokenAsString) && currentToken.getNumberOfArguments() == 1) {
			finalResult = Math.sqrt(argumentsList.get(0));

		} else if (FunctionsEnum.LOG.getName().equals(tokenAsString) && currentToken.getNumberOfArguments() == 2) {
			// log(base, number) = ln(number)/ln(base)
			finalResult = Math.log(argumentsList.get(1)) / Math.log(argumentsList.get(0));

		} else if (FunctionsEnum.SIN.getName().equals(tokenAsString) && currentToken.getNumberOfArguments() == 1) {
			finalResult = Math.sin(argumentsList.get(0));

		} else if (FunctionsEnum.COS.getName().equals(tokenAsString) && currentToken.getNumberOfArguments() == 1) {
			finalResult = Math.cos(argumentsList.get(0));

		} else if (FunctionsEnum.TG.getName().equals(tokenAsString) && currentToken.getNumberOfArguments() == 1) {
			finalResult = Math.tan(argumentsList.get(0));

		} else if (FunctionsEnum.COTG.getName().equals(tokenAsString) && currentToken.getNumberOfArguments() == 1) {
			finalResult = 1.0 / Math.tan(argumentsList.get(0));

		} else if (FunctionsEnum.MAX.getName().equals(tokenAsString) && currentToken.getNumberOfArguments() == 2) {
			finalResult = Math.max(argumentsList.get(0), argumentsList.get(1));
			
		} else if (FunctionsEnum.MIN.getName().equals(tokenAsString) && currentToken.getNumberOfArguments() == 2) {
			finalResult = Math.min(argumentsList.get(0), argumentsList.get(1));
			
		} else {
			throw new IllegalArgumentException("Unknown operator or function");
		}

		return new BaseMathObject(String.valueOf(finalResult));
	}
}
