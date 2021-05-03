package fr.userinterface.leftpart.searchpanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SearchButton extends JPanel{
    JLabel buttonLabel;

    public SearchButton() {
	this.setBackground(Color.decode("#0c8e0c"));
	setLayout(new GridLayout(1, 0, 0, 0));
	this.buttonLabel = new JLabel("rechercher");
	this.buttonLabel.setForeground(Color.white);
	this.buttonLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
	this.add(buttonLabel);
	/* The action of the button when it's clicked */
	addMouseListener(new MouseAdapter() {
	    public void mouseEntered(MouseEvent e)
	    {
	        mouseEnter();
	    }
	    
	    public void mouseExited(MouseEvent e)
	    {
	        mouseExit();
	    }
	});
    }

    /**
     * The button's graphic behavior when the mouse enter
     */
    public void mouseEnter() {
	this.setBackground(Color.decode("#0fb20f"));
    }
    
     /**
      *  The button's graphic behavior when the mouse exit
      */
    public void mouseExit() {
	this.setBackground(Color.decode("#0c8e0c"));
    }
}
