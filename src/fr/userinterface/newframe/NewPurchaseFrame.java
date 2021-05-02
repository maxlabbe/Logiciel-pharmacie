package fr.userinterface.newframe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Container;


import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

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

    /**The panel that contain the amount field*/
    private Container amountPanel;

    /**The amount field*/
    private JTextField amountField;
    
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
    
    /**The scroll panel that contain the drug field*/
    private JScrollPane drugsPanel;
    
    /**The drug text area*/
    private JTextArea drugsArea;
    /**The save button*/
    private JPanel saveButtonPanel;
    
    /**The save button label*/
    private JLabel saveButtonLabel;

    /**
     * Ctor of new purchase frame
     * @param mainColor the frame main color
     */
    public NewPurchaseFrame(Color mainColor) {
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
	gbl_contentPane.rowHeights = new int[] {40, 30, 30, 60, 30, 40};
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

	/*Set the amount panel and its constraint*/
	this.amountPanel = new JPanel(new GridLayout(0, 1, 0, 0));
	this.amountPanel.setBackground(this.mainColor);
	GridBagConstraints gbc_amountPanel = new GridBagConstraints();
	gbc_amountPanel.insets = new Insets(10, 100, 5, 100);
	gbc_amountPanel.fill = GridBagConstraints.BOTH;
	gbc_amountPanel.gridx = 0;
	gbc_amountPanel.gridy = 1;
	this.contentPane.add(amountPanel, gbc_amountPanel);

	/*Set the amount field*/
	this.amountField = new JTextField();
	this.amountField.setBorder(null);
	this.amountField.setForeground(Color.LIGHT_GRAY);
	this.amountField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	this.amountField.setText("amount");
	this.amountField.setHorizontalAlignment(SwingConstants.CENTER);
	this.amountPanel.add(this.amountField);
	this.amountField.setColumns(10);

	/*Set the date panel and its constraint*/
	this.datePanel = new JPanel();
	this.datePanel.setBackground(this.mainColor);
	GridBagConstraints gbc_datePanel = new GridBagConstraints();
	gbc_datePanel.insets = new Insets(10, 100, 5, 100);
	gbc_datePanel.fill = GridBagConstraints.BOTH;
	gbc_datePanel.gridx = 0;
	gbc_datePanel.gridy = 2;
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
	drugsPanel = new JScrollPane();
	drugsPanel.setBorder(null);
	GridBagConstraints gbc_drugsPanel = new GridBagConstraints();
	gbc_drugsPanel.insets = new Insets(10, 100, 0, 100);
	gbc_drugsPanel.fill = GridBagConstraints.BOTH;
	gbc_drugsPanel.gridx = 0;
	gbc_drugsPanel.gridy = 3;
	contentPane.add(drugsPanel, gbc_drugsPanel);
	
	/*Set the drug area*/
	this.drugsArea = new JTextArea();
	this.drugsArea.setText("drugs");
	drugsPanel.setViewportView(drugsArea);
	
	/*Set the prescription panel*/
	this.prescriptionPanel = new JPanel();
	this.prescriptionPanel.setBackground(this.mainColor);
	GridBagConstraints gbc_prescriptionPanel = new GridBagConstraints();
	gbc_prescriptionPanel.insets = new Insets(10, 100, 5, 100);
	gbc_prescriptionPanel.fill = GridBagConstraints.BOTH;
	gbc_prescriptionPanel.gridx = 0;
	gbc_prescriptionPanel.gridy = 4;
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
