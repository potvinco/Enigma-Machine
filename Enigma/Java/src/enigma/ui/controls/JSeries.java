package enigma.ui.controls;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import enigma.lib.Math;

public class JSeries extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel[] _cells;
	private final int _height = 32;
	private final int _width = 34;
	
	public JSeries() {

		this.setLayout(null);

		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	}
	
	public JLabel[] getCells() {
		return _cells;
	}
	public void setCells(JLabel[] cells) {
		this._cells = cells;
	}
  
	public void Load(int[] values, int startIndex) {
		if(this._cells != null) {
		for(JLabel label : this._cells)
			this.remove(label);
		this.repaint();
		}
		
		this._cells = new JLabel[values.length];
		for(int i =0;i< values.length;i++){
			this._cells[i] = new JLabel();
			this._cells[i].setText("" + values[Math.Modulus(startIndex + i,26)]);
			this._cells[i].setHorizontalAlignment(SwingConstants.CENTER);
			this._cells[i].setSize(_width, _height);
			this._cells[i].setLocation(i*_width, 0);

			this._cells[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			this.add(this._cells[i]);
		}
	}
	public void Load(char[] values, int startIndex) {
		if(this._cells != null) {
		for(JLabel label : this._cells)
			this.remove(label);
		this.repaint();
		}
		
		this._cells = new JLabel[values.length];
		for(int i =0;i< values.length;i++){
			this._cells[i] = new JLabel();
			this._cells[i].setText("" + values[Math.Modulus(startIndex + i,26)]);
			this._cells[i].setHorizontalAlignment(SwingConstants.CENTER);
			this._cells[i].setSize(_width, _height);
			this._cells[i].setLocation(i*_width, 0);

			this._cells[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			this.add(this._cells[i]);
		}
	}
	public void select(int index, Color color) {
		for(JLabel label : this._cells)
			label.setForeground(Color.black);
		
		this._cells[index].setForeground(color);
	}
}
