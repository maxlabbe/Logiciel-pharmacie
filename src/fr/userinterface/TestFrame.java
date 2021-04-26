package fr.userinterface;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import fr.userinterface.menu.MenuPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class TestFrame extends JFrame {

    private JPanel contentPane;
    
    private MenuPanel menu;
    private JTextField txtNom;
    private JTextField txtPrnom;
    private JTextField txtJjmmaaa;

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
	contentPane.setBounds(getBounds(this.getBounds()));
	contentPane.setBorder(null);
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel leftPanel = new JPanel();
	leftPanel.setBounds(0, 0, 300, 800);
	contentPane.add(leftPanel);
	leftPanel.setLayout(null);
	
	JPanel separator = new JPanel();
	separator.setBackground(Color.WHITE);
	separator.setBounds(25, 300, 250, 1);
	leftPanel.add(separator);
	
	this.menu = new MenuPanel();
	menu.setBounds(0, 0, 300, 300);
	leftPanel.add(menu);
	
	JPanel searchPanel = new JPanel();
	searchPanel.setBounds(0, 300, 300, 500);
	leftPanel.add(searchPanel);
	searchPanel.setBorder(null);
	searchPanel.setBackground(Color.decode("#69C3FF"));
	searchPanel.setLayout(null);
	
	JLabel titleLabel = new JLabel("Recherche");
	titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	titleLabel.setForeground(Color.WHITE);
	titleLabel.setFont(new Font("Javanese Text", Font.BOLD, 45));
	titleLabel.setBackground(new Color(175, 238, 238));
	titleLabel.setBounds(0, 10, 300, 60);
	searchPanel.add(titleLabel);
	
	txtNom = new JTextField();
	txtNom.setText("Nom");
	txtNom.setHorizontalAlignment(SwingConstants.CENTER);
	txtNom.setFont(new Font("Segoe UI", Font.PLAIN, 25));
	txtNom.setToolTipText("Nom");
	txtNom.setForeground(Color.LIGHT_GRAY);
	txtNom.setBounds(50, 100, 200, 30);
	txtNom.setBorder(null);
	searchPanel.add(txtNom);
	txtNom.setColumns(10);
	
	txtPrnom = new JTextField();
	txtPrnom.setToolTipText("Nom");
	txtPrnom.setText("Pr\u00E9nom");
	txtPrnom.setHorizontalAlignment(SwingConstants.CENTER);
	txtPrnom.setForeground(Color.LIGHT_GRAY);
	txtPrnom.setFont(new Font("Segoe UI", Font.PLAIN, 25));
	txtPrnom.setColumns(10);
	txtPrnom.setBounds(50, 175, 200, 30);
	txtPrnom.setBorder(null);
	searchPanel.add(txtPrnom);
	
	txtJjmmaaa = new JTextField();
	txtJjmmaaa.setToolTipText("Nom");
	txtJjmmaaa.setText("jj/mm/aaa");
	txtJjmmaaa.setHorizontalAlignment(SwingConstants.CENTER);
	txtJjmmaaa.setForeground(Color.LIGHT_GRAY);
	txtJjmmaaa.setFont(new Font("Segoe UI", Font.PLAIN, 25));
	txtJjmmaaa.setColumns(10);
	txtJjmmaaa.setBounds(50, 250, 200, 30);
	txtJjmmaaa.setBorder(null);
	searchPanel.add(txtJjmmaaa);
	
	JPanel searchButton = new JPanel();
	searchButton.setBackground(Color.decode("#69C3FF"));
	searchButton.setBorder(new LineBorder(new Color(255, 255, 255)));
	searchButton.setBounds(75, 325, 150, 50);
	searchPanel.add(searchButton);
	searchButton.setLayout(null);
	
	JLabel searchLabel = new JLabel("Rechercher");
	searchLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	searchLabel.setBounds(0, 0, 150, 50);
	searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
	searchButton.add(searchLabel);
	
	JPanel searchButton_1 = new JPanel();
	searchButton_1.setLayout(null);
	searchButton_1.setBorder(null);
	searchButton_1.setBackground(Color.decode("#69B3FF"));
	searchButton_1.setBounds(0, 397, 300, 100);
	searchPanel.add(searchButton_1);
	
	JLabel searchLabel_1 = new JLabel("Nouveau");
	searchLabel_1.setBounds(0, 0, 300, 100);
	searchButton_1.add(searchLabel_1);
	searchLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	searchLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
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
