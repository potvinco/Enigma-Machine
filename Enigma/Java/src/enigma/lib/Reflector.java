package enigma.lib;

import java.io.Serializable;

/**
 ** Class Reflector
 **/
public class Reflector implements Serializable { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Fields
  private Serie serie;

  //Constructors
  protected Reflector(Serie value) {
	  
  }

  //Getters
  public Serie getSerie() { return this.serie; } 

  //Setters
  public void setSerie(Serie value) { this.serie = value; } 

} 