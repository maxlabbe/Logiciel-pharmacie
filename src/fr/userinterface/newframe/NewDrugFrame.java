package fr.userinterface.newframe;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fr.data.customer.Customer;
import fr.data.customer.CustomerDataBase;
import fr.data.drug.*;

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
 * This class is the new drug frame of the user interface. 
 * It contains the fields to create a new drug and a button to save it.
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class NewDrugFrame extends JFrame {

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
    private JPanel typePanel;
    
    /**The first name field*/
    private JComboBox<MedicamentType> typeField;
    
    /**The panel that contain the laboratory field*/
    private JPanel laboratoryPanel;
    
    /**The laboratory field*/
    private JTextField laboratoryField;
    
    /**The panel that contain the price fields*/
    private JPanel pricePanel;
    
    /**The price number field*/
    private JTextField priceField;
    
    /**The panel that contain the quantity field*/
    private JPanel quantityPanel;
    
    /*The quantity field*/
    private JTextField quantityField;
    
    /**The save button*/
    private JPanel saveButtonPanel;
    
    /**The save button label*/
    private JLabel saveButtonLabel;

    /**
     * Ctor of new customer frame
     * @param mainColor the frame main color
     */
    public NewDrugFrame(Color mainColor) {
	/*Set the mane color*/
	this.mainColor = mainColor;
	
	/*Set the frame bounds*/
	setBounds(100, 100, 550, 300);
	
	/*Set the content panel and its layout*/
	this.contentPane = new JPanel();
	this.contentPane.setBackground(this.mainColor);
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(this.contentPane);
	GridBagLayout gbl_contentPane = new GridBagLayout();
	gbl_contentPane.columnWidths = new int[]{0, 0};
	gbl_contentPane.rowHeights = new int[] {40, 30, 30, 30, 30, 30, 40};
	gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
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
	this.titleLabel = new JLabel("Nouveau m\u00E9dicament");
	this.titleLabel.setForeground(Color.WHITE);
	this.titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
	this.titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	this.titlePanel.add(titleLabel);

	/*Set the name panel and its constraint*/
	this.namePanel = new JPanel(new GridLayout(0, 1, 0, 0));
	this.namePanel.setBackground(this.mainColor);
	GridBagConstraints gbc_namePanel = new GridBagConstraints();
	gbc_namePanel.insets = new Insets(10, 100, 5, 100);
	gbc_namePanel.fill = GridBagConstraints.BOTH;
	gbc_namePanel.gridx = 0;
	gbc_namePanel.gridy = 1;
	this.contentPane.add(namePanel, gbc_namePanel);

	/*Set the name field*/
	this.nameField = new JTextField();
	this.nameField.setBorder(null);
	this.nameField.setForeground(Color.LIGHT_GRAY);
	this.nameField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.nameField.setText("Nom");
	this.nameField.setHorizontalAlignment(SwingConstants.CENTER);
	this.namePanel.add(this.nameField);
	this.nameField.setColumns(10);

	/*Set the type panel and its constraint*/
	this.typePanel = new JPanel(new GridLayout(1, 0, 0, 0));
	this.typePanel.setBackground(this.mainColor);
	GridBagConstraints gbc_typePanel = new GridBagConstraints();
	gbc_typePanel.insets = new Insets(10, 100, 5, 100);
	gbc_typePanel.fill = GridBagConstraints.BOTH;
	gbc_typePanel.gridx = 0;
	gbc_typePanel.gridy = 2;
	this.contentPane.add(this.typePanel, gbc_typePanel);

	/*Set the type field*/
	this.typeField = new JComboBox<MedicamentType>(MedicamentType.values());
	this.typeField.setBorder(null);
	this.typeField.setForeground(Color.LIGHT_GRAY);
	this.typeField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.typePanel.add(typeField);

	/*Set the laboratory panel and its constraint*/
	this.laboratoryPanel = new JPanel();
	this.laboratoryPanel.setBackground(this.mainColor);
	GridBagConstraints gbc_laboratoryPanel = new GridBagConstraints();
	gbc_laboratoryPanel.insets = new Insets(10, 100, 5, 100);
	gbc_laboratoryPanel.fill = GridBagConstraints.BOTH;
	gbc_laboratoryPanel.gridx = 0;
	gbc_laboratoryPanel.gridy = 3;
	this.contentPane.add(this.laboratoryPanel, gbc_laboratoryPanel);

	/*Set the laboratory field*/
	laboratoryPanel.setLayout(new GridLayout(0, 1, 0, 0));
	this.laboratoryField = new JTextField();
	this.laboratoryField.setBorder(null);
	this.laboratoryField.setForeground(Color.LIGHT_GRAY);
	this.laboratoryField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.laboratoryField.setHorizontalAlignment(SwingConstants.CENTER);
	this.laboratoryField.setText("laboratoire");
	laboratoryPanel.add(this.laboratoryField);
	this.laboratoryField.setColumns(10);

	/*Set the price panel and its constraints*/
	this.pricePanel = new JPanel(new GridLayout(0, 1, 0, 0));
	this.pricePanel.setBackground(this.mainColor);
	GridBagConstraints gbc_inssurancePanel = new GridBagConstraints();
	gbc_inssurancePanel.insets = new Insets(10, 100, 5, 100);
	gbc_inssurancePanel.fill = GridBagConstraints.BOTH;
	gbc_inssurancePanel.gridx = 0;
	gbc_inssurancePanel.gridy = 4;
	this.contentPane.add(this.pricePanel, gbc_inssurancePanel);
	
	/*Set the price field*/
	this.priceField = new JTextField();
	this.priceField.setBorder(null);
	this.priceField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.priceField.setForeground(Color.LIGHT_GRAY);
	this.priceField.setHorizontalAlignment(SwingConstants.CENTER);
	this.priceField.setText("prix");
	this.pricePanel.add(this.priceField);
	this.priceField.setColumns(10);

	/*Set the quantity panel and its constraints*/
	quantityPanel = new JPanel(new GridLayout(1, 0, 0, 0));
	GridBagConstraints gbc_quantityPanel = new GridBagConstraints();
	gbc_quantityPanel.insets = new Insets(10, 100, 0, 100);
	gbc_quantityPanel.fill = GridBagConstraints.BOTH;
	gbc_quantityPanel.gridx = 0;
	gbc_quantityPanel.gridy = 5;
	contentPane.add(quantityPanel, gbc_quantityPanel);
	
	/*Set the quantity field*/
	quantityField = new JTextField();
	quantityField.setBorder(null);
	quantityField.setForeground(Color.LIGHT_GRAY);
	quantityField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	quantityField.setText("quantit\u00E9");
	quantityField.setHorizontalAlignment(SwingConstants.CENTER);
	quantityPanel.add(quantityField);
	quantityField.setColumns(10);
	
	/*Set the save button and its constraint*/
	this.saveButtonPanel = new JPanel(new GridLayout(0, 1, 0, 0));
	this.saveButtonPanel.setBackground(Color.decode("#59B3FF"));
	GridBagConstraints gbc_saveButtonPanel = new GridBagConstraints();
	gbc_saveButtonPanel.insets = new Insets(10, 200, 1, 200);
	gbc_saveButtonPanel.fill = GridBagConstraints.BOTH;
	gbc_saveButtonPanel.gridx = 0;
	gbc_saveButtonPanel.gridy = 6;
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
		double price = Double.parseDouble(priceField.getText());
		int quantity = Integer.parseInt(quantityField.getText());
		MedicamentType type = MedicamentType.ANALGÉSIQUES;
		Drug drug = new Drug(type,
			nameField.getText(),
			laboratoryField.getText(),
			price,
			quantity);
		DrugsDataBase.Instance().addDrug(drug);
		System.out.println("Drug Added");
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
