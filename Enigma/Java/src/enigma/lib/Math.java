package enigma.lib;

public class Math {
	public static int Modulus(int value, int divider) {
		return (value % divider + divider) % divider;		
	}
}
