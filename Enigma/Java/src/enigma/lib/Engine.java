package enigma.lib;

import java.io.Serializable;

public class Engine implements Rotatable, Serializable, IRotorEventListener { 
	private static final long serialVersionUID = 1L;
//Fields
  private Rotor[] _rotors; // the collection will contain the rotors in the following order: Rotor1, Rotor2, Rotor3
  private Reflector _reflector;
  private Key key; // the key contains a collection of KeyItems. It will be used to determine the order of rotation
  private int rotorIndex;
  private int rotationCount;

  //Constructors
  public Engine() {
	  this.initRotors();	  
  }

  //Getters
  public Rotor[] getRotors() { return this._rotors; } 
  public Reflector getReflector() { return this._reflector; } 
  public Key getKey() { return this.key; } 
  public int getRotorIndex() { return this.rotorIndex; } 
  public int getRotationCount() { return this.rotationCount; } 

  //Setters
  private void setRotors(Rotor[] rotors) { this._rotors = rotors; } 
  private void setReflector(Reflector reflector) { this._reflector = reflector; } 
  private void setKey(Key value) { this.key = value; } 
  private void setRotorIndex(int value) { this.rotorIndex = value; } 
  private void setRotationCount(int value) { this.rotationCount = value; } 

  //Methods
  public void init(Key key) {
	  //when initializing, we want to keep the key
	  this.setKey(key);	 
	  
	  //using the key, we want to offset the rotors
	  this.setRotorsAttributes(key.getKeyItems());	
	  this.rotorIndex = this.getRotorIndex(key.getKeyItems()[0].getIdentifier());
	  
  };
  
  private int getRotorIndex(EnumRotors rotor) {
	  for(int i = 0; i< this._rotors.length;i++){
		  if(this._rotors[i].getIdentifier() == rotor)
			  return i;
	  }
	  
	  return -1;
  }
  
  private void setRotorsAttributes(KeyItem[] keys)
  {
	  for(int i=0;i< keys.length;i++) {
		  switch(keys[i].getIdentifier()) {
		  case Rotor1:
			  this.getRotors()[0].setOffset(keys[i].getOffset());
			  this.getRotors()[0].setDirection(keys[i].getDirection());
			  break;
		  case Rotor2:
			  this.getRotors()[1].setOffset(keys[i].getOffset());
			  this.getRotors()[1].setDirection(keys[i].getDirection());
			  break;
		  case Rotor3:
			  this.getRotors()[2].setOffset(keys[i].getOffset());
			  this.getRotors()[2].setDirection(keys[i].getDirection());
			  break;
		  }
	  }	  
  }
  public int encrypt(int indexIn) {
	for(int i=0;i< this.getRotors().length;i++){
		indexIn = this.getRotors()[i].getIndexOut(indexIn  , 0);
		//System.out.println("rotor[" + i + "]: " + indexIn);
	}

	indexIn = this.getReflector().getIndexOut(indexIn);
	//System.out.println("reflector result:" + indexIn);
	
	for(int i=this.getRotors().length -1; i >= 0;i--){
		indexIn = this.getRotors()[i].getIndexOut(indexIn, 1);
		//System.out.println("rotor[" + i + "]: " + indexIn);
	}
	return indexIn;
  }
    
  public void rotate() {
	  //read the key to determine the order of the rotors
	  this.getRotors()[this.getRotorIndex()].rotate();
  }

  private void initRotors() {
	//initialize array of 3 rotors
	  this._rotors = new Rotor[3];
	  
	  
	  //init rotor 1
	  Series[] series = new Series[2];
	  int[] values1 = new int[] {10,21,05,-17,21,-4,12,16,6,-3,  7,-7, 4,2, 5,-7,-11,-17, -9,-6,-9,-19,  2, -3,-21, -4};
	  int[] values2 = new int[] {17,04,19, 21, 7,11, 3,-5,7, 9,-10, 9,17,6,-6,-2, -4, -7,-12,-5, 3,  4,-21,-16, -2,-21};
	  series[0] = new Series(values1);
	  series[1] = new Series(values2);
	  this._rotors[0] = new Rotor(series, EnumRotors.Rotor1);

	  //init rotor 2
	  series = new Series[2];
	  values1 = new int[] {3,17,22,18,16,7,5,1,-7,16,-3,8,2,9,2,-5,-1,-13,-12,-17,-11,-4,1,-10,-19,-25};
	  values2 = new int[] {25,7,17,-3,13,19,12,3,-1,11,5,-5,-7,10,-2,1,-2,4,-17,-8,-16,-18,-9,-1,-22,-16};
	  series[0] = new Series(values1);
	  series[1] = new Series(values2);
	  this._rotors[1] = new Rotor(series, EnumRotors.Rotor2);
	  
	  //init rotor 3
	  series = new Series[2];
	  values1 = new int[] {1,16,5,17,20,8,-2,2,14,6,2,-5,-12,-10,9,10,5,-9,1,-14,-2,-10,-6,13,-10,-23};
	  values2 = new int[] {12,-1,23,10,2,14,5,-5,9,-2,-13,10,-2,-8,10,-6,6,-16,2,-1,-17,-5,-14,-9,-20,-10};
	  series[0] = new Series(values1);
	  series[1] = new Series(values2);
	  this._rotors[2] = new Rotor(series, EnumRotors.Rotor3);
	  

	  //init reflector
	  values1 = new int[] {25,23,21,19,17,15,13,11,9,7,5,3,1,-1,-3,-5,-7,-9,-11,-13,-15,-17,-19,-21,-23,-25};
	  Series reflector = new Series(values1);
	  this._reflector = new Reflector(reflector);
	  
	  

	  //add event listener
	  for(Rotor rotor : this._rotors){
		  rotor.addEventListener(this);
	  }
  }
@Override
public void onRotationCompleted(RotorEvent event) {
	// TODO Auto-generated method stub
	//use the rotor and its position in the key's keyitems to determine its order of rotation
	//var pos = 
	
	//increase the position by 1 & 3
	//pos = (pos + 1) % 3
	
	//select the rotor speciffied in Key(pos)
	this.rotorIndex=  Math.Modulus(this.getRotorIndex(event.getRotor().getIdentifier()) + 1, 3)  ;
	this.getRotors()[this.rotorIndex].rotate();
	
};
  
} 