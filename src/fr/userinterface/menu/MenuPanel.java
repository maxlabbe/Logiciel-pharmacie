package fr.userinterface.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.EventListenerList;

import fr.userinterface.event.MenuSelectedEvent;
import fr.userinterface.event.MenuSelectedListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * This class is the menu panel of the user interface. 
 * It generate button to add to the menu
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class MenuPanel extends JPanel{
    /** The main color of the panel */
    private Color mainColor;
    
    /** The panel title */
    private JLabel menuTitle;
    
    /** The client button */
    private MenuButton clientButton;
    
    /** The drug button */
    private MenuButton drugButton;
    
    /** The purchase button */
    private MenuButton purchaseButton;

    private EventListenerList listeners = new EventListenerList();
    
    /**
     * Ctor of the menu panel
     * @param mainColor
     */
    public MenuPanel(Color mainColor) {
	/** Set the main color and assign it */
	this.mainColor = mainColor;
	this.setBackground(this.mainColor);
	
	/** Set the bounds of the panel */
	this.setBounds(0, 0, 300, 300);
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] {300};
	gridBagLayout.rowHeights = new int[] {60, 75, 75, 75};
	gridBagLayout.columnWeights = new double[]{0.0};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
	setLayout(gridBagLayout);

	/* Create the panel title and its constraint */
	menuTitle = new JLabel("Menu");
	menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
	menuTitle.setForeground(Color.WHITE);
	menuTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
	GridBagConstraints gbc_menuTitle = new GridBagConstraints();
	gbc_menuTitle.insets = new Insets(0, 0, 5, 0);
	gbc_menuTitle.gridx = 0;
	gbc_menuTitle.gridy = 0;
	add(menuTitle, gbc_menuTitle);

	/* Create the client button, its constraint*/
	this.clientButton = new MenuButton(this.mainColor, "Client", new int[] {0, 60, 300, 75});
	GridBagConstraints gbc_clientButton = new GridBagConstraints();
	gbc_clientButton.anchor = GridBagConstraints.NORTH;
	gbc_clientButton.fill = GridBagConstraints.HORIZONTAL;
	gbc_clientButton.gridx = 0;
	gbc_clientButton.gridy = 1;
	this.add(this.clientButton, gbc_clientButton);
	
	/* The action of the button when it's clicked */
	clientButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		clientMousePressed();
	    }
	});

	/* Create the drug button, its constraint*/
	this.drugButton = new MenuButton (this.mainColor, "Médicament", new int[] {0, 135, 300, 75});
	GridBagConstraints gbc_drugButton = new GridBagConstraints();
	gbc_drugButton.anchor = GridBagConstraints.NORTH;
	gbc_drugButton.fill = GridBagConstraints.HORIZONTAL;
	gbc_drugButton.gridx = 0;
	gbc_drugButton.gridy = 2;
	this.add(drugButton, gbc_drugButton);
	
	/* The action of the button when it's clicked */
	drugButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		drugMousePressed();
	    }
	});

	/* Create the purchase button, its constraint*/
	this.purchaseButton = new MenuButton (this.mainColor, "Achat", new int[] {0, 210, 300, 75});
	GridBagConstraints gbc_purchaseButton = new GridBagConstraints();
	gbc_purchaseButton.anchor = GridBagConstraints.NORTH;
	gbc_purchaseButton.fill = GridBagConstraints.HORIZONTAL;
	gbc_purchaseButton.gridx = 0;
	gbc_purchaseButton.gridy = 3;
	this.add(purchaseButton, gbc_purchaseButton);
	
	/* The action of the button when it's clicked */
	purchaseButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		purchaseMousePressed();
	    }
	});
    }

    /**
     * The action when the client button is pressed
     */
    private void clientMousePressed() {
	clientButton.activateButton();
	drugButton.deactivateButton();
	purchaseButton.deactivateButton();
	OnMenuSelectedEvent(new MenuSelectedEvent(this, "customersPanel"));
    }

    /**
     * The action when the drug button is pressed 
     */
    private void drugMousePressed() {
	clientButton.deactivateButton();
	drugButton.activateButton();
	purchaseButton.deactivateButton();
	OnMenuSelectedEvent(new MenuSelectedEvent(this, "drugsPanel"));
    }

    /**
     * The action when the purchase button is pressed 
     */
    private void purchaseMousePressed() {
	clientButton.deactivateButton();
	drugButton.deactivateButton();
	purchaseButton.activateButton();
	OnMenuSelectedEvent(new MenuSelectedEvent(this, "purchasesPanel"));
    }

    public void OnMenuSelectedEvent(MenuSelectedEvent e){
	Object[] listeners = this.listeners.getListenerList();
	for(int i = 0; i < listeners.length; i+=2) {
	    if(listeners[i] == MenuSelectedListener.class) {
		((MenuSelectedListener)listeners[i+1]).OnMenuSelected(e);
	    }
	}
    }

    public void AddMenuSelectedListener(MenuSelectedListener listener) {
	listeners.add(MenuSelectedListener.class, listener);
    }
    public void RemoveMenuSelectedListener(MenuSelectedListener listener) {
	listeners.remove(MenuSelectedListener.class, listener);
    }
}
