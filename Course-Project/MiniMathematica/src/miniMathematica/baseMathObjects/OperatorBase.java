package miniMathematica.baseMathObjects;

public class OperatorBase extends BaseMathObject {
	protected int numberOfArguments;

	public int getNumberOfArguments() {
		return numberOfArguments;
	}

	public void setNumberOfArguments(int numberOfArguments) {
		this.numberOfArguments = numberOfArguments;
	}

	public OperatorBase(String name, int numberOfArguments) {
		super(name);
		this.numberOfArguments = numberOfArguments;
	}
	
	@Override
	public String toString() {
		return this.name.toString();
	}

}
