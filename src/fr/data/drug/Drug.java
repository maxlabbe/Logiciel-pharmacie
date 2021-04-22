package fr.data.drug;

/**
 * This class is the medicine class. Its purpose is to create, store and modify drugs's data.
 * Each drugs have an id, a name, the name of the laboratory that made it, and the quantity int he store.
 * The user can either change the data, add data or see them. 
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class Drug {

    /**Id of the drug*/
    private int id;

    /** type of medicine*/
    private MedicamentType type;

    /**name of the drug*/
    private String name;

    /**Name of the laboratory that made the drug*/
    private String laboratory;
    
    /**Price of one quantity of the drug (box, pill...)*/
    private double price;

    /**Quantity of the drug in the store's stocks*/
    private int quantity;

    /**
     * Ctor of a Drug object
     * @param id The id of the drug
     * @param type The type of the drug (types are in the enum MedicamentType)
     * @param name The name of the drug
     * @param laboratory The laboratory that made the drug
     * @param price The price of one quantity of the drug
     * @param quantity the quantity of the drug in the drug store's stocks
     */
    public Drug(int id, MedicamentType type, String name, String laboratory, double price, int quantity) {
	this.id = id;
	this.type = type;
	this.name = name;
	this.laboratory = laboratory;
	this.price = price;
	this.quantity = quantity;
    }

    /**
     * Return the drug's id
     * @return int The drug id
     */
    public int getId() {
	return id;
    }

    /**
     * Set the drug's id
     * @param id The id to set
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * Return the enum value of the drug's type
     * @return MedicamentType The drug type
     */
    public MedicamentType getType() {
	return type;
    }

    /**
     * Set the drug's type
     * @param type The type to set
     */
    public void setType(MedicamentType type) {
	this.type = type;
    }

    /**
     * Return the name of the drug
     * @return String 
     */
    public String getName() {
	return name;
    }

    /**
     * Set the name of the drug
     * @param name The name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Return the name of the laboratory
     * @return String The laboratory's name
     */
    public String getLaboratory() {
	return laboratory;
    }

    /**
     * Set the name of the laboratory
     * @param laboratory the laboratory's name to set
     */
    public void setLaboratory(String laboratory) {
	this.laboratory = laboratory;
    }
    
    /**
     * Return the price of one quantity of the medicine
     * @return double the price of one quantity
     */
    public double getPrice() {
	return this.price;
    }

    /**
     * Set the drug's price
     * @param price The price to set
     */
    public void setPrice(double price) {
	this.price = price;
    }

    /**
     * Return the quantity of the drug in the stocks
     * @return int The quantity in stocks
     */
    public int getQuantity() {
	return quantity;
    }

    /**
     * Set the quantity of the drug in the stocks
     * @param quantity The quantity to set
     */
    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }
}