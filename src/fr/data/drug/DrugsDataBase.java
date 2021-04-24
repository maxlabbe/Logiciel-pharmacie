package fr.data.drug;

import java.util.ArrayList;

import fr.data.ISerializable;
import com.google.gson.Gson;

/**
 * This class is the Drugs data base class. Its purpose is to create a data base to store the drug store's drugs.
 * The user can add or delete a medicine. He can get a medicine from with its id or his name. 
 * There is the possibility to have a list of the drugs of a certain type of medicine or made buy the same laboratory
 * The user can also get all the drugs list
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class DrugsDataBase implements ISerializable {

    /**List of the drugs*/
    private ArrayList<Drug> drugs;
    
    /**
     * Ctor of the drug data base
     */
    public DrugsDataBase() {
	this.drugs = new ArrayList<Drug>();
    }
    
    /**
     * Add a drug to the data base
     * @param drug The drug to add
     */
    public void addDrug(Drug drug) {
	this.drugs.add(drug);
    }

    /**
     * Delete a drug from the data base
     * @param drug The drug to delete
     */
    public void deleteDrug(Drug drug){
	this.drugs.remove(drug);
    }
    
    /**
     * Return a drug depending on its id
     * @param id The drug's id
     * @return Drug The drug to get
     */
    public Drug getDrug(int id) {
	for(int drugIndex = 0; drugIndex < drugs.size(); drugIndex++) {
	    Drug drug = this.drugs.get(drugIndex);
	    if(drug.getId() == id) {
		return drug;
	    }
	}
	
	return null;
    }
    
    /**
     * Return a drug depending on its name
     * @param name The drug's name
     * @return Drug The drug to get
     */
    public Drug getDrug(String name) {
	for(int drugIndex = 0; drugIndex < drugs.size(); drugIndex++) {
	    Drug drug = this.drugs.get(drugIndex);
	    if(drug.getName().equals(name)) {
		return drug;
	    }
	}
	
	return null;
    }
    
    /**
     * Return a list of the drugs that have the target type
     * @param type The target type
     * @return A list of the drugs with the type to get
     */
    public ArrayList<Drug> getDrugsWithType(MedicamentType type){
	ArrayList<Drug> drugsWithType = new ArrayList<Drug>();
	for(int drugIndex = 0; drugIndex < drugs.size(); drugIndex++) {
	    Drug drug = drugs.get(drugIndex);
	    if(drug.getType() == type) {
		drugsWithType.add(drug);
	    }
	}
	
	return drugsWithType;
    }
    
    /**
     * Return a list of the drugs that was made by the same laboratory
     * @param lab The target laboratory
     * @return A list of the drugs from the lab to get
     */
    public ArrayList<Drug> getDrugsFromLab(String lab){
	ArrayList<Drug> drugsFromLab = new ArrayList<Drug>();
	for(int drugIndex = 0; drugIndex < drugs.size(); drugIndex++) {
	    Drug drug = drugs.get(drugIndex);
	    if(drug.getLaboratory().equals(lab)) {
		drugsFromLab.add(drug);
	    }
	}
	
	return drugsFromLab;
    }
    
    /**
     * Check if the quantity of a drug is less or equal than the quantity of this drug in the store's stock
     * @param drug The target drug
     * @return boolean Return true if it is less or equal
     */
    public boolean checkQuantity(Drug drug) {
	if(drug.getQuantity() <= this.getDrug(drug.getId()).getQuantity()) {
	    return true;
	}
	
	return false;
    }

    public String Serialize() {
	return new Gson().toJson(this);
    }

    public void Deserialize(String json) {
	DrugsDataBase database = new Gson().fromJson(json, this.getClass());
	this.drugs = new ArrayList<Drug>(database.drugs);
    }
}