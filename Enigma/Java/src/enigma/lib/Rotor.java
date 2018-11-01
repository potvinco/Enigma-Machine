package enigma.lib;

import java.io.Serializable;
import java.util.ArrayList;

public class Rotor implements Rotatable, Serializable { 
  private static final long serialVersionUID = 1L;
  
  //Fields
  private ArrayList<IRotorEventListener> _eventListeners = new ArrayList<IRotorEventListener>();
  private Series[] _series = new Series[2];
  private int _offset = 0;
  private int _counter = 0;
  private EnumDirection _direction = EnumDirection.Right;
  private EnumRotors _identifier;

  //Constructors
  //Must provide a set of data and identify the rotor
  public Rotor(Series[] series, EnumRotors identifier) {
	  this.setSeries(series);
	  this.setIdentifier(identifier);
  }
  
  //Getters
  public Series[] getSeries() { return this._series; } 
  public int getOffset() { return this._offset; } 
  public int getCounter() {return _counter;}
  public EnumDirection getDirection() {return _direction;}
  public EnumRotors getIdentifier() { return _identifier; }

  //Setters
  private void setSeries(Series[] series) { this._series = series; } 
  protected void setOffset(int offset) { this._offset = offset;} 
  protected void setCounter(int counter) {this._counter = counter;}  
  protected void setDirection(EnumDirection direction) {this._direction = direction;}
  public void setIdentifier(EnumRotors _identifier) { this._identifier = _identifier; }

  //Methods
  public int getIndexOut(int indexIn, int lineIndex) {
	  //TODO: validate the value lineIndex
	  //generate or handle IndexOutOfBound ex
	  
	  int offset = Math.Modulus(indexIn + this.getOffset() , 26);	  
	  return Math.Modulus( indexIn + this._series[lineIndex].getValues()[offset], 26);
  }
  
  public void init(KeyItem keyItem) {
	  this.setDirection(keyItem.getDirection());
	  this.setOffset(keyItem.getOffset());
	  this._counter = 0;
  }
  
  public void rotate() {
	  int movement = (1 * this._direction.getValue());
	  /* 0 <= increment < 26
	   * since there are only 26 positions,
	   * get the current value, add the increment value (which can be negative)
	   * take the result and apply modulus 26 to get an absolute position value
	   */
	  this.setOffset(this.getOffset() + movement);
	  this.setCounter(this.getCounter() + 1);	  
	  
	  //if full rotation, trigger onRotationCompletedEvent
	  if(Math.Modulus(this.getCounter(),26) == 0) {
		  for(IRotorEventListener listener : this._eventListeners){
			  listener.onRotationCompleted(new RotorEvent(this));
		  }
	  }
  };

  public void addEventListener(IRotorEventListener listener) {
		try {
			if (listener == null)
				throw new NullPointerException("the listener may not be null");
	
			if (!this._eventListeners.contains(listener))
				this._eventListeners.add(listener);
			
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		}
	}  

  public void removeEventListener(IRotorEventListener listener) {
	try {
		if (listener == null)
			throw new NullPointerException("the listener may not be null");
	
		if (this._eventListeners.contains(listener))
			_eventListeners.remove(listener);
	
	} catch (NullPointerException ex) {
		System.out.println(ex.getMessage());
	}
  }
	
} 