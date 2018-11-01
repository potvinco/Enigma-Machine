package enigma.lib;

import java.io.Serializable;

public class KeyItem implements Serializable  { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Fields
  private EnumRotors _identifier;
  private EnumDirection _direction;
  private int _offset;

  //Constructors
  public KeyItem(EnumRotors rotor, EnumDirection direction, int initOffset)throws InvalidKeyItemException {
	  try {
		  this.setIdentifier(rotor);
		  this.setDirection(direction);
		  this.setOffset(initOffset);
	  }
	  catch(InvalidKeyItemException ex) {
		  throw ex;
	  }
  }

  //Getters
  protected EnumRotors getIdentifier() { return this._identifier; } 
  protected EnumDirection getDirection() { return this._direction; } 
  protected int getOffset() { return this._offset; } 

  //Setters
  private void setIdentifier(EnumRotors identifier) throws InvalidKeyItemException { 
	  if(identifier != null)
		  this._identifier = identifier; 
	  else
		  throw new InvalidKeyItemException("The rotor is invalid");
  } 
  private void setDirection(EnumDirection value) throws InvalidKeyItemException  { 
	  if(value != null)
		  this._direction = value; 
	  else
		  throw new InvalidKeyItemException("The direction is invalid");
	  
  } 
  private void setOffset(int value) { 
		  this._offset = Math.Modulus(value, 26); 
  } 

} 
