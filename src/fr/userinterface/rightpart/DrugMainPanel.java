package fr.userinterface.rightpart;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.userinterface.database.Header;

/**
 * This class is the customer main panel. 
 * It contains the drugs data that the user want to watch.
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class DrugMainPanel extends JPanel{
    
    /**The panel main color */
    private Color mainColor;
    
    /**The header panel*/
    private Header drugHeader;
    
    /**The part that show the data*/
    private JScrollPane contentPanel;
    
    /**
     * Ctor of the drug main panel
     * @param mainColor The panel's main color
     */
    public DrugMainPanel(Color mainColor) {
	
	/*Set the main color*/
	this.mainColor = mainColor;
	this.setBackground(this.mainColor);
	
	/*Set the bag layout*/
	GridBagLayout gbl_rightPanel = new GridBagLayout();
	gbl_rightPanel.columnWidths = new int[] {686};
	gbl_rightPanel.rowHeights = new int[] {50, 750};
	gbl_rightPanel.columnWeights = new double[]{1.0};
	gbl_rightPanel.rowWeights = new double[]{1.0, 1.0};
	this.setLayout(gbl_rightPanel);

	/*Set the header panel*/
	String[] drugsPanelHeader = {"Nom", "Quantit�", "Laboratoire", "Type", "Actions"};
	this.drugHeader = new Header(drugsPanelHeader);
	this.drugHeader.setBackground(this.mainColor);
	GridBagConstraints gbc_HeadPanel = new GridBagConstraints();
	gbc_HeadPanel.fill = GridBagConstraints.BOTH;
	gbc_HeadPanel.gridx = 0;
	gbc_HeadPanel.gridy = 0;
	this.add(this.drugHeader, gbc_HeadPanel);

	/*Set the content panel*/
	this.contentPanel = new JScrollPane();
	GridBagConstraints gbc_contentPanel = new GridBagConstraints();
	gbc_contentPanel.fill = GridBagConstraints.BOTH;
	gbc_contentPanel.gridx = 0;
	gbc_contentPanel.gridy = 1;
	this.add(contentPanel, gbc_contentPanel);
    }

}
