package fr.userinterface.database;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TableRow extends JPanel {
    private JLabel[] valuesLabel;
    public TableRow(String[] values) {
	setLayout(new GridLayout(0, values.length, 0, 0));
	//this.setMaximumSize(new Dimension(this.getWidth(), 25));
	Dimension dimension = getMaximumSize();
	dimension.setSize(dimension.width, 25);
	this.setMaximumSize(dimension);
	valuesLabel = new JLabel[values.length];
	for(int i=0; i < values.length; i++){
	    valuesLabel[i] = new JLabel(values[i]);
	    add(valuesLabel[i]);
	}
    }
}
