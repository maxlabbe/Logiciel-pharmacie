package fr.data.customer;

import java.util.ArrayList;

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
public class Customer {
	/**id the id number of the customer */
	private int id;
	
	/**name the name of the customer */
	private String name;
	
	/**firstName the first name of the customer */
	private String firstName;
	
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
	public Customer(int id, String name, String firstName, int birthDay, int birthMonth, int birthYear, int numberRAMQ) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
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
	public Customer(int id, String name, String firstName, int birthDay, int birthMonth, int birthYear) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.birthday[0] = birthDay;
		this.birthday[1] = birthMonth;
		this.birthday[2] = birthYear;
		this.insuranceRAMQ = false;
		this.numberRAMQ = -1;
	}

	/**
	 * id getter
	 * @return int Return the id's value of the object
	 */
	public int getId() { 
		return this.id;
	}
	
	/**
	 * id setter 
	 * @param id The new value of id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * name getter
	 * @return String Return the name's value of the object 
	 */
	public String getName() { 
		return this.name;
	}
	
	/**
	 * name setter 
	 * @param name The new value of name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * firstName getter
	 * @return String Return the first name's value of the object
	 */
	public String getFirstName() { 
		return this.firstName;
	}
	
	/**
	 * firstName setter 
	 * @param firstName The new value of firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * birthday getter
	 * @return int[] Return the birthday array of the object
	 */
	public int[] getBirthday() { 
		return this.birthday;
	}
	
	/**
	 * birthday setter
	 * @param day The new value of the day in the date
	 * @param month The new value of the month in the date
	 * @param year The new value of the year in the date
	 */
	public void setBirthday(int day, int month, int year) {
		this.birthday[0] = day;
		this.birthday[1] = month;
		this.birthday[2] = year;
	}
	
	/**
	 * insuranceRAMQ getter
	 * @return boolean Return the insuranceRAMQ's value of the object
	 */
	public boolean getInsuranceTage() { 
		return this.insuranceRAMQ;
	}
	
	/**
	 * insuranceRAMQ setter
	 * set the tag at false if it's true and at true if it's false
	 */
	public void setInusranceTag() {
		if(this.insuranceRAMQ) {
			this.insuranceRAMQ = false;
		} else {
			this.insuranceRAMQ = true;
		}
	}
	
	/**
	 * insuranceNumber getter
	 * @return int Return the insuranceNumber's value of the object
	 */
	public int getInsuranceNumber() { 
		return this.numberRAMQ;
	}
	
	/**
	 * numberRAMQ setter 
	 * @param insuranceNumber The new value of numberRAMQ
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
	 * allergies getter
	 * @return ArrayList Return an array with all the customer allergies
	 */
	public ArrayList<String> getAllergies(){
		return this.allergies;
	}
	
	/**
	 * Add an allergy to the list of allergies of the customer
	 * @param allergy The alergy to add
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
}