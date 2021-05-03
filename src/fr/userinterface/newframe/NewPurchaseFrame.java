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
import fr.data.drug.Drug;
import fr.data.drug.DrugsDataBase;
import fr.data.drug.MedicamentType;
import fr.data.purchase.*;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Container;


import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;

/**
 * This class is the new purchase frame of the user interface. 
 * It contains the fields to create a new purchase and a button to save it.
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class NewPurchaseFrame extends JFrame {

    /**The main color of the frame*/
    private Color mainColor;

    /**The panel that content all the fields*/
    private JPanel contentPane;

    /**The panel that content the title*/
    private JPanel titlePanel;

    /**The title*/
    private JLabel titleLabel;
    
    /**The panel that contain the date of purchase fields*/
    private JPanel datePanel;
    
    /**The day field*/
    private JTextField dayField;
    
    /**The month field*/
    private JTextField monthField;
    
    /**The year field*/
    private JTextField yearField;
    
    /**The panel that contain the prescription fields*/
    private JPanel prescriptionPanel;
    
    /**The radio button that precise if the purchase was made with a prescription*/
    private JRadioButton prescriptionButton;
    
    /**The prescription label*/
    private JLabel prescriptionLabel;
    
    private JComboBox<Customer> customerComboBox;
    
    /**The scroll panel that contain the drug field*/
    private JPanel drugsPanel;
    /**The save button*/
    private JPanel saveButtonPanel;
    
    /**The save button label*/
    private JLabel saveButtonLabel;
    private JPanel customerSelectionPanel;
    private JList<Drug> list;
    private JPanel panel_1;
    private JComboBox<Drug> DrugcomboBox;
    private JButton btnNewButton;
    private JTextField textField;
    private GridBagConstraints gbc_DrugcomboBox;
    private GridBagConstraints gbc_customerComboBox;
    
    private ArrayList<Drug> purchaseDrugs;
    /**
     * Ctor of new purchase frame
     * @param mainColor the frame main color
     */
    public NewPurchaseFrame(Color mainColor) {
	/*Set the mane color*/
	this.mainColor = mainColor;
	
	/*Init drugs purchased array */
	purchaseDrugs = new ArrayList<Drug>();
	
	/*Set the frame bounds*/
	setBounds(100, 100, 600, 500);
	
	/*Set the content panel and its layout*/
	this.contentPane = new JPanel();
	this.contentPane.setBackground(this.mainColor);
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(this.contentPane);
	GridBagLayout gbl_contentPane = new GridBagLayout();
	gbl_contentPane.columnWidths = new int[]{0, 0};
	gbl_contentPane.rowHeights = new int[] {30, 20, 150, 20, 20, 40};
	gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
	this.contentPane.setLayout(gbl_contentPane);

	/*Set the title panel and its constraint*/
	this.titlePanel = new JPanel(new GridLayout(0, 1, 0, 0));
	this.titlePanel.setBackground(this.mainColor);
	GridBagConstraints gbc_titlePanel = new GridBagConstraints();
	gbc_titlePanel.insets = new Insets(0, 0, 5, 0);
	gbc_titlePanel.fill = GridBagConstraints.BOTH;
	gbc_titlePanel.gridx = 0;
	gbc_titlePanel.gridy = 0;
	this.contentPane.add(this.titlePanel, gbc_titlePanel);

	/*Set the title*/
	this.titleLabel = new JLabel("Nouvel achat");
	this.titleLabel.setForeground(Color.WHITE);
	this.titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
	this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	this.titlePanel.add(titleLabel);

	/*Set the date panel and its constraint*/
	this.datePanel = new JPanel();
	this.datePanel.setBackground(this.mainColor);
	GridBagConstraints gbc_datePanel = new GridBagConstraints();
	gbc_datePanel.insets = new Insets(10, 100, 5, 100);
	gbc_datePanel.fill = GridBagConstraints.BOTH;
	gbc_datePanel.gridx = 0;
	gbc_datePanel.gridy = 1;
	this.contentPane.add(this.datePanel, gbc_datePanel);
	
	/*Set the date panel layout*/
	GridBagLayout gbl_datePanel = new GridBagLayout();
	gbl_datePanel.columnWidths = new int[]{0, 0, 0, 0};
	gbl_datePanel.rowHeights = new int[] {30};
	gbl_datePanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
	gbl_datePanel.rowWeights = new double[]{0.0};
	this.datePanel.setLayout(gbl_datePanel);

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
	datePanel.add(this.dayField, gbc_dayField);
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
	this.datePanel.add(this.monthField, gbc_monthField);
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
	this.datePanel.add(this.yearField, gbc_yearField);
	this.yearField.setColumns(10);

	/*Set the drug panel and its constraints*/
	drugsPanel = new JPanel();
	drugsPanel.setBorder(null);
	GridBagConstraints gbc_drugsPanel = new GridBagConstraints();
	gbc_drugsPanel.insets = new Insets(10, 50, 5, 50);
	gbc_drugsPanel.fill = GridBagConstraints.BOTH;
	gbc_drugsPanel.gridx = 0;
	gbc_drugsPanel.gridy = 2;
	contentPane.add(drugsPanel, gbc_drugsPanel);
	GridBagLayout gbl_drugsPanel = new GridBagLayout();
	gbl_drugsPanel.columnWidths = new int[] {50, 300};
	gbl_drugsPanel.rowHeights = new int[] {150};
	gbl_drugsPanel.columnWeights = new double[]{1.0, 0.0};
	gbl_drugsPanel.rowWeights = new double[]{0.0};
	drugsPanel.setLayout(gbl_drugsPanel);
	
	list = new JList<Drug>();
	GridBagConstraints gbc_list = new GridBagConstraints();
	gbc_list.insets = new Insets(0, 0, 0, 5);
	gbc_list.fill = GridBagConstraints.BOTH;
	gbc_list.gridx = 0;
	gbc_list.gridy = 0;
	drugsPanel.add(list, gbc_list);
	
	panel_1 = new JPanel();
	GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	gbc_panel_1.insets = new Insets(0, 5, 0, 0);
	gbc_panel_1.fill = GridBagConstraints.BOTH;
	gbc_panel_1.gridx = 1;
	gbc_panel_1.gridy = 0;
	drugsPanel.add(panel_1, gbc_panel_1);
	GridBagLayout gbl_panel_1 = new GridBagLayout();
	gbl_panel_1.columnWidths = new int[] {75, 75, 10, 30};
	gbl_panel_1.rowHeights = new int[] {0, 0};
	gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
	gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	panel_1.setLayout(gbl_panel_1);

	Drug[] drugArray = DrugsDataBase.Instance().GetRows().toArray(new Drug[DrugsDataBase.Instance().GetRows().size()]);
	DrugcomboBox = new JComboBox<Drug>(drugArray);
	gbc_DrugcomboBox = new GridBagConstraints();
	gbc_DrugcomboBox.fill = GridBagConstraints.HORIZONTAL;
	gbc_DrugcomboBox.gridwidth = 2;
	gbc_DrugcomboBox.anchor = GridBagConstraints.NORTH;
	gbc_DrugcomboBox.insets = new Insets(0, 0, 0, 5);
	gbc_DrugcomboBox.gridx = 0;
	gbc_DrugcomboBox.gridy = 0;
	panel_1.add(DrugcomboBox, gbc_DrugcomboBox);
	
	textField = new JTextField();
	GridBagConstraints gbc_textField = new GridBagConstraints();
	gbc_textField.anchor = GridBagConstraints.WEST;
	gbc_textField.insets = new Insets(0, 0, 0, 5);
	gbc_textField.gridx = 2;
	gbc_textField.gridy = 0;
	panel_1.add(textField, gbc_textField);
	textField.setColumns(10);
	
	btnNewButton = new JButton("Ajouter");
	GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
	gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
	gbc_btnNewButton.gridx = 3;
	gbc_btnNewButton.gridy = 0;
	panel_1.add(btnNewButton, gbc_btnNewButton);
	btnNewButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent event) {
		purchaseDrugs.add(new Drug((Drug)DrugcomboBox.getSelectedItem(), Integer.parseInt(textField.getText())));
		list.setListData(purchaseDrugs.toArray(new Drug[purchaseDrugs.size()]));
	    }
	});
	
	/*Set the prescription panel*/
	this.prescriptionPanel = new JPanel();
	this.prescriptionPanel.setBackground(this.mainColor);
	GridBagConstraints gbc_prescriptionPanel = new GridBagConstraints();
	gbc_prescriptionPanel.insets = new Insets(10, 100, 5, 100);
	gbc_prescriptionPanel.fill = GridBagConstraints.BOTH;
	gbc_prescriptionPanel.gridx = 0;
	gbc_prescriptionPanel.gridy = 3;
	this.contentPane.add(this.prescriptionPanel, gbc_prescriptionPanel);
	
	/*Set then prescription panel layout*/
	GridBagLayout gbl_prescriptionPanel = new GridBagLayout();
	gbl_prescriptionPanel.columnWidths = new int[]{0, 0, 0};
	gbl_prescriptionPanel.rowHeights = new int[] {30};
	gbl_prescriptionPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
	gbl_prescriptionPanel.rowWeights = new double[]{0.0};
	this.prescriptionPanel.setLayout(gbl_prescriptionPanel);

	/*Set the prescription radio button*/
	this.prescriptionButton = new JRadioButton("");
	this.prescriptionButton.setBackground(this.mainColor);
	GridBagConstraints gbc_prescriptionButton = new GridBagConstraints();
	gbc_prescriptionButton.fill = GridBagConstraints.BOTH;
	gbc_prescriptionButton.insets = new Insets(0, 0, 0, 5);
	gbc_prescriptionButton.gridx = 0;
	gbc_prescriptionButton.gridy = 0;
	this.prescriptionPanel.add(this.prescriptionButton, gbc_prescriptionButton);
	
	/*Set the prescription layout*/
	prescriptionLabel = new JLabel("ordonnance");
	prescriptionLabel.setForeground(Color.WHITE);
	prescriptionLabel.setBackground(Color.WHITE);
	prescriptionLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
	GridBagConstraints gbc_prescriptionLabel = new GridBagConstraints();
	gbc_prescriptionLabel.fill = GridBagConstraints.BOTH;
	gbc_prescriptionLabel.gridx = 1;
	gbc_prescriptionLabel.gridy = 0;
	prescriptionPanel.add(prescriptionLabel, gbc_prescriptionLabel);
	
	customerSelectionPanel = new JPanel();
	GridBagConstraints gbc_customerSelectionPanel = new GridBagConstraints();
	gbc_customerSelectionPanel.insets = new Insets(10, 100, 5, 100);
	gbc_customerSelectionPanel.fill = GridBagConstraints.HORIZONTAL;
	gbc_customerSelectionPanel.gridx = 0;
	gbc_customerSelectionPanel.gridy = 4;
	contentPane.add(customerSelectionPanel, gbc_customerSelectionPanel);
	GridBagLayout gbl_customerSelectionPanel = new GridBagLayout();
	gbl_customerSelectionPanel.columnWidths = new int[]{97, 30, 0};
	gbl_customerSelectionPanel.rowHeights = new int[]{22, 0};
	gbl_customerSelectionPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	gbl_customerSelectionPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	customerSelectionPanel.setLayout(gbl_customerSelectionPanel);
	Customer[] customerArray = CustomerDataBase.Instance().GetRows().toArray(new Customer[CustomerDataBase.Instance().GetRows().size()]);
	customerComboBox = new JComboBox<Customer>(customerArray);

	gbc_customerComboBox = new GridBagConstraints();
	gbc_customerComboBox.fill = GridBagConstraints.BOTH;
	gbc_customerComboBox.gridwidth = 3;
	gbc_customerComboBox.gridx = 0;
	gbc_customerComboBox.gridy = 0;
	customerSelectionPanel.add(customerComboBox, gbc_customerComboBox);

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
		//Purchase(int amount, int day, int month, int year, boolean prescription, Drug[] drugs, Customer customer)
		//Customer customer = CustomerDataBase.Instance().GetRows().get(0);
		Customer customer = (Customer)customerComboBox.getSelectedItem();
		
		/*Drug[] drugs = {
			drugsRows.get(0),
		};*/
		Purchase purchase = new Purchase(Integer.parseInt(dayField.getText()),
			Integer.parseInt(monthField.getText()),
			Integer.parseInt(yearField.getText()),
			true,
			purchaseDrugs.toArray(new Drug[purchaseDrugs.size()]),
			customer);
		PurchaseDataBase.Instance().addPurchase(purchase);
		
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
