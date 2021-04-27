package fr.userinterface;

import java.awt.Color;

import fr.data.*;
import fr.data.customer.*;
import fr.data.drug.*;
import fr.data.event.DatabaseEvent;
import fr.data.event.DatabaseListener;
import fr.data.purchase.*;

public class Application {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

	// Load Databases
	CustomerDataBase customers = FileManager.LoadDatabase("customers", CustomerDataBase.class);
	customers.AddDatabaseListener(new DatabaseListener<Customer>() {

	    @Override
	    public void OnRowAdded(DatabaseEvent<Customer> event) {
		// TODO Auto-generated method stub
		System.out.println(CustomerDataBase.Instance().getAllCustomers().size());
	    }
	    
	});
	
	DrugsDataBase drugs = FileManager.LoadDatabase("drugs", DrugsDataBase.class);
	PurchaseDataBase purchases = FileManager.LoadDatabase("purchases", PurchaseDataBase.class);
	
	// Add One Customer
	Customer customer = new Customer("Jean", "Dupont", 25, 06, 1995);
	customers.addCustomer(customer);
        
	
	
        // Save Databases
        FileManager.SaveDatabase("customers", customers);
        FileManager.SaveDatabase("drugs", drugs);
        FileManager.SaveDatabase("purchases", purchases);
        TestFrame frame = new TestFrame(Color.decode("#69C3FF"));
        frame.init();
    }

}
