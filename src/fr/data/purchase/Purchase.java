package fr.data.purchase;

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
    private int[] medicines = new int[numberOfProducts];
    
    /**The store id of the customer that made the purchase*/
    private int customerId;

    /**
     * Ctor of the class Purchase
     * @param amount The amount of the purchase
     * @param id The id of the purchase
     * @param day The day the purchase was made
     * @param month The month the purchase was made
     * @param year The year the purchase was made
     * @param prescription The tag that tell if there was a prescription
     * @param medicines The ids of the medicines bought
     * @param customerId The customer's store id
     */
    public Purchase(int amount, int id, int day, int month, int year, boolean prescription, int[] medicines, int customerId) {
	this.amount = amount;
	this.id = customerId;
	this.date[0] = day;
	this.date[1] = month;
	this.date[2] = year;
	this.prescription = prescription;
	this.numberOfProducts = medicines.length;
	this.medicines = medicines;
	this.customerId = customerId;
    }

    /**
     * Return the amount of the purchase
     * @return the amount
     */
    public double getAmount() {
        return amount;
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
        return id;
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
        return date;
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
        return prescription;
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
        return numberOfProducts;
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
     * @return int[] the medicines bought
     */
    public int[] getMedicines() {
        return medicines;
    }

    /**
     * Set the medicines bought
     * @param medicines the medicines to set
     */
    public void setMedicines(int[] medicines) {
        this.medicines = medicines;
    }

    /**
     * Return the customer store id
     * @return int the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Set the customer store id
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}