package fr.userinterface.rightpart;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * This class is the right part of the user interface. 
 * It contains the data that the user want to watch.
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class RightPanel extends JPanel{
    /**The panel main color*/
    private Color mainColor;
    
    /**The panel that contain the different main panels*/
    private JPanel mainPanelsCards;
    
    /**The customer main panel*/
    private CustomerMainPanel customerMainPanel;
    
    /**The drug main panel*/
    private DrugMainPanel drugMainPanel;
    
    /**The purchase main panel*/
    private PurchaseMainPanel purchaseMainPanel;

    /**
     * Ctor of the right panel
     * @param color The main color
     */
    public RightPanel(Color color) {
	/* Set the main color*/
	this.mainColor = color;
	
	/*Set the panel layout*/
	this.setLayout(new GridLayout(0, 1, 0, 0));
	
	/*Set the cards panel and its constraint*/
	mainPanelsCards = new JPanel();
	GridBagConstraints gbc_HeadPanel = new GridBagConstraints();
	gbc_HeadPanel.fill = GridBagConstraints.BOTH;
	gbc_HeadPanel.gridx = 0;
	gbc_HeadPanel.gridy = 0;
	this.add(mainPanelsCards);
	mainPanelsCards.setLayout(new CardLayout(0, 0));
	
	/*Set the customer main panel and add it to the cards*/
	customerMainPanel = new CustomerMainPanel(this.mainColor);
	mainPanelsCards.add(customerMainPanel, "customersPanel");
	
	/*Set the drug main panel and add it to the cards*/
	drugMainPanel = new DrugMainPanel(this.mainColor);
	mainPanelsCards.add(drugMainPanel, "drugsPanel");
	
	/*Set the purchase main panel and add it to the cards*/
	purchaseMainPanel = new PurchaseMainPanel(this.mainColor);
	mainPanelsCards.add(purchaseMainPanel, "purchasesPanel");
    }
    
    /*Return the cards panel*/
    public JPanel getMainPanelsCards()
    {
	return this.mainPanelsCards;
    }

}
