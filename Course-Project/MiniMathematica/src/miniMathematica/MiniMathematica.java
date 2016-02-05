package miniMathematica;

import java.util.Queue;

import miniMathematica.baseMathObjects.BaseMathObject;

public class MiniMathematica {
	private RPNCalculator rpnCalculator;
	private ShuntingYardParser shuntingYardParser;
	
	public RPNCalculator getRpnCalculator() {
		return rpnCalculator;
	}

	public void setRpnCalculator(RPNCalculator rpnCalculator) {
		this.rpnCalculator = rpnCalculator;
	}

	public ShuntingYardParser getShuntingYardParser() {
		return shuntingYardParser;
	}

	public void setShuntingYardParser(ShuntingYardParser shuntingYardParser) {
		this.shuntingYardParser = shuntingYardParser;
	}

	public MiniMathematica() {		
		this.rpnCalculator = new RPNCalculator();
		this.shuntingYardParser = new ShuntingYardParser();
	}
	
	public Double calculate(String expression) {	
		this.rpnCalculator = new RPNCalculator();
		this.shuntingYardParser = new ShuntingYardParser();
		
		shuntingYardParser.convertInput(expression);
		Queue<BaseMathObject> expressionInRPN = shuntingYardParser.getOutputRPN();
		Double result = rpnCalculator.calculateRpnExpression(expressionInRPN);
		
		return result;
	}
}
