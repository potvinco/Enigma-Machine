package enigma.lib;

import java.io.Serializable;

/**
 ** Class Machine
 **/
public class Machine implements Rotatable, Serializable { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Fields
  private Rotor[] rotor;
  private Reflector reflector;
  private Key key;
  private int rotorIndex;
  private int rotationCount;

  //Constructors
  public Machine() {}

  //Getters
  private Rotor[] getRotor() { return this.rotor; } 
  private Reflector getReflector() { return this.reflector; } 
  private Key getKey() { return this.key; } 
  public int getRotorIndex() { return this.rotorIndex; } 
  public int getRotationCount() { return this.rotationCount; } 

  //Setters
  public void setRotor(Rotor[] value) { this.rotor = value; } 
  public void setReflector(Reflector value) { this.reflector = value; } 
  public void setKey(Key value) { this.key = value; } 
  private void setRotorIndex(int value) { this.rotorIndex = value; } 
  private void setRotationCount(int value) { this.rotationCount = value; } 

  //Methods
  public void init(Key key) {};
  public void rotate(int value) {};

  //Inner classes

} //end class Machine 
