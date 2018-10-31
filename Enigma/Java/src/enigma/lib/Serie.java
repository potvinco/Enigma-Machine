package enigma.lib;

import java.io.Serializable;

/**
 ** Class Serie
 **/
public class Serie implements Serializable { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Fields
  private int[] value;

  //Constructors
  public Serie() {}

  //Getters
  public int[] getValue() { return this.value; } 

  //Setters
  public void setValue(int[] value) { this.value = value; } 

  //Methods

  //Inner classes

} //end class Serie 
