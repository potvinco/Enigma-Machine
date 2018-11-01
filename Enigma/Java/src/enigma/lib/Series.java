package enigma.lib;

import java.io.Serializable;

/**
 ** Class Series
 **/
public class Series implements Serializable { 
	private static final long serialVersionUID = 1L;
//Fields
  private int[] _values;

  //Constructors
  public Series(int[] values) {
	  this.setValues(values);
  }

  //Getters
  public int[] getValues() { 
	  return this._values; 
  } 

  //Setters
  public void setValues(int[] values) { 
	  //To do: add validation:
	  //value must be between -25 and 25 inc.
	  
	  this._values = values; 
	  
	  //throw or handle index out of bound ex
  } 

  public String toString(int startIndex) {
	  String returnValue = "";
	  
	  for(int i = 0; i< 26;i++) {
		  returnValue += "," + this._values[Math.Modulus(startIndex + i,26)];
	  }
	  
	  return returnValue;
  }
} 