package enigma.lib;

public enum EnumRotors {
	Reflector(-1, ""), Rotor1(0,"Rotor 1"), Rotor2(1,"Rotor 2"), Rotor3(2,"Rotor 3");

	private int value;

	private String text;
	
	private EnumRotors(int value, String text) {
		setValue(value) ;
		setText( text) ;
	}

	public int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	private void setText(String value) {
		this.text = value;
	}
}
