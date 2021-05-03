package fr.userinterface.leftpart;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import fr.data.customer.*;
import fr.data.drug.*;
import fr.data.purchase.*;
import fr.userinterface.event.MenuSelectedEvent;
import fr.userinterface.event.MenuSelectedListener;
import fr.userinterface.leftpart.menu.MenuPanel;
import fr.userinterface.leftpart.searchpanel.*;
import fr.userinterface.rightpart.RightPanel;



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
    private SearchPanel<Customer> customerSearchPanel;
    
    /**The research panel*/
    private SearchPanel<Drug> drugsSearchPanel;
    
    /**The research panel*/
    private SearchPanel<Purchase> purchasesSearchPanel;
    
    /**The visual separator between the menu panel and the research panel*/
    private JPanel separator;
    
    private JPanel searchCard;
    
    private JPanel tableCard;

    /**
     * Ctor of left panel
     * @param mainColor The main color of the panel
     */
    public LeftPanel(Color mainColor, RightPanel rightPanel) {
	/* Set the main color then assign it to the panel*/
	this.mainColor = mainColor;
	this.setBackground(this.mainColor);
	
	this.tableCard = rightPanel.getTableCards();
	
	/* Create the panel's layout and set the size and number of rows and columns */
	GridBagLayout gbl_leftPanel = new GridBagLayout();
	gbl_leftPanel.columnWidths = new int[] {25, 250, 25};
	gbl_leftPanel.rowHeights = new int[] {300, 5, 450};
	this.setLayout(gbl_leftPanel);
	
	/* Create the search panel and its constraints */
	this.searchCard = new JPanel(new CardLayout(0,0));
	
	String[] customerInputfieldsLabel = {"nom", "prenom", "jj/mm/aaaa"};
	this.customerSearchPanel = new SearchPanel<Customer>(Customer.class, CustomerDataBase.Instance(), customerInputfieldsLabel, this.mainColor);
	this.customerSearchPanel.setName("customerSearchPanel");

	String[] drugInputfieldsLabel = {"nom", "laboratory", "type"};
	this.drugsSearchPanel = new SearchPanel<Drug>(Drug.class, DrugsDataBase.Instance(), drugInputfieldsLabel, this.mainColor);
	this.drugsSearchPanel.setName("drugsSearchPanel");

	String[] purchaseInputfieldsLabel = {"purchase id", "customer id", "jj/mm/aaaa"};
	this.purchasesSearchPanel = new SearchPanel<Purchase>(Purchase.class, PurchaseDataBase.Instance(), purchaseInputfieldsLabel, this.mainColor);
	this.purchasesSearchPanel.setName("purchasesSearchPanel");
	
	GridBagConstraints gbcSearchPanel = new GridBagConstraints();
	gbcSearchPanel.gridwidth = 3;
	gbcSearchPanel.gridx = 0;
	gbcSearchPanel.gridy = 2;
	gbcSearchPanel.fill = GridBagConstraints.BOTH;
	
	this.add(searchCard, gbcSearchPanel);
	this.searchCard.add(this.customerSearchPanel, "customerSearchPanel");
	this.searchCard.add(this.drugsSearchPanel, "drugsSearchPanel");
	this.searchCard.add(this.purchasesSearchPanel, "purchasesSearchPanel");
	
	/* Create the menu panel and set its constraints */
	this.menuPanel = new MenuPanel(this.mainColor);
	this.menuPanel.AddMenuSelectedListener(new MenuSelectedListener() {

	    public void OnMenuSelected(MenuSelectedEvent e) {
		// TODO Auto-generated method stub
		((CardLayout)searchCard.getLayout()).show(searchCard, e.searchPanelName);
		
		((CardLayout)tableCard.getLayout()).show(tableCard, e.tableName);
	    }
	    
	});
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
    }

}
