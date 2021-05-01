package fr.userinterface.rightpart;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.userinterface.database.Header;

public class CustomerMainPanel extends JPanel{

    private Color mainColor;
    private Header customerHeader;
    private JScrollPane contentPanel;

    public CustomerMainPanel(Color mainColor) {
	this.mainColor = mainColor;
	this.setBackground(this.mainColor);
	GridBagLayout gbl_rightPanel = new GridBagLayout();
	gbl_rightPanel.columnWidths = new int[] {686};
	gbl_rightPanel.rowHeights = new int[] {50, 750};
	gbl_rightPanel.columnWeights = new double[]{1.0};
	gbl_rightPanel.rowWeights = new double[]{1.0, 1.0};
	this.setLayout(gbl_rightPanel);
	
	String[] customersPanelHeader = {"Nom", "Prénom", "Date de naissance", "assurance", "Actions"};
	this.customerHeader = new Header(customersPanelHeader);
	this.customerHeader.setBackground(this.mainColor);
	GridBagConstraints gbc_HeadPanel = new GridBagConstraints();
	gbc_HeadPanel.fill = GridBagConstraints.BOTH;
	gbc_HeadPanel.gridx = 0;
	gbc_HeadPanel.gridy = 0;
	this.add(this.customerHeader, gbc_HeadPanel);
	
	this.contentPanel = new JScrollPane();
	GridBagConstraints gbc_contentPanel = new GridBagConstraints();
	gbc_contentPanel.fill = GridBagConstraints.BOTH;
	gbc_contentPanel.gridx = 0;
	gbc_contentPanel.gridy = 1;
	this.add(contentPanel, gbc_contentPanel);
    }

}
