package fr.userinterface.newframe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import fr.data.customer.Customer;
import fr.data.customer.CustomerDataBase;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Container;


import java.awt.Font;

/**
 * This class is the new customer frame of the user interface. 
 * It contains the fields to create a new customer and a button to save it.
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class NewCustomerFrame extends JFrame {

    /**The main color of the frame*/
    private Color mainColor;

    /**The panel that content all the fields*/
    private JPanel contentPane;

    /**The panel that content the title*/
    private JPanel titlePanel;

    /**The title*/
    private JLabel titleLabel;

    /**The panel that contain the name field*/
    private Container namePanel;

    /**The name field*/
    private JTextField nameField;
    
    /**The panel that contain the first name field*/
    private JPanel firstNamePanel;
    
    /**The first name field*/
    private JTextField firstNameField;
    
    /**The panel that contain the date of birth fields*/
    private JPanel birthPanel;
    
    /**The day field*/
    private JTextField dayField;
    
    /**The month field*/
    private JTextField monthField;
    
    /**The year field*/
    private JTextField yearField;
    
    /**The panel that contain the insurance fields*/
    private JPanel insurancePanel;
    
    /**The radio button that precise if the customer has an insurance*/
    private JRadioButton insuranceRadioButton;
    
    /**The insurance number field*/
    private JTextField insuranceNumberField;
    
    /**The save button*/
    private JPanel saveButtonPanel;
    
    /**The save button label*/
    private JLabel saveButtonLabel;

    /**
     * Ctor of new customer frame
     * @param mainColor the frame main color
     */
    public NewCustomerFrame(Color mainColor) {
	/*Set the mane color*/
	this.mainColor = mainColor;
	
	/*Set the frame bounds*/
	setBounds(100, 100, 450, 300);
	
	/*Set the content panel and its layout*/
	this.contentPane = new JPanel();
	this.contentPane.setBackground(this.mainColor);
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(this.contentPane);
	GridBagLayout gbl_contentPane = new GridBagLayout();
	gbl_contentPane.columnWidths = new int[]{0, 0};
	gbl_contentPane.rowHeights = new int[] {40, 30, 30, 30, 30, 40};
	gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
	this.contentPane.setLayout(gbl_contentPane);

	/*Set the title panel and its constraint*/
	this.titlePanel = new JPanel(new GridLayout(0, 1, 0, 0));
	this.titlePanel.setBackground(this.mainColor);
	GridBagConstraints gbc_titlePanel = new GridBagConstraints();
	gbc_titlePanel.fill = GridBagConstraints.BOTH;
	gbc_titlePanel.gridx = 0;
	gbc_titlePanel.gridy = 0;
	this.contentPane.add(this.titlePanel, gbc_titlePanel);

	/*Set the title*/
	this.titleLabel = new JLabel("Nouveau client");
	this.titleLabel.setForeground(Color.WHITE);
	this.titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
	this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	this.titlePanel.add(titleLabel);

	/*Set the name panel and its constraint*/
	this.namePanel = new JPanel(new GridLayout(0, 1, 0, 0));
	this.namePanel.setBackground(this.mainColor);
	GridBagConstraints gbc_namePanel = new GridBagConstraints();
	gbc_namePanel.insets = new Insets(10, 100, 0, 100);
	gbc_namePanel.fill = GridBagConstraints.BOTH;
	gbc_namePanel.gridx = 0;
	gbc_namePanel.gridy = 1;
	this.contentPane.add(namePanel, gbc_namePanel);

	/*Set the name field*/
	this.nameField = new JTextField();
	this.nameField.setBorder(null);
	this.nameField.setForeground(Color.LIGHT_GRAY);
	this.nameField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.nameField.setText("Name");
	this.nameField.setHorizontalAlignment(SwingConstants.CENTER);
	this.namePanel.add(this.nameField);
	this.nameField.setColumns(10);

	/*Set the first name panel and its constraint*/
	this.firstNamePanel = new JPanel(new GridLayout(1, 0, 0, 0));
	this.firstNamePanel.setBackground(this.mainColor);
	GridBagConstraints gbc_firstNamePanel = new GridBagConstraints();
	gbc_firstNamePanel.insets = new Insets(10, 100, 0, 100);
	gbc_firstNamePanel.fill = GridBagConstraints.BOTH;
	gbc_firstNamePanel.gridx = 0;
	gbc_firstNamePanel.gridy = 2;
	this.contentPane.add(this.firstNamePanel, gbc_firstNamePanel);

	/*Set the name field*/
	this.firstNameField = new JTextField();
	this.firstNameField.setBorder(null);
	this.firstNameField.setForeground(Color.LIGHT_GRAY);
	this.firstNameField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.firstNameField.setText("pr\u00E9nom");
	this.firstNameField.setHorizontalAlignment(SwingConstants.CENTER);
	this.firstNamePanel.add(firstNameField);
	this.firstNameField.setColumns(10);

	/*Set the birth panel and its constraint*/
	this.birthPanel = new JPanel();
	this.birthPanel.setBackground(this.mainColor);
	GridBagConstraints gbc_birthPanel = new GridBagConstraints();
	gbc_birthPanel.insets = new Insets(10, 100, 0, 100);
	gbc_birthPanel.fill = GridBagConstraints.BOTH;
	gbc_birthPanel.gridx = 0;
	gbc_birthPanel.gridy = 3;
	this.contentPane.add(this.birthPanel, gbc_birthPanel);
	
	/*Set the birth panel layout*/
	GridBagLayout gbl_birthPanel = new GridBagLayout();
	gbl_birthPanel.columnWidths = new int[]{0, 0, 0, 0};
	gbl_birthPanel.rowHeights = new int[] {30};
	gbl_birthPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
	gbl_birthPanel.rowWeights = new double[]{0.0};
	this.birthPanel.setLayout(gbl_birthPanel);

	/*Set the day field*/
	this.dayField = new JTextField();
	this.dayField.setBorder(null);
	this.dayField.setForeground(Color.LIGHT_GRAY);
	this.dayField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.dayField.setHorizontalAlignment(SwingConstants.CENTER);
	this.dayField.setText("JJ");
	GridBagConstraints gbc_dayField = new GridBagConstraints();
	gbc_dayField.insets = new Insets(0, 0, 0, 10);
	gbc_dayField.fill = GridBagConstraints.BOTH;
	gbc_dayField.gridx = 0;
	gbc_dayField.gridy = 0;
	birthPanel.add(this.dayField, gbc_dayField);
	this.dayField.setColumns(10);

	/*Set the month field*/
	this.monthField = new JTextField();
	this.monthField.setBorder(null);
	this.monthField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.monthField.setForeground(Color.LIGHT_GRAY);
	this.monthField.setText("MM");
	this.monthField.setHorizontalAlignment(SwingConstants.CENTER);
	GridBagConstraints gbc_monthField = new GridBagConstraints();
	gbc_monthField.insets = new Insets(0, 0, 0, 10);
	gbc_monthField.fill = GridBagConstraints.BOTH;
	gbc_monthField.gridx = 1;
	gbc_monthField.gridy = 0;
	this.birthPanel.add(this.monthField, gbc_monthField);
	this.monthField.setColumns(10);

	/*Set the year field*/
	this.yearField = new JTextField();
	this.yearField.setBorder(null);
	this.yearField.setForeground(Color.LIGHT_GRAY);
	this.yearField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.yearField.setText("AAAA");
	this.yearField.setHorizontalAlignment(SwingConstants.CENTER);
	GridBagConstraints gbc_yearField = new GridBagConstraints();
	gbc_yearField.fill = GridBagConstraints.BOTH;
	gbc_yearField.gridx = 2;
	gbc_yearField.gridy = 0;
	this.birthPanel.add(this.yearField, gbc_yearField);
	this.yearField.setColumns(10);

	/*Set the insurance panel and its constraints*/
	this.insurancePanel = new JPanel();
	this.insurancePanel.setBackground(this.mainColor);
	GridBagConstraints gbc_inssurancePanel = new GridBagConstraints();
	gbc_inssurancePanel.insets = new Insets(10, 100, 0, 100);
	gbc_inssurancePanel.fill = GridBagConstraints.BOTH;
	gbc_inssurancePanel.gridx = 0;
	gbc_inssurancePanel.gridy = 4;
	this.contentPane.add(this.insurancePanel, gbc_inssurancePanel);
	
	/*Set then insurance panel layout*/
	GridBagLayout gbl_inssurancePanel = new GridBagLayout();
	gbl_inssurancePanel.columnWidths = new int[]{0, 0, 0};
	gbl_inssurancePanel.rowHeights = new int[] {30};
	gbl_inssurancePanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
	gbl_inssurancePanel.rowWeights = new double[]{0.0};
	this.insurancePanel.setLayout(gbl_inssurancePanel);

	/*Set the insurance radio button*/
	this.insuranceRadioButton = new JRadioButton("");
	this.insuranceRadioButton.setBackground(this.mainColor);
	GridBagConstraints gbc_inssuranceRadioButton = new GridBagConstraints();
	gbc_inssuranceRadioButton.fill = GridBagConstraints.BOTH;
	gbc_inssuranceRadioButton.insets = new Insets(0, 0, 0, 5);
	gbc_inssuranceRadioButton.gridx = 0;
	gbc_inssuranceRadioButton.gridy = 0;
	this.insurancePanel.add(this.insuranceRadioButton, gbc_inssuranceRadioButton);

	/*Set the insurance number field*/
	this.insuranceNumberField = new JTextField();
	this.insuranceNumberField.setBorder(null);
	this.insuranceNumberField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.insuranceNumberField.setForeground(Color.LIGHT_GRAY);
	this.insuranceNumberField.setHorizontalAlignment(SwingConstants.CENTER);
	this.insuranceNumberField.setText("inssurance number");
	GridBagConstraints gbc_inssuranceNumberField = new GridBagConstraints();
	gbc_inssuranceNumberField.fill = GridBagConstraints.BOTH;
	gbc_inssuranceNumberField.gridx = 1;
	gbc_inssuranceNumberField.gridy = 0;
	this.insurancePanel.add(this.insuranceNumberField, gbc_inssuranceNumberField);
	this.insuranceNumberField.setColumns(10);

	/*Set the save button and its constraint*/
	this.saveButtonPanel = new JPanel(new GridLayout(0, 1, 0, 0));
	this.saveButtonPanel.setBackground(Color.decode("#59B3FF"));
	GridBagConstraints gbc_saveButtonPanel = new GridBagConstraints();
	gbc_saveButtonPanel.insets = new Insets(5, 150, 5, 150);
	gbc_saveButtonPanel.fill = GridBagConstraints.BOTH;
	gbc_saveButtonPanel.gridx = 0;
	gbc_saveButtonPanel.gridy = 5;
	this.contentPane.add(this.saveButtonPanel, gbc_saveButtonPanel);

	/*Set the save button label*/
	this.saveButtonLabel = new JLabel("sauvegarder");
	this.saveButtonLabel.setForeground(Color.decode("#00004F"));
	this.saveButtonLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.saveButtonLabel.setHorizontalAlignment(SwingConstants.CENTER);
	this.saveButtonPanel.add(this.saveButtonLabel);

	/*Set the action when save button is clicked or the mouse enter or exit the button*/
	this.saveButtonPanel.addMouseListener(new MouseAdapter() {
	    public void mouseEntered(MouseEvent e)
	    {
		mouseEnter();
	    }

	    public void mouseExited(MouseEvent e)
	    {
		mouseExit();
	    }
	    public void mouseClicked(MouseEvent e) {
		Customer customer = new Customer(nameField.getText(), firstNameField.getText(), Integer.parseInt(dayField.getText()), Integer.parseInt(monthField.getText()), Integer.parseInt(yearField.getText()));
		customer.setInsuranceNumber(Integer.parseInt(insuranceNumberField.getText()));
		CustomerDataBase.Instance().addCustomer(customer);
	    }
	});
    }

    /**
     * The button's graphic behavior when it's activate.
     */
    public void mouseEnter() {
	this.saveButtonPanel.setBackground(Color.decode("#79D3FF"));
    }

    /**
     * The button's graphic behavior when it's inactivate.
     */
    public void mouseExit() {
	this.saveButtonPanel.setBackground(Color.decode("#59B3FF"));
    }

}
