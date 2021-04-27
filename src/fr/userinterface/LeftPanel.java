package fr.userinterface;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import fr.userinterface.menu.MenuPanel;
import fr.userinterface.researchPanel.ClientSearchPanel;

/**
 * This class is the left part of the user interface. 
 * It contains the menu panel and a search panel depending if the user is looking for a client, a medicine or a specific purchase
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class LeftPanel extends JPanel{
    /**The main color of the panel*/
    private Color mainColor;
    
    /**The menu panel*/
    private MenuPanel menuPanel;
    
    /**The research panel*/
    private ClientSearchPanel researchPanel;
    
    /**The visual separator between the menu panel and the research panel*/
    private JPanel separator;

    /**
     * Ctor of left panel
     * @param mainColor The main color of the panel
     */
    public LeftPanel(Color mainColor) {
	/* Set the main color then assign it to the panel*/
	this.mainColor = mainColor;
	this.setBackground(this.mainColor);
	
	/* Create the panel's layout and set the size and number of rows and columns */
	GridBagLayout gbl_leftPanel = new GridBagLayout();
	gbl_leftPanel.columnWidths = new int[] {25, 250, 25};
	gbl_leftPanel.rowHeights = new int[] {300, 5, 450};
	this.setLayout(gbl_leftPanel);
	
	/* Create the menu panel and set its constraints */
	this.menuPanel = new MenuPanel(this.mainColor);
	GridBagConstraints gbc_menuPanel = new GridBagConstraints();
	gbc_menuPanel.gridwidth = 3;
	gbc_menuPanel.gridx = 0;
	gbc_menuPanel.gridy = 0;
	gbc_menuPanel.fill = GridBagConstraints.BOTH;
	this.add(this.menuPanel, gbc_menuPanel);
	
	/* Create the separator panel and its constraint */
	this.separator = new JPanel();
	this.separator.setBackground(this.mainColor);
	this.separator.setForeground(Color.WHITE);
	this.separator.setBorder(new MatteBorder(5, 0, 0, 0, (Color) new Color(255, 255, 255)));
	GridBagConstraints gbc_separator = new GridBagConstraints();
	gbc_separator.gridx = 1;
	gbc_separator.gridy = 1;
	gbc_separator.fill = GridBagConstraints.BOTH;
	this.add(separator, gbc_separator);
	
	/* Create the search panel and its constraints */
	this.researchPanel = new ClientSearchPanel(this.mainColor);
	GridBagConstraints gbc_searchPanel = new GridBagConstraints();
	gbc_searchPanel.gridwidth = 3;
	gbc_searchPanel.gridx = 0;
	gbc_searchPanel.gridy = 2;
	gbc_searchPanel.fill = GridBagConstraints.BOTH;
	this.add(this.researchPanel, gbc_searchPanel);
    }

}
