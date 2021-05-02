package fr.userinterface.leftpart.researchpanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class SearchButton extends JPanel{
    JLabel buttonLabel;

    public SearchButton() {
	this.setBackground(Color.decode("#59B3FF"));
	setLayout(new GridLayout(1, 0, 0, 0));
	this.buttonLabel = new JLabel("rechercher");
	this.buttonLabel.setForeground(Color.decode("#00004F"));
	this.buttonLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
	this.add(buttonLabel);
    }

    /**
     * The button's graphic behavior when it's activate.
     */
    public void mouseEnter() {
	this.setBackground(Color.decode("#79D3FF"));
    }
    
    /**
     * The button's graphic behavior when it's inactivate.
     */
    public void mouseExit() {
	this.setBackground(Color.decode("#59B3FF"));
    }
    
}
