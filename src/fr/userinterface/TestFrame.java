package fr.userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.data.customer.Customer;
import fr.data.customer.CustomerDataBase;
import fr.userinterface.database.Table;
import fr.userinterface.event.MenuSelectedEvent;
import fr.userinterface.event.MenuSelectedListener;
import fr.userinterface.menu.MenuPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JScrollPane;

public class TestFrame extends JFrame {

    private JPanel contentPane;
    
    private MenuPanel menu;
    private JPanel rightPanel;
    private JPanel databasesPanel;
    private JPanel databasesCards;
    private JPanel customersPanel;
    private JPanel tabHeader;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JPanel drugsPanel;
    private JPanel tabHeader_2;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JPanel purchasesPanel;
    private JPanel tabHeader_3;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JLabel lblNewLabel_12;
    private JPanel panel;
    private JPanel row;
    private JLabel lblNewLabel_13;
    private JLabel lblNewLabel_14;
    private JLabel lblNewLabel_15;
    private JLabel lblNewLabel_16;
    private JPanel panel_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TestFrame frame = new TestFrame();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public TestFrame() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1000, 800);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel researchPanel = new JPanel();
	researchPanel.setBounds(0, 0, 300, 800);
	contentPane.add(researchPanel);
	researchPanel.setLayout(null);
	
	this.menu = new MenuPanel();
	menu.AddMenuSelectedListener(new MenuSelectedListener() {
	    @Override
	    public void OnMenuSelected(MenuSelectedEvent e) {
		((CardLayout)databasesCards.getLayout()).show(databasesCards, e.menuName);
	    }
	});
	
	researchPanel.add(this.menu);
	
	rightPanel = new JPanel();
	rightPanel.setBounds(298, 0, 686, 761);
	contentPane.add(rightPanel);
	rightPanel.setLayout(new BorderLayout(5, 5));
	
	databasesPanel = new JPanel();
	databasesPanel.setBackground(Color.ORANGE);
	rightPanel.add(databasesPanel, BorderLayout.NORTH);
	databasesPanel.setBounds(rightPanel.getBounds().x, rightPanel.getBounds().y, rightPanel.getWidth(), rightPanel.getHeight());
	databasesPanel.setSize(rightPanel.getWidth(), rightPanel.getHeight());
	databasesPanel.setLayout(new BorderLayout(0, 0));
	
	databasesCards = new JPanel();
	databasesPanel.add(databasesCards, BorderLayout.NORTH);
	databasesCards.setLayout(new CardLayout(0, 0));
	
	String[] customersPanelHeader = {"Nom", "Pr\\u00E9nom", "Date de naissance", "Actions"};
	customersPanel = new Table<Customer>(CustomerDataBase.Instance(), customersPanelHeader);
	customersPanel.setName("customersPanel");
	databasesCards.add(customersPanel, "customersPanel");
	customersPanel.setLayout(new BorderLayout(0, 0));
	
	drugsPanel = new JPanel();
	databasesCards.add(drugsPanel, "drugsPanel");
	drugsPanel.setLayout(new BorderLayout(0, 0));
	
	tabHeader_2 = new JPanel();
	drugsPanel.add(tabHeader_2, BorderLayout.NORTH);
	tabHeader_2.setLayout(new GridLayout(0, 5, 0, 0));
	
	lblNewLabel_4 = new JLabel("Nom");
	tabHeader_2.add(lblNewLabel_4);
	
	lblNewLabel_5 = new JLabel("Quantit\u00E9");
	tabHeader_2.add(lblNewLabel_5);
	
	lblNewLabel_6 = new JLabel("Laboratoire");
	tabHeader_2.add(lblNewLabel_6);
	
	lblNewLabel_7 = new JLabel("Type");
	tabHeader_2.add(lblNewLabel_7);
	
	lblNewLabel_8 = new JLabel("Actions");
	tabHeader_2.add(lblNewLabel_8);
	
	purchasesPanel = new JPanel();
	databasesCards.add(purchasesPanel, "purchasesPanel");
	purchasesPanel.setLayout(new BorderLayout(0, 0));

	tabHeader_3 = new JPanel();
	purchasesPanel.add(tabHeader_3);
	tabHeader_3.setLayout(new GridLayout(0, 4, 0, 0));
	
	lblNewLabel_9 = new JLabel("Num\u00E9ro de commande");
	tabHeader_3.add(lblNewLabel_9);
	
	lblNewLabel_10 = new JLabel("Date");
	tabHeader_3.add(lblNewLabel_10);
	
	lblNewLabel_11 = new JLabel("Prescription");
	tabHeader_3.add(lblNewLabel_11);
	
	lblNewLabel_12 = new JLabel("Actions");
	tabHeader_3.add(lblNewLabel_12);
    }
    
    public void init() {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TestFrame frame = new TestFrame();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }
}
