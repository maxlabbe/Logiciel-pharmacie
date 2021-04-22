/**
 * 
 */
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
    int id;
    MedicamentType type;
    String name;
    String laboratory;
    int quantity;
	/**
	 * 
	 */
	public Drug(int id, MedicamentType type, String name, String laboratory, int quantity) {
	    this.id = id;
	    this.type = type;
	    this.name = name;
	    this.laboratory = laboratory;
	    this.quantity = quantity;
	}
}