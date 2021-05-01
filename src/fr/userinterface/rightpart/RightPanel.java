package fr.userinterface.rightpart;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.userinterface.database.Header;

public class RightPanel extends JPanel{
    private Color mainColor;
    private JPanel mainPanelsCards;
    private CustomerMainPanel customerMainPanel;
    private DrugMainPanel drugMainPanel;
    private PurchaseMainPanel purchaseMainPanel;

    public RightPanel(Color color) {
	this.mainColor = color;
	setLayout(new GridLayout(0, 1, 0, 0));
	
	mainPanelsCards = new JPanel();
	GridBagConstraints gbc_HeadPanel = new GridBagConstraints();
	gbc_HeadPanel.fill = GridBagConstraints.BOTH;
	gbc_HeadPanel.gridx = 0;
	gbc_HeadPanel.gridy = 0;
	this.add(mainPanelsCards);
	mainPanelsCards.setLayout(new CardLayout(0, 0));
	
	customerMainPanel = new CustomerMainPanel(this.mainColor);
	mainPanelsCards.add(customerMainPanel, "customersPanel");
	
	drugMainPanel = new DrugMainPanel(this.mainColor);
	mainPanelsCards.add(drugMainPanel, "drugsPanel");
	
	purchaseMainPanel = new PurchaseMainPanel(this.mainColor);
	mainPanelsCards.add(purchaseMainPanel, "purchasesPanel");
    }
    
    public JPanel getMainPanelsCards()
    {
	return this.mainPanelsCards;
    }

}
