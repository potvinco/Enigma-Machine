package enigma.lib;

public enum EnumRotors {
	Reflector(-1), Rotor1(0), Rotor2(1), Rotor3(2);
	
	private int value;
	
	private EnumRotors(int value) {
		setValue( value) ;
	}

	public int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}
}
