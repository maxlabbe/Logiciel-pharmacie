package fr.userinterface;

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
	//Customer customer = new Customer("Jean", "Dupont", 25, 06, 1995);
	
	//customers.addCustomer(customer);
	
        System.out.println(customers.getCustomer("Jean", "Dupont", 25, 6, 1995).getLastName());
        
        FileManager.SaveDatabase("customers", customers);
        FileManager.SaveDatabase("drugs", drugs);
        FileManager.SaveDatabase("purchases", purchases);
        Frame frame = new Frame();
        frame.init();
    }

}
