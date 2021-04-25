package fr.userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.userinterface.menu.MenuPanel;

public class TestFrame extends JFrame {

    private JPanel contentPane;
    
    private MenuPanel menu;

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
	researchPanel.add(this.menu);
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
