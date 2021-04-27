package fr.userinterface;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;

public class TestPanel extends JPanel {
    /**
     * Create the panel.
     */
    public TestPanel() {
	this.setLayout(null);
	
	JRadioButton rdbtnNewRadioButton = new JRadioButton("Client");
	rdbtnNewRadioButton.setBounds(51, 71, 103, 21);
	add(rdbtnNewRadioButton);

	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("medicaments");
	rdbtnNewRadioButton_1.setBounds(51, 116, 103, 21);
	add(rdbtnNewRadioButton_1);
	
	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("achat");
	rdbtnNewRadioButton_2.setBounds(51, 174, 103, 21);
	add(rdbtnNewRadioButton_2);

    }
    
    private void OnMenuSelected() {
	
    }
}
