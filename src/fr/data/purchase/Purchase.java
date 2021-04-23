package fr.data.purchase;

import fr.data.customer.Customer;
import fr.data.drug.Drug;

/**
 * Purchase class. This class is use when a purchase is made by a customer. It has the amount of the purchase, an id, a date,
 * a tag that say if there was a prescription, the  number of product bought and the list of them and the customer store id.
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class Purchase {   
    
    /**The amount of the purchase*/
    private double amount;
    
    /**The id of the purchase*/
    private int id;
    
    /**The date of the purchase*/
    private int[] date = new int[3];
    
    /**Tag that tell if the purchase was made with a prescription*/
    private boolean prescription;
    
    /**The number of product bought*/
    private int numberOfProducts;
    
    /**The id of the drugs bought*/
    private Drug[] drugs = new Drug[numberOfProducts];
    
    /**The store id of the customer that made the purchase*/
    private Customer customer;

    /**
     * Ctor of the class Purchase
     * @param amount The amount of the purchase
     * @param id The id of the purchase
     * @param day The day the purchase was made
     * @param month The month the purchase was made
     * @param year The year the purchase was made
     * @param prescription The tag that tell if there was a prescription
     * @param drugs The drugs bought
     * @param customerId The customer's store id
     */
    public Purchase(int amount, int id, int day, int month, int year, boolean prescription, Drug[] drugs, Customer customer) {
	this.amount = amount;
	this.id = id;
	this.date[0] = day;
	this.date[1] = month;
	this.date[2] = year;
	this.prescription = prescription;
	this.numberOfProducts = drugs.length;
	this.drugs = drugs;
	this.customer = customer;
    }

    /**
     * Return the amount of the purchase
     * @return the amount
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Set the amount of the purchase
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Return the id of the purchase
     * @return int the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set the id of the purchase
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return the date of the purchase
     * @return int[3] the date
     */
    public int[] getDate() {
        return this.date;
    }

    /**
     * Set the date of the purchase
     * @param day The day of the date
     * @param month The month of the date
     * @param year The year of the date
     */
    public void setDate(int day, int month, int year) {
        this.date[0] = day;
        this.date[1] = month;
        this.date[2] = year;
    }

    /**
     * Return The tag that tell if there was a prescription
     * @return boolean the prescription's tag value
     */
    public boolean isPrescription() {
        return this.prescription;
    }

    /**
     * Set the prescription's tag
     * @param prescription the prescription's tag to set
     */
    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }

    /**
     * Return the number of product in the purchase
     * @return int the numberOfProducts
     */
    public int getNumberOfProducts() {
        return this.numberOfProducts;
    }

    /**
     * Set he number of product in the purchase
     * @param numberOfProducts the numberOfProducts to set
     */
    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    /**
     * Return the medicines bought
     * @return Drug[] the medicines bought
     */
    public Drug[] getMedicines() {
        return this.drugs;
    }

    /**
     * Set the medicines bought
     * @param medicines the medicines to set
     */
    public void setMedicines(Drug[] medicines) {
        this.drugs = medicines;
    }

    /**
     * Return the customer
     * @return Customer the customer
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Set the customer
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}