package enigma.lib;

import java.io.Serializable;

/**
 ** Enum Direction
 **/
public enum EnumDirection implements Serializable  { 
Left(1), Right(-1);
	
	private int value;
	
	private EnumDirection(int value) {
		setValue( value) ;
	}

	public int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}
} 