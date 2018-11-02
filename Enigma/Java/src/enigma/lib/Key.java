package enigma.lib;

import java.io.Serializable;

public class Key implements Serializable { 
  private static final long serialVersionUID = 1L;
	
//Fields
  private KeyItem[] _keyItems = new KeyItem[3];

  //Constructors
  public Key( KeyItem[] items ) throws InvalidKeyException, InvalidKeyItemException {
	  this.setKeyItems(items);
  }

  public Key( KeyItem key1, KeyItem key2, KeyItem key3 ) throws InvalidKeyException, InvalidKeyItemException {
	  KeyItem[] keys = new KeyItem[3];
	  keys[0] = key1;
	  keys[1] = key2;
	  keys[2] = key3;
	  
	  this.setKeyItems(keys);
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

  //methods
  public int getIndex(EnumRotors rotor) {
	  for(int i = 0; i< this._keyItems.length;i++){
		  if(this._keyItems[i].getIdentifier() == rotor)
			  return i;
	  }
	  
	  //return invalid index
	  return -1;
  }
  
} 