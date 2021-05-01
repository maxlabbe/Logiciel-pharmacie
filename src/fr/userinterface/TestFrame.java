package fr.userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.data.customer.Customer;
import fr.data.customer.CustomerDataBase;
import fr.userinterface.database.Table;
import fr.userinterface.leftpart.LeftPanel;
import fr.userinterface.rightpart.RightPanel;

import java.awt.Color;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.JTable;

public class TestFrame extends JFrame {
    private Color mainColor;
    private JPanel contentPane;
    private JPanel databasesCards;
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
    private RightPanel rightPanel;
    private JPanel panel_1;
    private JPanel dataBasePanel;
    private JPanel contentCard;
    private JScrollPane customerPanel;
    private JScrollPane drugPanel;
    private JScrollPane purchasePanel;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TestFrame frame = new TestFrame(Color.decode("#096A09"));
		    //69C3FF
		    //B0F2B6
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
    public TestFrame(Color mainColor) {
	this.mainColor = mainColor;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1000, 800);
	contentPane = new JPanel();
	contentPane.setBorder(null);
	setContentPane(contentPane);

	GridBagLayout gbl_contentPane = new GridBagLayout();
	gbl_contentPane.columnWidths = new int[] {300, 686};
	gbl_contentPane.rowHeights = new int[] {800};
	gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
	gbl_contentPane.rowWeights = new double[]{1.0};
	contentPane.setLayout(gbl_contentPane);
	
	rightPanel = new RightPanel(this.mainColor);
	GridBagConstraints gbc_rightPanel = new GridBagConstraints();
	gbc_rightPanel.fill = GridBagConstraints.BOTH;
	gbc_rightPanel.gridx = 1;
	gbc_rightPanel.gridy = 0;
	contentPane.add(rightPanel, gbc_rightPanel);

	JPanel leftPanel = new LeftPanel(this.mainColor, rightPanel);
	GridBagConstraints gbc_leftPanel = new GridBagConstraints();
	gbc_leftPanel.fill = GridBagConstraints.BOTH;
	gbc_leftPanel.gridx = 0;
	gbc_leftPanel.gridy = 0;
	contentPane.add(leftPanel, gbc_leftPanel);
	
	
    }

    public void init() {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TestFrame frame = new TestFrame(Color.decode("#69C3FF"));
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }
}
