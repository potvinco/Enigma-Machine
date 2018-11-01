package enigma.lib;

public class RotorEvent {
	// Fields
		private Rotor _rotor;

		// Constructors
		public RotorEvent(Rotor rotor) {
			this.setRotor(rotor);
		}

		// Methods
		public Rotor getRotor() {
			return _rotor;
		}

		private void setRotor(Rotor rotor) {
			this._rotor = rotor;
		}
}
