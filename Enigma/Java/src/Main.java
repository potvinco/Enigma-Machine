import enigma.lib.EnumDirection;
import enigma.lib.EnumRotors;
import enigma.lib.InvalidKeyException;
import enigma.lib.InvalidKeyItemException;
import enigma.lib.Key;
import enigma.lib.KeyItem;
import enigma.lib.Machine;
import enigma.lib.Math;
import enigma.lib.Reflector;
import enigma.lib.Rotor;

public class Main {

	private static String arrayToString(int[] array) {
		String returnValue = "";
		  
		  for(int i = 0; i< array.length;i++) {
			  returnValue += "," + array[i];
		  }
		  
		  return returnValue;
	}
	private static void displayData(Machine engine) {
		System.out.println("RF: " + engine.getReflector().getSerie().toString(0));
		for(int i = engine.getRotors().length-1 ;i >= 0; i--) {
			System.out.println("R"+ (i+1) + ": " + engine.getRotors()[i].getSeries()[1].toString(engine.getRotors()[i].getOffset()));
			System.out.println("R"+ (i+1) + ": " + engine.getRotors()[i].getSeries()[0].toString(engine.getRotors()[i].getOffset()));
		}
	}
	private static void compareValues(Machine engine) {
		
		int[] m = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,6,7,8,9,13,14,15,16,17,18,19,20,21,22,10,9,8,7,6,5,4,3,2,1,0};
		int[] e = new int[m.length];
		int[] m1 = new int[m.length];
		
		//encrypt m
		for(int i=0;i<m.length;i++) {
			e[i] = engine.encrypt(m[i]);
		}

		//decrypt e
		for(int i=0;i<e.length;i++) {
			m1[i] = engine.encrypt(e[i]);
		}
		
		//display results
		System.out.println("m: " + arrayToString(m));
		System.out.println("e: " + arrayToString(e));
		System.out.println("m1: " + arrayToString(m1));
		
//		System.out.println("encrypt 'a': " + indexIn);
//		indexIn = engine.encrypt(indexIn);
//		System.out.println("obtain : " + indexIn);
//		System.out.println("");
//		
//		//decrypt
//		System.out.println("decrypt: " + indexIn);
//		indexIn = engine.encrypt(indexIn);
//		System.out.println("obtain : " + indexIn);
//		System.out.println("");
//		System.out.println("");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Machine engine = new Machine();

			//initialize with offsets
			KeyItem key1 = new KeyItem(EnumRotors.Rotor3,EnumDirection.Left, 7);
			KeyItem key2 = new KeyItem(EnumRotors.Rotor1,EnumDirection.Right, -6);
			KeyItem key3 = new KeyItem(EnumRotors.Rotor2,EnumDirection.Right, 5);
			
			//load key
			Key key = new Key(key1,key2,key3);
			
			engine.init(key);

			Rotor rotor1 = engine.getRotors()[0];
			Rotor rotor2 = engine.getRotors()[1];
			Rotor rotor3 = engine.getRotors()[2];
			Reflector reflector = engine.getReflector();
			
			//check that the rotate function works on rotors
			System.out.println("");
			displayData(engine);
			compareValues(engine);
			System.out.println("");
			
			System.out.println("");
			rotor1.rotate();
			System.out.println("rotated " + rotor1.getIdentifier() + " to the " + rotor1.getDirection());
			displayData(engine);
			compareValues(engine);
			System.out.println("");
						
			System.out.println("");
			rotor3.rotate();
			System.out.println("rotated " + rotor3.getIdentifier() + " to the " + rotor3.getDirection());
			displayData(engine);
			compareValues(engine);
			System.out.println("");
			
			
			
//			
		}catch(InvalidKeyException ex) {
			
		}catch(InvalidKeyItemException ex) {
			
		}
	}
}
