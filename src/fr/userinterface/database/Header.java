package fr.userinterface.database;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel{
    private JLabel[] headerLabel;
    public Header(String[] headers) {
	setLayout(new GridLayout(0, headers.length, 0, 0));
	headerLabel = new JLabel[headers.length];
	for(int i=0; i < headers.length; i++){
	    headerLabel[i] = new JLabel(headers[i]);
	    headerLabel[i].setForeground(Color.white);
	    add(headerLabel[i]);
	}
    }
}
