package fr.userinterface.rightpart;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.data.customer.*;
import fr.data.drug.*;
import fr.data.purchase.*;
import fr.data.purchase.PurchaseDataBase;
import fr.userinterface.database.Header;
import fr.userinterface.database.Table;

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
    private JPanel tableCards;
    
    /**The customer table*/
    private Table<Customer> customerTable;
    
    /**The drug table*/
    private Table<Drug> drugTable;
    
    /**The purchase table*/
    private Table<Purchase> purchaseTable;

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
	tableCards = new JPanel();
	GridBagConstraints gbc_HeadPanel = new GridBagConstraints();
	gbc_HeadPanel.fill = GridBagConstraints.BOTH;
	gbc_HeadPanel.gridx = 0;
	gbc_HeadPanel.gridy = 0;
	this.add(tableCards);
	tableCards.setLayout(new CardLayout(0, 0));

	String[] customersPanelHeader = {"Nom", "Prénom", "Date de naissance", "assurance", "Actions"};
	customerTable = new Table<Customer>(CustomerDataBase.Instance(), customersPanelHeader, this.mainColor);
	tableCards.add(customerTable, "customersTable");

	String[] drugsPanelHeader = {"Nom", "Quantité", "Laboratoire", "Type", "Actions"};
	drugTable = new Table<Drug>(DrugsDataBase.Instance(), drugsPanelHeader, this.mainColor);
	tableCards.add(drugTable, "drugsTable");
	
	String[] purchasesPanelHeader = {"date", "montant", "ordonnance", "client", "Actions"};
	purchaseTable = new Table<Purchase>(PurchaseDataBase.Instance(), purchasesPanelHeader, this.mainColor);
	tableCards.add(purchaseTable, "purchasesTable");
    }
    
    /*Return the cards panel*/
    public JPanel getTableCards()
    {
	return this.tableCards;
    }

}
