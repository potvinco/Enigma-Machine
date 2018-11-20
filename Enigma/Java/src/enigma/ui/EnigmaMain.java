package enigma.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import enigma.lib.Engine;
import enigma.lib.EnumDirection;
import enigma.lib.EnumRotors;
import enigma.lib.InvalidKeyException;
import enigma.lib.InvalidKeyItemException;
import enigma.lib.Key;
import enigma.lib.KeyItem;
import enigma.ui.controls.JSeries;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class EnigmaMain {

	private JFrame frame;
	private JSeries R4;
	private JSeries R3_2;
	private JSeries R3_1;
	private JSeries R2_2;
	private JSeries R2_1;
	private JSeries R1_2;
	private JSeries R1_1;
	private JTextField txtRotorOffset_0;
	private JTextField txtRotorOffset_1;
	private JTextField txtRotorOffset_2;
	private JSeries Letters;
	private JTextField textField_3;
	private JComboBox cboRotorIdentifier_0;
	private JComboBox cboRotorIdentifier_1;
	private JComboBox cboRotorIdentifier_2;
	private JComboBox cboRotorDirection_0;
	private JComboBox cboRotorDirection_1;
	private JComboBox cboRotorDirection_2;

	KeyItem key1 = new KeyItem(EnumRotors.Rotor3, EnumDirection.Left, 7);
	KeyItem key2 = new KeyItem(EnumRotors.Rotor1, EnumDirection.Right, -6);
	KeyItem key3 = new KeyItem(EnumRotors.Rotor2, EnumDirection.Right, 5);
	Key key = new Key(key1, key2, key3);

	private Engine engine = new Engine();
	private JTextField txtEncryptAll;
	private JTextField txtDecryptAll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnigmaMain window = new EnigmaMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EnigmaMain() {
		initialize();
		loadLists();

		key1 = new KeyItem(EnumRotors.Rotor3, EnumDirection.Left, 7);
		key2 = new KeyItem(EnumRotors.Rotor1, EnumDirection.Right, -6);
		key3 = new KeyItem(EnumRotors.Rotor2, EnumDirection.Right, 5);

		// load key
		// the order in which they are provided in the Key constructor
		// indicates the ORDER of rotation
		// try different combinations and check results
		key = new Key(key1, key2, key3);

		// CONFIGURE the engine by providing a key
		engine.init(key);

		this.displayRotors(engine);
		this.displayKey(key);

	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1005, 736);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		R4 = new JSeries();
		R4.setBounds(88, 13, 882, 32);
		frame.getContentPane().add(R4);

		R3_2 = new JSeries();
		R3_2.setBounds(88, 58, 882, 32);
		frame.getContentPane().add(R3_2);

		R3_1 = new JSeries();
		R3_1.setBounds(88, 89, 882, 32);
		frame.getContentPane().add(R3_1);

		R2_2 = new JSeries();
		R2_2.setBounds(88, 141, 882, 32);
		frame.getContentPane().add(R2_2);

		R2_1 = new JSeries();
		R2_1.setBounds(88, 172, 882, 32);
		frame.getContentPane().add(R2_1);

		R1_2 = new JSeries();
		R1_2.setBounds(88, 224, 882, 32);
		frame.getContentPane().add(R1_2);

		R1_1 = new JSeries();
		R1_1.setBounds(88, 255, 882, 32);
		frame.getContentPane().add(R1_1);

		cboRotorIdentifier_0 = new JComboBox<String>();
		cboRotorIdentifier_0.setBounds(293, 351, 127, 22);
		frame.getContentPane().add(cboRotorIdentifier_0);

		txtRotorOffset_0 = new JTextField();
		txtRotorOffset_0.setBounds(560, 351, 31, 22);
		frame.getContentPane().add(txtRotorOffset_0);
		txtRotorOffset_0.setColumns(10);

		cboRotorDirection_0 = new JComboBox<EnumRotors>();
		cboRotorDirection_0.setBounds(432, 351, 116, 22);
		frame.getContentPane().add(cboRotorDirection_0);

		JButton btnConfigure = new JButton("Apply Key");
		btnConfigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetRotors();
			}
		});
		btnConfigure.setBounds(603, 350, 97, 25);
		frame.getContentPane().add(btnConfigure);

		cboRotorIdentifier_1 = new JComboBox<EnumRotors>();
		cboRotorIdentifier_1.setBounds(293, 379, 127, 22);
		frame.getContentPane().add(cboRotorIdentifier_1);

		cboRotorDirection_1 = new JComboBox<String>();
		cboRotorDirection_1.setBounds(432, 379, 116, 22);
		frame.getContentPane().add(cboRotorDirection_1);

		txtRotorOffset_1 = new JTextField();
		txtRotorOffset_1.setColumns(10);
		txtRotorOffset_1.setBounds(560, 379, 31, 22);
		frame.getContentPane().add(txtRotorOffset_1);

		cboRotorIdentifier_2 = new JComboBox<EnumRotors>();
		cboRotorIdentifier_2.setBounds(293, 406, 127, 22);
		frame.getContentPane().add(cboRotorIdentifier_2);

		cboRotorDirection_2 = new JComboBox<String>();
		cboRotorDirection_2.setBounds(432, 406, 116, 22);
		frame.getContentPane().add(cboRotorDirection_2);

		txtRotorOffset_2 = new JTextField();
		txtRotorOffset_2.setColumns(10);
		txtRotorOffset_2.setBounds(560, 406, 31, 22);
		frame.getContentPane().add(txtRotorOffset_2);

		JLabel lblK = new JLabel("k1");
		lblK.setBounds(225, 354, 56, 16);
		frame.getContentPane().add(lblK);

		JLabel lblK_1 = new JLabel("k2");
		lblK_1.setBounds(225, 382, 56, 16);
		frame.getContentPane().add(lblK_1);

		JLabel lblK_2 = new JLabel("k3");
		lblK_2.setBounds(225, 409, 56, 16);
		frame.getContentPane().add(lblK_2);

		JLabel lblReflector = new JLabel("REFLECTOR");
		lblReflector.setBounds(12, 13, 79, 16);
		frame.getContentPane().add(lblReflector);

		JLabel lblNewLabel = new JLabel("R3");
		lblNewLabel.setBounds(20, 58, 56, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("R2");
		lblNewLabel_1.setBounds(20, 140, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("R1");
		lblNewLabel_2.setBounds(20, 223, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblUp = new JLabel("up");
		lblUp.setBounds(62, 179, 14, 16);
		frame.getContentPane().add(lblUp);

		JLabel lblDown = new JLabel("down");
		lblDown.setBounds(45, 140, 31, 16);
		frame.getContentPane().add(lblDown);

		JLabel label = new JLabel("down");
		label.setBounds(45, 224, 31, 16);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("up");
		label_1.setBounds(62, 256, 14, 16);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("down");
		label_2.setBounds(45, 58, 31, 16);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("up");
		label_3.setBounds(62, 90, 14, 16);
		frame.getContentPane().add(label_3);

		Letters = new JSeries();
		Letters.setBounds(88, 309, 882, 32);
		frame.getContentPane().add(Letters);

		JLabel lblLetters = new JLabel("Letters");
		lblLetters.setBounds(20, 308, 56, 16);
		frame.getContentPane().add(lblLetters);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(88, 639, 603, 49);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textField_3 = new JTextField();
		textField_3.setForeground(Color.RED);
		textField_3.setBounds(12, 13, 44, 22);
		panel.add(textField_3);
		textField_3.setColumns(1);

		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setBounds(62, 12, 97, 25);
		panel.add(btnEncrypt);

		JLabel lblEncrypted = new JLabel("");
		lblEncrypted.setForeground(Color.BLUE);
		lblEncrypted.setBounds(171, 13, 56, 16);
		panel.add(lblEncrypted);

		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setBounds(239, 12, 97, 25);
		panel.add(btnDecrypt);

		JLabel lblDecrypted = new JLabel("");
		lblDecrypted.setBounds(348, 13, 56, 16);
		panel.add(lblDecrypted);

		JButton btnRotate = new JButton("Rotate");
		btnRotate.setBounds(482, 12, 97, 25);
		panel.add(btnRotate);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(91, 459, 708, 82);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		txtEncryptAll = new JTextField();
		txtEncryptAll.setBounds(12, 13, 574, 22);
		panel_1.add(txtEncryptAll);
		txtEncryptAll.setColumns(10);

		JButton btnEncryptAll = new JButton("Encrypt");
		btnEncryptAll.setBounds(598, 12, 97, 25);
		panel_1.add(btnEncryptAll);

		txtDecryptAll = new JTextField();
		txtDecryptAll.setBounds(12, 48, 574, 22);
		panel_1.add(txtDecryptAll);
		txtDecryptAll.setColumns(10);

		JButton btnDecryptAll = new JButton("Decrypt");
		btnDecryptAll.setBounds(598, 47, 97, 25);
		panel_1.add(btnDecryptAll);

		JLabel lblEncryptDecrypt = new JLabel("Encrypt / Decrypt message (characters a-z)");
		lblEncryptDecrypt.setBounds(88, 441, 708, 16);
		frame.getContentPane().add(lblEncryptDecrypt);

		JLabel lblUseThisSection = new JLabel("Use this section to test individual letters and rotation");
		lblUseThisSection.setBounds(88, 569, 603, 16);
		frame.getContentPane().add(lblUseThisSection);

		JLabel lblTestEachLetter = new JLabel(
				"For each letter provided in the string above, copy the character in the textbox. Click \"Encrypt\" ");
		lblTestEachLetter.setVerticalAlignment(SwingConstants.TOP);
		lblTestEachLetter.setBounds(88, 595, 631, 15);
		frame.getContentPane().add(lblTestEachLetter);

		JLabel lblAnddecryptTo = new JLabel(
				"and \"Decrypt\" to validate the result. Click \"Rotate\" and repeat for the next letter.");
		lblAnddecryptTo.setBounds(88, 610, 667, 16);
		frame.getContentPane().add(lblAnddecryptTo);
		btnDecryptAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetRotors();

				txtEncryptAll.setText("");

				String val = txtDecryptAll.getText();
				for (int i = 0; i < val.length(); i++) {
					txtEncryptAll
							.setText(txtEncryptAll.getText() + (char) (engine.encrypt((int) val.charAt(i) - 97) + 97));
					engine.rotate();
				}

				resetRotors();
			}
		});
		btnEncryptAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetRotors();

				txtDecryptAll.setText("");

				String val = txtEncryptAll.getText();
				for (int i = 0; i < val.length(); i++) {
					txtDecryptAll
							.setText(txtDecryptAll.getText() + (char) (engine.encrypt((int) val.charAt(i) - 97) + 97));
					engine.rotate();
				}

				resetRotors();
			}
		});
		btnRotate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				engine.rotate();
				displayRotors(engine);
			}
		});
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = engine.encrypt(((int) lblEncrypted.getText().charAt(0)) - 97);
				lblDecrypted.setText(Character.toString((char) (index + 97)));
			}
		});
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int indexIn = ((int) textField_3.getText().charAt(0)) - 97;
				Letters.select(indexIn,Color.RED);

				R1_1.select(indexIn, Color.RED);
				indexIn = engine.getRotors()[0].getIndexOut(indexIn, 0);

				R2_1.select(indexIn, Color.RED);
				indexIn = engine.getRotors()[1].getIndexOut(indexIn, 0);

				R3_1.select(indexIn, Color.RED);
				indexIn = engine.getRotors()[2].getIndexOut(indexIn, 0);

				R4.select(indexIn, Color.black);
				R4.getCells()[indexIn].setForeground(Color.RED);
				indexIn = engine.getReflector().getIndexOut(indexIn);
				R4.getCells()[indexIn].setForeground(Color.blue);

				R3_2.select(indexIn, Color.blue);
				indexIn = engine.getRotors()[2].getIndexOut(indexIn, 1);

				R2_2.select(indexIn, Color.blue);
				indexIn = engine.getRotors()[1].getIndexOut(indexIn, 1);

				R1_2.select(indexIn, Color.blue);
				indexIn = engine.getRotors()[0].getIndexOut(indexIn, 1);

				Letters.getCells()[indexIn].setForeground(Color.BLUE);

				lblEncrypted.setText(Character.toString((char) (indexIn + 97)));
				lblDecrypted.setText("");
			}
		});

	}

	private void loadArray(JSeries series, int[] values, int startIndex) {
		series.Load(values, startIndex);
	}

	private void loadArray(JSeries series, char[] values, int startIndex) {
		series.Load(values, startIndex);
	}

	private void loadLists() {
		this.cboRotorIdentifier_0.removeAllItems();
		this.cboRotorIdentifier_0.addItem(EnumRotors.Rotor1);
		this.cboRotorIdentifier_0.addItem(EnumRotors.Rotor2);
		this.cboRotorIdentifier_0.addItem(EnumRotors.Rotor3);
		this.cboRotorIdentifier_1.removeAllItems();
		this.cboRotorIdentifier_1.addItem(EnumRotors.Rotor1);
		this.cboRotorIdentifier_1.addItem(EnumRotors.Rotor2);
		this.cboRotorIdentifier_1.addItem(EnumRotors.Rotor3);
		this.cboRotorIdentifier_2.removeAllItems();
		this.cboRotorIdentifier_2.addItem(EnumRotors.Rotor1);
		this.cboRotorIdentifier_2.addItem(EnumRotors.Rotor2);
		this.cboRotorIdentifier_2.addItem(EnumRotors.Rotor3);

		this.cboRotorDirection_0.removeAllItems();
		this.cboRotorDirection_0.addItem(EnumDirection.Left);
		this.cboRotorDirection_0.addItem(EnumDirection.Right);
		this.cboRotorDirection_1.removeAllItems();
		this.cboRotorDirection_1.addItem(EnumDirection.Left);
		this.cboRotorDirection_1.addItem(EnumDirection.Right);
		this.cboRotorDirection_2.removeAllItems();
		this.cboRotorDirection_2.addItem(EnumDirection.Left);
		this.cboRotorDirection_2.addItem(EnumDirection.Right);

	}

	private void resetRotors() {
		key1 = new KeyItem((EnumRotors) cboRotorIdentifier_0.getSelectedItem(),
				(EnumDirection) cboRotorDirection_0.getSelectedItem(), Integer.parseInt(txtRotorOffset_0.getText()));
		key2 = new KeyItem((EnumRotors) cboRotorIdentifier_1.getSelectedItem(),
				(EnumDirection) cboRotorDirection_1.getSelectedItem(), Integer.parseInt(txtRotorOffset_1.getText()));
		key3 = new KeyItem((EnumRotors) cboRotorIdentifier_2.getSelectedItem(),
				(EnumDirection) cboRotorDirection_2.getSelectedItem(), Integer.parseInt(txtRotorOffset_2.getText()));

		// load key
		// the order in which they are provided in the Key constructor
		// indicates the ORDER of rotation
		// try different combinations and check results
		key = new Key(key1, key2, key3);

		// CONFIGURE the engine by providing a key
		engine.init(key);

		displayRotors(engine);
	}

	private void displayKey(Key key) {
		this.cboRotorIdentifier_0.setSelectedItem(key.getKeyItems()[0].getIdentifier());
		this.cboRotorDirection_0.setSelectedItem(key.getKeyItems()[0].getDirection());
		this.txtRotorOffset_0.setText("" + key.getKeyItems()[0].getOffset());

		this.cboRotorIdentifier_1.setSelectedItem(key.getKeyItems()[1].getIdentifier());
		this.cboRotorDirection_1.setSelectedItem(key.getKeyItems()[1].getDirection());
		this.txtRotorOffset_1.setText("" + key.getKeyItems()[1].getOffset());

		this.cboRotorIdentifier_2.setSelectedItem(key.getKeyItems()[2].getIdentifier());
		this.cboRotorDirection_2.setSelectedItem(key.getKeyItems()[2].getDirection());
		this.txtRotorOffset_2.setText("" + key.getKeyItems()[2].getOffset());
	}

	private void displayRotors(Engine engine) {
		// R4
		loadArray(R4, engine.getReflector().getSerie().getValues(), 0);
		loadArray(R3_2, engine.getRotors()[2].getSeries()[1].getValues(), engine.getRotors()[2].getOffset());
		loadArray(R3_1, engine.getRotors()[2].getSeries()[0].getValues(), engine.getRotors()[2].getOffset());
		loadArray(R2_2, engine.getRotors()[1].getSeries()[1].getValues(), engine.getRotors()[1].getOffset());
		loadArray(R2_1, engine.getRotors()[1].getSeries()[0].getValues(), engine.getRotors()[1].getOffset());
		loadArray(R1_2, engine.getRotors()[0].getSeries()[1].getValues(), engine.getRotors()[0].getOffset());
		loadArray(R1_1, engine.getRotors()[0].getSeries()[0].getValues(), engine.getRotors()[0].getOffset());

		char[] letters = new char[26];

		for (int i = 0; i < 26; i++)
			letters[i] = (char) (i + 97);

		loadArray(Letters, letters, 0);

	}
}
