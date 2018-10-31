package enigma.lib;

import java.io.Serializable;

/**
 ** Enum Direction
 **/
public enum Direction implements Serializable  { 
Left(-1), Right(1);
	
	private int value;
	
	private Direction(int value) {
		setValue( value) ;
	}

	public int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}
} //end enum Direction 
