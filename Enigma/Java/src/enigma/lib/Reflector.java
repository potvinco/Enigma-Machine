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
  private Series _series;

  //Constructors
  protected Reflector(Series value) {
	 this.setSerie(value);
  }

  //Getters
  public Series getSerie() { return this._series; } 

  //Setters
  public void setSerie(Series value) { this._series = value; } 

  //Methods
  public int getIndexOut(int indexIn) {
	  //TODO: validate the value lineIndex
	  //generate or handle IndexOutOfBound ex
	  
	  return Math.Modulus(indexIn + this._series.getValues()[indexIn], 26);
  }
} 