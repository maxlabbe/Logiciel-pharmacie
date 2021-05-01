package fr.userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.userinterface.leftpart.LeftPanel;
import fr.userinterface.rightpart.RightPanel;

import java.awt.Color;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class TestFrame extends JFrame {
    private Color mainColor;
    private JPanel contentPane;
    private RightPanel rightPanel;
    private LeftPanel leftPanel;

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

	leftPanel = new LeftPanel(this.mainColor, rightPanel);
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
