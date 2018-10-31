package enigma.lib;

import java.io.Serializable;

/**
 ** Class InvalidKeyException
 **/
public class InvalidKeyException extends Exception implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidKeyException(String message) {
		super(message);
	}
}
