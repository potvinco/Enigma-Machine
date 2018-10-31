package enigma.lib;

import java.io.Serializable;

/**
 ** Class Rotor
 **/
public class Rotor implements Rotatable, Serializable { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Fields
  private Serie[] serie;
  private int offset;

  //Constructors
  public Rotor() {}

  //Getters
  public Serie[] getSerie() { return this.serie; } 
  public int getOffset() { return this.offset; } 

  //Setters
  public void setSerie(Serie[] value) { this.serie = value; } 
  public void setOffset(int value) { this.offset = value; } 

  //Methods
  public void rotate(int value) {};

  //Inner classes

} //end class Rotor 
