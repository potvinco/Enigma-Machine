package enigma.lib;

import java.io.Serializable;

/**
 ** Class Reflector
 **/
public class Reflector implements Serializable { 
  private static final long serialVersionUID = 1L;
//Fields
  private Series _series;
  private EnumRotors _identifier = EnumRotors.Reflector;

  //Constructors
  protected Reflector(Series value) {
	 this.setSerie(value);
  }

  //Getters
  public Series getSerie() { return this._series; } 
  public EnumRotors getIdentifier() { return _identifier; }
  
  //Setters
  public void setSerie(Series value) { this._series = value; } 

  //Methods
  public int getIndexOut(int indexIn) throws IndexOutOfBoundsException, NullPointerException {
	  if(indexIn < 0 || indexIn >= this._series.getValues().length )
		  throw new IndexOutOfBoundsException("indexIn must be between 0 and 25 (incl.)");
	  
	  if(this._series == null)
		  throw new NullPointerException("Series is null");
	  
	  return Math.Modulus(indexIn + this._series.getValues()[indexIn], this._series.getValues().length);
  }
} 