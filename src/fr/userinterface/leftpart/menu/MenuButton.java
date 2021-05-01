package fr.userinterface.leftpart.menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * This class is the menu buttons of the user interface. 
 * It generate button to add to the menu
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class MenuButton extends JPanel{
    private Color mainColor;
    private JPanel indic;
    private JLabel label;

    /**
     * Ctor of menuButton
     * @param mainColor The main color of the button
     * @param label The label on the button
     * @param bounds The bounds of the button
     */
    public MenuButton(Color mainColor, String label, int[] bounds) {
	/* Assign the main color and set it*/
	this.mainColor = mainColor;
	this.setBackground(this.mainColor);
	
	/* Set the bounds of the button */
	this.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
	
	/* Set the layout of the button's main panel */
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{10, 290, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowHeights = new int[]{75, 0};
	gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	this.setLayout(gridBagLayout);

	/* Create the active indicator of the button and its constraints */
	this.indic = new JPanel();
	this.indic.setBackground(this.mainColor);
	GridBagConstraints gbc_indic = new GridBagConstraints();
	gbc_indic.anchor = GridBagConstraints.WEST;
	gbc_indic.fill = GridBagConstraints.VERTICAL;
	gbc_indic.gridx = 0;
	gbc_indic.gridy = 0;
	this.add(indic, gbc_indic);

	/* Create the button's label and its constraints */
	this.label = new JLabel(label);
	this.label.setHorizontalAlignment(SwingConstants.LEFT);
	this.label.setForeground(Color.white);
	this.label.setFont(new Font("Segoe UI", Font.PLAIN, 25));
	GridBagConstraints gbc_label = new GridBagConstraints();
	gbc_label.fill = GridBagConstraints.BOTH;
	gbc_label.gridx = 1;
	gbc_label.gridy = 0;
	this.add(this.label, gbc_label);

    }

    /**
     * The button's graphic behavior when it's activate.
     */
    public void activateButton() {
	this.setBackground(Color.decode("#B0F2B6"));
	indic.setBackground(Color.white);
	this.label.setForeground(Color.decode("#00004F"));
    }

    /**
     * The button's graphic behavior when it's deactivate
     */
    public void deactivateButton() {
	this.setBackground(this.mainColor);
	this.indic.setBackground(this.mainColor);
	this.label.setForeground(Color.white);
    }

}
