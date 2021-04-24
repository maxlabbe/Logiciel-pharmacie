/**
 * 
 */
package fr.userinterface;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;

/**
 * @author Max
 *
 */
public class Frame extends JFrame{	
    private Panel panel;
    private JSplitPane splitPane;
    private JSplitPane splitPaneLeft;

    /**
     * Constructor of the class Frame
     */
    public Frame() 
    {
	super();
	this.panel = new Panel();
	this.splitPane = new JSplitPane();
	this.splitPane.setDividerSize(10);
	BasicSplitPaneDivider divider = (BasicSplitPaneDivider) splitPane.getComponent(2);
	divider.setBackground(Color.black);
	divider.setBorder(null);
	this.splitPaneLeft = new JSplitPane();
	this.splitPaneLeft.setDividerSize(1);
    }

    /**
     * Initializer of any object of the class Frame. It will connect the data of the world and the panel to the frame
     * and set the frame.
     * @param world The world to connect to the frame
     */
    public void init()
    {
	this.setTitle("pharmacie");
	this.setSize(1000,800);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.setSize(this.getSize());
	this.panel.setLayout(new GridLayout());
	this.panel.setBackground(Color.cyan);
	this.panel.add(this.splitPane);
	
	JPanel leftTopPanel = new JPanel();
	leftTopPanel.setBackground(Color.green);
	
	JPanel leftBottomPanel = new JPanel();
	leftBottomPanel.setBackground(Color.black);
	
	splitPaneLeft.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
        splitPaneLeft.setDividerLocation(275);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPaneLeft.setTopComponent(leftTopPanel);                  // at the top we want our "topPanel"
        splitPaneLeft.setBottomComponent(leftBottomPanel);
	
	Panel mainPanel = new Panel();
	mainPanel.setBackground(Color.gray);
	
	splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  // we want it to split the window verticaly
        splitPane.setDividerLocation(300);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setLeftComponent(splitPaneLeft);                  // at the top we want our "topPanel"
        splitPane.setRightComponent(mainPanel);
	
	this.setContentPane(this.panel);
	this.setVisible(true);
    }

    /**
     * return the field panel of the class Frame
     * @return the panel of the frame
     */
    public Panel getPanel()
    {
	return panel;
    }

}
