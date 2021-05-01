package fr.userinterface.rightpart;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

import fr.userinterface.database.Header;
import fr.userinterface.database.TableRow;
import java.awt.Insets;
import java.awt.GridLayout;

import fr.data.customer.Customer;

/**
 * This class is the customer main panel. 
 * It contains the customers data that the user want to watch.
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class CustomerMainPanel extends JPanel{

    /**The panel main color */
    private Color mainColor;
    
    /**The header panel*/
    private Header customerHeader;

    /**The part that show the data*/
    private JPanel contentPanel;

    /**
     * Ctor of the customer main panel
     * @param mainColor The panel main color
     */
    public CustomerMainPanel(Color mainColor) {
	
	/*Set the main color*/
	this.mainColor = mainColor;
	this.setBackground(this.mainColor);
	
	/*Set the bag layout*/
	GridBagLayout gbl_rightPanel = new GridBagLayout();
	gbl_rightPanel.columnWidths = new int[] {686};
	gbl_rightPanel.rowHeights = new int[] {50, 750, 0};
	gbl_rightPanel.columnWeights = new double[]{1.0};
	gbl_rightPanel.rowWeights = new double[]{1.0, 1.0, 1.0};
	this.setLayout(gbl_rightPanel);
	
	/* Set the header*/
	String[] customersPanelHeader = {"Nom", "Prénom", "Date de naissance", "assurance", "Actions"};
	this.customerHeader = new Header(customersPanelHeader);
	this.customerHeader.setBackground(this.mainColor);
	GridBagConstraints gbc_HeadPanel = new GridBagConstraints();
	gbc_HeadPanel.insets = new Insets(0, 0, 5, 0);
	gbc_HeadPanel.fill = GridBagConstraints.BOTH;
	gbc_HeadPanel.gridx = 0;
	gbc_HeadPanel.gridy = 0;
	this.add(this.customerHeader, gbc_HeadPanel);

	JScrollPane scrollpane = new JScrollPane();
	GridBagConstraints scrollPaneConstraint = new GridBagConstraints();
	scrollPaneConstraint.fill = GridBagConstraints.BOTH;
	scrollPaneConstraint.gridx = 0;
	scrollPaneConstraint.gridy = 1;
	scrollpane.setLayout(new ScrollPaneLayout());
	this.add(scrollpane, scrollPaneConstraint);

	this.contentPanel = new JPanel();
	contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
	scrollpane.setViewportView(contentPanel);

	for(int i = 0; i < 100; i++) {
		String[] rowContent = {"test", "test", "test", "test", "test"};
		TableRow row = new TableRow(rowContent);
		this.contentPanel.add(row);
	}
    }

}
