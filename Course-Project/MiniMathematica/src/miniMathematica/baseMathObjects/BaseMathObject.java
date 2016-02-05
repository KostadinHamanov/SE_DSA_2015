package miniMathematica.baseMathObjects;

public class BaseMathObject {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BaseMathObject(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
