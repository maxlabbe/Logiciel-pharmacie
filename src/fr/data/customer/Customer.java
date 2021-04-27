package fr.data.customer;

import java.util.ArrayList;

import fr.data.Row;

/**
 * This class is the customer class. Its purpose is to create, store and modify the customers's data.
 * Each customer have a name, first name, birthday, insurance, number of insurance and a list of its allergies.
 * The user can either change the data, add data or see them. 
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class Customer extends Row{
    /**id the id number of the customer */
    private int id;

    /**firstName the first name of the customer */
    private String firstName;

    /**lastName the last name of the customer */
    private String lastName;

    /**birthday an integer array representing the date of birth
     * the first index is the day
     * the second for the month
     * the last one for the year
     */
    private int birthday[] = new int[3];

    /**insuanceRAMQ tell if the customer has insurance */
    private boolean insuranceRAMQ;

    /**numberRAMQ the RAMQ number of the customer */
    private int numberRAMQ;

    /**allergies list of the possible allergies that the customer can have */
    private ArrayList<String> allergies;

    /**
     * Ctor if the customer have insurance
     * 
     * @param id The customer id
     * @param name The customer name
     * @param firstName The customer first name
     * @param birthDay The customer day of birth
     * @param birthMonth The customer month of birth
     * @param birthYear The customer year of birth
     * @param numberRAMQ The customer insurance number
     */
    public Customer(String firstName, String lastName, int birthDay, int birthMonth, int birthYear, int numberRAMQ) {
	this.id = -1;
	this.firstName = firstName;
	this.lastName = lastName;
	this.birthday[0] = birthDay;
	this.birthday[1] = birthMonth;
	this.birthday[2] = birthYear;
	this.insuranceRAMQ = true;
	this.numberRAMQ = numberRAMQ;
    }

    /**
     * Ctor if the customer doesn't have insurance
     * 
     * @param id The customer id
     * @param name The customer name
     * @param firstName The customer first name
     * @param birthDay The customer day of birth
     * @param birthMonth The customer month of birth
     * @param birthYear The customer year of birth
     */
    public Customer(String firstName, String lastName, int birthDay, int birthMonth, int birthYear) {
	this.id = -1;
	this.firstName = firstName;
	this.lastName = lastName;
	this.birthday[0] = birthDay;
	this.birthday[1] = birthMonth;
	this.birthday[2] = birthYear;
	this.insuranceRAMQ = false;
	this.numberRAMQ = -1;
    }

    /**
     * Return the store id of the customer
     * @return int The customer's store id
     */
    public int getId() { 
	return this.id;
    }

    /**
     * Set the new value of id
     * @param id The id to set
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * Return the customer's name 
     * @return String The customer's name
     */
    public String getLastName() { 
	return this.lastName;
    }

    /**
     * Set the new value of name
     * @param name The name to set
     */
    public void setLastName(String name) {
	this.lastName = name;
    }

    /**
     * Return the first name of the customer
     * @return String The costumer's first name
     */
    public String getFirstName() { 
	return this.firstName;
    }

    /**
     * Set the customer's first name
     * @param firstName The first name to set
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /**
     * Return the date of birth of the customer
     * @return int[] The customer's date of birth
     */
    public int[] getBirthday() { 
	return this.birthday;
    }

    /**
     * Set the cusstomer's date of birth
     * @param day The value of the day in the date to set
     * @param month The value of the month in the date to set
     * @param year The value of the year in the date to set
     */
    public void setBirthday(int day, int month, int year) {
	this.birthday[0] = day;
	this.birthday[1] = month;
	this.birthday[2] = year;
    }

    /**
     * Return the tag of the insurance that tell if the costumer has one
     * @return boolean The insurance's tag
     */
    public boolean getInsuranceTage() { 
	return this.insuranceRAMQ;
    }

    /**
     * Set the tag of the insurance. Set the tag at false if it's true and at true if it's false
     */
    public void setInusranceTag() {
	if(this.insuranceRAMQ) {
	    this.insuranceRAMQ = false;
	} else {
	    this.insuranceRAMQ = true;
	}
    }

    /**
     * Return the insurance number of the customer
     * @return int The customer's insurance number
     */
    public int getInsuranceNumber() { 
	return this.numberRAMQ;
    }

    /**
     * Set the customer's insurance number
     * @param insuranceNumber The insurance number to set
     */
    public void setInsuranceNumber(int insuranceNumber) {
	this.numberRAMQ = insuranceNumber;
    }

    /**
     * Tell if the customer has a particular allergy
     * @param allergy The target allergy 
     * @return boolean Return true if the customer has it
     */
    public boolean getAllergie(String allergy){
	return this.allergies.contains(allergy);
    }

    /**
     * Return an array with all the customer allergies
     * @return ArrayList The list of the customer's allergies
     */
    public ArrayList<String> getAllergies(){
	return this.allergies;
    }

    /**
     * Add an allergy to the list of allergies of the customer
     * @param allergy The allergy to add
     */
    public void addAllergy(String allergy) {
	if(this.allergies.contains(allergy)) {
	    this.allergies.add(allergy);
	}
    }

    /**
     * Delete an allergy from the customer list of allergies
     * @param allergy The allergy to delete
     */
    public void deleteAllergy(String allergy) {
	if(this.allergies.contains(allergy)) {
	    this.allergies.remove(allergy);
	}
    }

    @Override
    public String[] GetRowValues() {
	String[] values = new String[3];
	values[0] = this.getLastName();
	values[1] = this.getFirstName();
	int[] date = this.getBirthday();
	values[2] = date[0] + "/" + date[1] + "/" + date[2];
	return values;
    }
}