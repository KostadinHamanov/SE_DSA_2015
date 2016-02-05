package miniMathematica.baseMathObjects;

public enum ConstantEnum {
	EXPONENT("e", Math.E),
	PI("pi", Math.PI);
	
	private String name;
	private double value;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	ConstantEnum(String name, double value) {
		this.setName(name);
		this.setValue(value);
	}
	
	public static boolean containsConstant(String constantName) {
		for (ConstantEnum entry : ConstantEnum.values()) {
			if (entry.getName().equals(constantName)) {
				return true;
			}
		}
		return false;
	}
	
	public static ConstantEnum getConstantEntryByName(String name) {
		for (ConstantEnum entry : ConstantEnum.values()) {
			if (entry.getName().equals(name)) {
				return entry;
			}
		}
		throw new IllegalArgumentException("Illegal constant");
	}
}
