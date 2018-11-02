import enigma.lib.EnumDirection;
import enigma.lib.EnumRotors;
import enigma.lib.InvalidKeyException;
import enigma.lib.InvalidKeyItemException;
import enigma.lib.Key;
import enigma.lib.KeyItem;
import enigma.lib.Engine;
import enigma.lib.Math;
import enigma.lib.Reflector;
import enigma.lib.Rotor;

public class Main {

	//test values
	private static final int[] m = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,6,7,8,9,13,14,15,16,17,18,19,20,21,22,10,9,8,7,6,5,4,3,2,1,0};
	
	//Methods could be userful for the UI
	private static String arrayToString(int[] array) {
	  String returnValue = "";
	  for(int i = 0; i< array.length;i++) {
		  returnValue += "," + array[i];
	  }		  
	  return returnValue;
	}
	private static void displayData(Engine engine) {
		System.out.println("RF: " + engine.getReflector().getSerie().toString(0));
		for(int i = engine.getRotors().length-1 ;i >= 0; i--) {
			System.out.println("R"+ (i+1) + ": " + engine.getRotors()[i].getSeries()[1].toString(engine.getRotors()[i].getOffset()));
			System.out.println("R"+ (i+1) + ": " + engine.getRotors()[i].getSeries()[0].toString(engine.getRotors()[i].getOffset()));
		}
	}
	private static void displayPath(Engine engine, int indexIn) {
		//this is more or less thhe same as Engine.encrypt(indexIn)
		//we read the results of each rotor
		System.out.println();
		System.out.println("Encryption trace for " + indexIn);
		for(int i=0;i< engine.getRotors().length;i++){
			System.out.println(engine.getRotors()[i].getIdentifier() + " index in: " + indexIn);
			indexIn = engine.getRotors()[i].getIndexOut(indexIn  , 0);
			System.out.println(engine.getRotors()[i].getIdentifier() + " index out: " + indexIn);
		}

		System.out.println(engine.getReflector().getIdentifier() + " index in: " + indexIn);
		indexIn = engine.getReflector().getIndexOut(indexIn);
		System.out.println(engine.getReflector().getIdentifier() + " index out: " + indexIn);
		
		for(int i=engine.getRotors().length -1; i >= 0;i--){
			System.out.println(engine.getRotors()[i].getIdentifier() + " index in: " + indexIn);
			indexIn = engine.getRotors()[i].getIndexOut(indexIn  , 1);
			System.out.println(engine.getRotors()[i].getIdentifier() + " index out: " + indexIn);
		}
		System.out.println();
		System.out.println();
	}
	
	private static void compareValues(Engine engine) {
		
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
		System.out.println("m : " + arrayToString(m));
		System.out.println("e : " + arrayToString(e));
		System.out.println("m1: " + arrayToString(m1));
	
	}
	private static void displayRotorConfig(Engine engine) {
		
		for(Rotor rotor : engine.getRotors()) {
		System.out.println(rotor.toString());			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Engine engine = new Engine();

			KeyItem key1 = new KeyItem(EnumRotors.Rotor1,EnumDirection.Right, 0);
			KeyItem key2 = new KeyItem(EnumRotors.Rotor2,EnumDirection.Right, 0);
			KeyItem key3 = new KeyItem(EnumRotors.Rotor3,EnumDirection.Right, 0);
			
			//initialize with offsets as specified in the PDF
//			KeyItem key1 = new KeyItem(EnumRotors.Rotor3,EnumDirection.Left, 7);
//			KeyItem key2 = new KeyItem(EnumRotors.Rotor1,EnumDirection.Right, -6);
//			KeyItem key3 = new KeyItem(EnumRotors.Rotor2,EnumDirection.Right, 5);
			
			//load key
			//the order in which they are provided in the Key constructor
			//indicates the ORDER of rotation
			//try different combinations and check results
			Key key = new Key(key1,key2,key3);
			
			//CONFIGURE the engine by providing a key
			engine.init(key);

			
			//START TESTS
			for(int i=0;i<(3 * 26);i++) {
				if((Math.Modulus(i, 26)>22) || (Math.Modulus(i, 26)<3)) {
					//ignoring some items to reduce text in console
					//remove this condition to view all results
					//we are concerned with the end of the complete rotation
					//of ALL rotors
					System.out.println("==================================");
					
					//display the information of each rotors after each rotation
					displayRotorConfig(engine);
					
					//display the values of encryption
					displayData(engine);
					System.out.println("");
					
					//the following line will display 
					//m => original values 
					//e => encrypted values of m
					//m1 => encrypted values of e
					compareValues(engine);
				System.out.println("");
				System.out.println("");
					
				}
				//rotate
				engine.rotate();
			}
			
			
			//rotate a number of time for fun, we are going to test specific values to 
			//show how to read the values for each encryption of m[]
			for(int i=0;i<2911;i++) engine.rotate();
			
			//see trace for each item of m
			for(int i : m) displayPath(engine,i);
			
			
			
			
		}catch(InvalidKeyException ex) {
			
		}catch(InvalidKeyItemException ex) {
			
		}
	}
}
