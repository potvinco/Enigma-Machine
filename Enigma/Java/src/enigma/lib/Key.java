package enigma.lib;

import java.io.Serializable;

/**
 ** Class Key
 **/
public class Key implements Serializable { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Fields
  private KeyItem[] _keyItems = new KeyItem[3];

  //Constructors
  protected Key( KeyItem[] items ) throws InvalidKeyException, InvalidKeyItemException {
	  this.setKeyItems(items);
  }

  //Getters
  protected KeyItem[] getKeyItems() { 
	  return this._keyItems; 	  
  } 

  //Setters
  private void setKeyItems(KeyItem[] items)  throws InvalidKeyException, InvalidKeyItemException {
	  if(items!=null) {
		  if(items.length==3) { 
			  this._keyItems = items; 
		  }
		  else {
			  throw new InvalidKeyException("items must have 3 elements");
		  }
	  }
	  else {
		  throw new InvalidKeyException("the items can not be null");
	  } 
  }
} 