package fr.userinterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.data.*;
import fr.data.customer.*;
import fr.data.drug.*;
import fr.data.purchase.*;

public class Application {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

	// Load Databases
	CustomerDataBase customers = FileManager.LoadDatabase("customers", CustomerDataBase.class);
	
	DrugsDataBase drugs = FileManager.LoadDatabase("drugs", DrugsDataBase.class);
	
	PurchaseDataBase purchases = FileManager.LoadDatabase("purchases", PurchaseDataBase.class);
	
	// Add One Customer
	Customer customer = new Customer("Jean", "Dupont", 25, 06, 1995);
	customers.addCustomer(customer);
        //TestFrame frame = new TestFrame(Color.decode("#69C3FF"));
        //frame.init();

	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    //69C3FF
		    //B0F2B6
		    //096A09
		    TestFrame frame = new TestFrame(Color.decode("#69C3FF"));
		    frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			    /*
			    System.out.println("confirm exit");
			    if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to close this window?",
				    "Close Window?", JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

			    }
			    */
			    // Save Databases
			    System.out.println("Application Terminated - save databases before closing");
			    FileManager.SaveDatabase("customers", CustomerDataBase.Instance());
			    FileManager.SaveDatabase("drugs", DrugsDataBase.Instance());
			    FileManager.SaveDatabase("purchases", PurchaseDataBase.Instance());
			    System.exit(0);
			}
		    });
		    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

}
