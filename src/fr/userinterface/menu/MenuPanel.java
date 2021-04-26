package fr.userinterface.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.EventListenerList;

import fr.userinterface.event.MenuSelectedEvent;
import fr.userinterface.event.MenuSelectedListener;

public class MenuPanel extends JPanel{
    private MenuButton clientButton;
    private MenuButton drugButton;
    private MenuButton purchaseButton;
    
    private EventListenerList listeners = new EventListenerList();

    public MenuPanel() {
	this.setBackground(Color.decode("#69C3FF"));
	this.setBounds(0, 0, 300, 300);
	this.setLayout(null);
	
	JPanel titlePanel = new JPanel();
	titlePanel.setBackground(Color.decode("#69C3FF"));
	titlePanel.setBounds(0, 0, 300, 50);
	this.add(titlePanel);
	titlePanel.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Menu");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Javanese Text", Font.BOLD, 45));
	lblNewLabel.setBackground(new Color(175, 238, 238));
	lblNewLabel.setBounds(0, 0, 300, 60);
	titlePanel.add(lblNewLabel);
	
	this.clientButton = new MenuButton("Client", new int[] {0, 60, 300, 75});
	this.add(this.clientButton);
	clientButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
		    clientMousePressed(e);
		}
	});
	
	
	this.drugButton = new MenuButton ("Médicament", new int[] {0, 135, 300, 75});
	this.add(drugButton);
	drugButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
		    drugMousePressed(e);
		}
	});
	
	this.purchaseButton = new MenuButton ("Achat", new int[] {0, 210, 300, 75});
	this.add(purchaseButton);
	purchaseButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
		    purchaseMousePressed(e);
		}
	});
    }
    
    private void clientMousePressed(java.awt.event.MouseEvent event) {
	clientButton.activateButton();
	drugButton.deactivateButton();
	purchaseButton.deactivateButton();
	OnMenuSelectedEvent(new MenuSelectedEvent(this, "customersPanel"));
    }
    
    private void drugMousePressed(java.awt.event.MouseEvent event) {
	clientButton.deactivateButton();
	drugButton.activateButton();
	purchaseButton.deactivateButton();
	OnMenuSelectedEvent(new MenuSelectedEvent(this, "drugsPanel"));
    }
    
    private void purchaseMousePressed(java.awt.event.MouseEvent event) {
	clientButton.deactivateButton();
	drugButton.deactivateButton();
	purchaseButton.activateButton();
	OnMenuSelectedEvent(new MenuSelectedEvent(this, "purchasesPanel"));
    }
    
    public void OnMenuSelectedEvent(MenuSelectedEvent e){
	Object[] listeners = this.listeners.getListenerList();
	for(int i = 0; i < listeners.length; i+=2) {
	    if(listeners[i] == MenuSelectedListener.class) {
		((MenuSelectedListener)listeners[i+1]).OnMenuSelected(e);
	    }
	}
    }
    
    public void AddMenuSelectedListener(MenuSelectedListener listener) {
	listeners.add(MenuSelectedListener.class, listener);
    }
    public void RemoveMenuSelectedListener(MenuSelectedListener listener) {
	listeners.remove(MenuSelectedListener.class, listener);
    }
}
