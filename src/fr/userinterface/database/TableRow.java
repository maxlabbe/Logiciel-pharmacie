package fr.userinterface.database;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TableRow extends JPanel {
    private JLabel[] valuesLabel;
    public TableRow(String[] values) {
	setLayout(new GridLayout(0, 5, 0, 0));
	
	valuesLabel = new JLabel[values.length];
	for(int i=0; i < values.length; i++){
	    valuesLabel[i] = new JLabel(values[i]);
	    add(valuesLabel[i]);
	}
    }
}
