package fr.userinterface.leftpart.researchpanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class PurchaseSearchPanel extends JPanel{
    /** The panel main color */
    private Color mainColor;

    /** The panel title*/
    private JLabel searchTitle;

    /** The text field to enter the drug's name */ 
    private JTextField drug;

    /** The text field to enter the drug's quantity bought */
    private JTextField quantity;

    /** The text field to enter the purchase's date */
    private JTextField date;

    /** The button panel to search the drug */
    private SearchButton searchButton;

    /** The button label to search the drug */
    private JLabel searchButtonLabel;

    /** The button panel to add a new drug */
    private JPanel newButton;

    /** The button label to add a new drug */
    private JLabel newButtonLabel;

    /**
     * Ctor of the drug research panel
     * @param mainColor The panel's main color
     */
    public PurchaseSearchPanel(Color mainColor) {
	/* Set the main color then assign it to the panel*/
	this.mainColor = mainColor;
	this.setBackground(this.mainColor);
	
	/* Create the panel's layout and set the size and number of rows and columns */
	GridBagLayout gbl_this = new GridBagLayout();
	gbl_this.columnWidths = new int[] {30, 30, 180, 30, 30};
	gbl_this.rowHeights = new int[] {30, 30, 20, 30, 20, 30, 20, 30, 50, 30, 100, 0};
	gbl_this.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0};
	gbl_this.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
	this.setLayout(gbl_this);

	/* Create the panel title with its layout constraints*/
	this.searchTitle = new JLabel("Recherche");
	this.searchTitle.setHorizontalAlignment(SwingConstants.CENTER);
	this.searchTitle.setForeground(Color.WHITE);
	this.searchTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
	GridBagConstraints gbc_searchTitle = new GridBagConstraints();
	gbc_searchTitle.gridwidth = 4;
	gbc_searchTitle.gridx = 1;
	gbc_searchTitle.gridy = 0;
	gbc_searchTitle.fill = GridBagConstraints.BOTH;
	this.add(this.searchTitle, gbc_searchTitle);

	/* Create the drug text field and its constraints */
	this.drug = new JTextField();
	this.drug.setForeground(Color.LIGHT_GRAY);
	this.drug.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	this.drug.setText("medicament");
	this.drug.setHorizontalAlignment(SwingConstants.CENTER);
	this.drug.setBorder(null);
	GridBagConstraints gbc_drug = new GridBagConstraints();
	gbc_drug.gridwidth = 3;
	gbc_drug.gridx = 1;
	gbc_drug.gridy = 2;
	gbc_drug.fill = GridBagConstraints.BOTH;
	this.add(this.drug, gbc_drug);

	/* Create the quantity text field and its constraint */
	this.quantity = new JTextField();
	this.quantity.setForeground(Color.LIGHT_GRAY);
	this.quantity.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	this.quantity.setText("quantité");
	this.quantity.setHorizontalAlignment(SwingConstants.CENTER);
	this.quantity.setBorder(null);
	GridBagConstraints gbc_quantity = new GridBagConstraints();
	gbc_quantity.gridwidth = 3;
	gbc_quantity.gridx = 1;
	gbc_quantity.gridy = 4;
	gbc_quantity.fill = GridBagConstraints.BOTH;
	this.add(this.quantity, gbc_quantity);

	/* Create the date text field and its constraints */
	this.date = new JTextField();
	this.date.setForeground(Color.LIGHT_GRAY);
	this.date.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	this.date.setHorizontalAlignment(SwingConstants.CENTER);
	this.date.setText("jj/mm/aaaa");
	this.date.setBorder(null);
	GridBagConstraints gbc_date = new GridBagConstraints();
	gbc_date.gridwidth = 3;
	gbc_date.gridx = 1;
	gbc_date.gridy = 6;
	gbc_date.fill = GridBagConstraints.BOTH;
	this.add(this.date, gbc_date);
	this.date.setColumns(10);

	/* Create the search button and its constraints */
	this.searchButton = new SearchButton();
	/* The action of the button when it's clicked */
	this.searchButton.addMouseListener(new MouseAdapter() {
	    public void mouseEntered(MouseEvent e)
	    {
	        searchButton.mouseEnter();
	    }
	    
	    public void mouseExited(MouseEvent e)
	    {
	        searchButton.mouseExit();
	    }
	});
	GridBagConstraints gbc_searchButton = new GridBagConstraints();
	gbc_searchButton.gridx = 2;
	gbc_searchButton.gridy = 8;
	gbc_searchButton.fill = GridBagConstraints.BOTH;
	this.add(this.searchButton, gbc_searchButton);

	/* Create the new button and its constraints */
	this.newButton = new JPanel();
	this.newButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color.decode("#00004F"))));
	this.newButton.setBackground(this.mainColor);
	GridBagConstraints gbc_newButton = new GridBagConstraints();
	gbc_newButton.gridwidth = 5;
	gbc_newButton.fill = GridBagConstraints.BOTH;
	gbc_newButton.gridx = 0;
	gbc_newButton.gridy = 10;
	this.add(newButton, gbc_newButton);
	this.newButton.setLayout(new GridLayout(1, 0, 0, 0));

	/* Create the new button label and its constraints */
	this.newButtonLabel = new JLabel("Nouveau");
	this.newButtonLabel.setForeground(Color.decode("#00004F"));
	this.newButtonLabel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
	this.newButtonLabel.setHorizontalAlignment(SwingConstants.CENTER);
	this.newButton.add(this.newButtonLabel);
    }
    
    public String[] getResearch() {
	String[] researches = new String[] {this.drug.getText(), this.quantity.getText(), this.date.getText()};
	return researches;
    }
}
