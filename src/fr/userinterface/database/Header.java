package fr.userinterface.database;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel{
    private JLabel[] headerLabel;
    public Header(String[] headers) {
	setLayout(new GridLayout(0, 5, 0, 0));
	
	headerLabel = new JLabel[headers.length];
	for(int i=0; i < headers.length; i++){
	    headerLabel[i] = new JLabel(headers[i]);
	    add(headerLabel[i]);
	}
    }
}