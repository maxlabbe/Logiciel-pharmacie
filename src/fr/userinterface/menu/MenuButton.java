package fr.userinterface.menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuButton extends JPanel{
    private JPanel indic;
    private JLabel label;

    public MenuButton(String label, int[] bounds) {
	this.setBackground(Color.decode("#69C3FF"));
	this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
	this.setLayout(null);
	
	this.indic = new JPanel();
	this.indic.setBackground(Color.decode("#69C3FF"));
	this.indic.setBounds(0, 0, 10, 75);
	this.add(indic);
	
	this.label = new JLabel(label);
	this.label.setHorizontalAlignment(SwingConstants.CENTER);
	this.label.setBounds(0, 0, 300, 75);
	this.add(this.label);
	this.label.setForeground(Color.white);
	this.label.setFont(new Font("Segoe UI", Font.PLAIN, 25));

    }
    
    public void activateButton() {
	this.setBackground(Color.decode("#CCE0FF"));
	indic.setBackground(Color.white);
	this.label.setForeground(Color.decode("#00004F"));
    }
    
    public void deactivateButton() {
	    this.setBackground(Color.decode("#69C3FF"));
	    this.indic.setBackground(Color.decode("#69C3FF"));
	    this.label.setForeground(Color.white);
    }

}
