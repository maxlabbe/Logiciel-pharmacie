package fr.data.customer;

import java.util.ArrayList;

/**
 * This class is the customer data base class. Its purpose is to create a data base to store the drug store's customers.
 * The user can add or delete a customer. He can also get a customer from the data base with his store id or his full name and his date of birth.
 * The user can also get all the cutomers list
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class CustomerDataBase {

    /** List of the customers*/
    private ArrayList<Customer> customers;
    
    /**
     * Ctor of the customers data base
     */
    public CustomerDataBase() {
	this.customers = new ArrayList<Customer>();
    }
    
    /**
     * Add a customer to the data base
     * @param customer The customer to add
     */
    public void addCustomer(Customer customer) {
	this.customers.add(customer);
    }
    
    /**
     * Delete a customer from the data base
     * @param customer The customer to delete
     */
    public void deleteCustomer(Customer customer) {
	this.customers.remove(customer);
    }
    
    /**
     * Return the customer depending on his store id
     * @param id The customer's store id
     * @return Customer The customer to get
     */
    public Customer getCustomer(int id) {
	for(int customerIndex = 0; customerIndex < customers.size(); customerIndex++) {
	    Customer customer = this.customers.get(customerIndex);
	    if(customer.getId() == id) {
		return customer;
	    }
	}
	
	return null;
    }
    
    /**
     * Return the customer depending on his name, first name and date of birth
     * @param name The customer's name
     * @param firstName The customer's first name
     * @param day The customer's day of birth
     * @param month The customer's month of birth
     * @param year The customer's year of birth
     * @return Customer The customer to get
     */
    public Customer getCustomer(String name, String firstName, int day, int month, int year) {
	for(int customerIndex = 0; customerIndex < customers.size(); customerIndex++) {
	    Customer customer = customers.get(customerIndex);
	    if(customer.getName() == name && customer.getFirstName() == firstName && 
		    customer.getBirthday()[0] == day && customer.getBirthday()[1] == month && customer.getBirthday()[2] == year ) {
		return customer;
	    }
	}
	
	return null;
    }
    
    /**
     * Return the list of all the store's customers
     * @return ArrayList The list of the customers
     */
    public ArrayList<Customer> getAllCustomers(){
	return this.customers;
    }

}