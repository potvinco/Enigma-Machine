package enigma.lib;

import java.io.Serializable;

/**
 ** Class InvalidKeyItemException
 **/
public class InvalidKeyItemException extends Exception implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidKeyItemException(String message) {
		super(message);
	}
}