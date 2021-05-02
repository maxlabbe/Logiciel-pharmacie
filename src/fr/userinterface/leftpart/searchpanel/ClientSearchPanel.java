package fr.userinterface.leftpart.searchpanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import fr.userinterface.newframe.NewCustomerFrame;

/**
 * This class is the client advance research panel of the user interface. 
 * It contains the fields to search a client and a button to add a new one
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class ClientSearchPanel extends JPanel{
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

    /**
     * Ctor of the client research panel
     * @param mainColor The panel's main color
     */
    public ClientSearchPanel(Color mainColor) {
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

	/* Create the name text field and its constraints */
	this.nom = new JTextField();
	this.nom.setForeground(Color.LIGHT_GRAY);
	this.nom.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	this.nom.setText("nom");
	this.nom.setHorizontalAlignment(SwingConstants.CENTER);
	this.nom.setBorder(null);
	GridBagConstraints gbc_nom = new GridBagConstraints();
	gbc_nom.gridwidth = 3;
	gbc_nom.gridx = 1;
	gbc_nom.gridy = 2;
	gbc_nom.fill = GridBagConstraints.BOTH;
	this.add(this.nom, gbc_nom);

	/* Create the first name text field and its constraint */
	this.firstName = new JTextField();
	this.firstName.setForeground(Color.LIGHT_GRAY);
	this.firstName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	this.firstName.setText("prenom");
	this.firstName.setHorizontalAlignment(SwingConstants.CENTER);
	this.firstName.setBorder(null);
	GridBagConstraints gbc_firstName = new GridBagConstraints();
	gbc_firstName.gridwidth = 3;
	gbc_firstName.gridx = 1;
	gbc_firstName.gridy = 4;
	gbc_firstName.fill = GridBagConstraints.BOTH;
	this.add(this.firstName, gbc_firstName);

	/* Create the date of birth text field and its constraints */
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
	
	this.newButton.addMouseListener(new MouseAdapter() {
	    public void mousePressed(MouseEvent e)
	    {
	        OpenCustomerFrame();
	    }
	    
	    public void mouseEntered(MouseEvent e)
	    {
	        newButtonMouseEnter();
	    }
	    
	    public void mouseExited(MouseEvent e)
	    {
	        newButtonMouseExit();
	    }
	});
    }
    
    /**
     * The new button behavior when clicked
     */
    public void OpenCustomerFrame()
    {
	NewCustomerFrame customerFrame = new NewCustomerFrame(this.mainColor);
	customerFrame.setVisible(true);
    }
    
    /**
     * The new button behavior when entered
     */
    public void newButtonMouseEnter()
    {
	this.newButton.setBackground(Color.decode("#B0F2B6"));
        this.newButtonLabel.setForeground(this.mainColor);
    }
    
    /**
     * The new button behavior when exit
     */
    public void newButtonMouseExit()
    {
	this.newButton.setBackground(this.mainColor);
        this.newButtonLabel.setForeground(Color.decode("#00004F"));
    }
    

}
