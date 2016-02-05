package miniMathematica.baseMathObjects;

public enum FunctionsEnum {
	POW("pow", 2), 
	SQRT("sqrt", 1), 
	LOG("log", 2),

	SIN("sin", 1), 
	COS("cos", 1), 
	TG("tg", 1), 
	COTG("cotg", 1),

	MAX("max", 2),
	MIN("min", 2);

	private String name;
	private int numberOfArgiments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfArgument() {
		return numberOfArgiments;
	}

	public void setNumberOfArguments(int numberOfArguments) {
		this.numberOfArgiments = numberOfArguments;
	}

	private FunctionsEnum(String name, int numberOfArguments) {
		this.setName(name);
		this.setNumberOfArguments(numberOfArguments);
	}

	public static boolean containsFunction(String functionName) {
		for (FunctionsEnum entry : FunctionsEnum.values()) {
			if (entry.getName().equals(functionName)) {
				return true;
			}
		}
		return false;
	}
}
