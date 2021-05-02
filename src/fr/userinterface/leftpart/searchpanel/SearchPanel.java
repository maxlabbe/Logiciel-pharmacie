package fr.userinterface.leftpart.searchpanel;

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

import fr.data.Database;
import fr.data.event.DatabaseSearchEvent;

public class SearchPanel<T> extends JPanel {
    /** the database linked to this searchPanel */
    private Database<T> database;
    
    /** The panel main color */
    private Color mainColor;

    /** The panel title*/
    private JLabel searchTitle;

    /** The text field to enter the client's name */ 
    private JTextField nom;

    /** The text field to enter the client's first name */
    private JTextField firstName;

    /** The text field to enter the client's date of birth */
    private JTextField date;

    /** The button panel to search the client */
    private SearchButton searchButton;

    /** The button panel to add a new customer */
    private JPanel newButton;

    /** The button label to add a new customer */
    private JLabel newButtonLabel;
    
    private JTextField[] inputfields;

    /**
     * Ctor of the client research panel
     * @param mainColor The panel's main color
     */
    public SearchPanel(Database<T> database, String[] labels, Color mainColor) {
	this.database = database;
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

	this.inputfields = new JTextField[labels.length];
	for (int i = 0; i < labels.length; i++) {
	    this.inputfields[i] = new JTextField();
	    this.inputfields[i].setForeground(Color.LIGHT_GRAY);
	    this.inputfields[i].setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    this.inputfields[i].setHorizontalAlignment(SwingConstants.CENTER);
	    this.inputfields[i].setText(labels[i]);
	    this.inputfields[i].setBorder(null);
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridwidth = 3;
	    gbc.gridx = 1;
	    gbc.gridy = 2 + 2 * i;
	    gbc.fill = GridBagConstraints.BOTH;
	    this.add(this.inputfields[i], gbc);
	    this.inputfields[i].setColumns(10);
	}

	/* Create the search button and its constraints */
	this.searchButton = new SearchButton();
	/* The action of the button when it's clicked */
	this.searchButton.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent e)
	    {
		String[] searchData = new String[inputfields.length];
		for(int i =0; i<searchData.length;i++) {
		    searchData[i] = inputfields[i].getText();
		}
		database.SearchRows(new DatabaseSearchEvent(this, searchData));
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
	String[] researches = new String[] {this.nom.getText(), this.firstName.getText(), this.date.getText()};
	return researches;
    }
} 
