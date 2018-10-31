package enigma.lib;

import java.io.Serializable;

/**
 ** Class KeyItem
 *
 *this class is used only inside the machine
 **/
public class KeyItem implements Serializable  { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Fields
  private Rotor rotor;
  private Direction direction;
  private int offset;

  //Constructors
  protected KeyItem(Rotor rotor, Direction direction, int initOffset)throws InvalidKeyItemException {
	  try {
		  this.setRotor(rotor);
		  this.setDirection(direction);
		  this.setOffset(initOffset);
	  }
	  catch(InvalidKeyItemException ex) {
		  throw ex;
	  }
  }

  //Getters
  protected Rotor getRotor() { return this.rotor; } 
  protected Direction getDirection() { return this.direction; } 
  protected int getOffset() { return this.offset; } 

  //Setters
  private void setRotor(Rotor value) throws InvalidKeyItemException { 
	  if(value != null)
		  this.rotor = value; 
	  else
		  throw new InvalidKeyItemException("The rotor is invalid");
  } 
  private void setDirection(Direction value) throws InvalidKeyItemException  { 
	  if(value != null)
		  this.direction = value; 
	  else
		  throw new InvalidKeyItemException("The direction is invalid");
	  
  } 
  private void setOffset(int value) { 
		  this.offset = value % 26; 
  } 

} 
