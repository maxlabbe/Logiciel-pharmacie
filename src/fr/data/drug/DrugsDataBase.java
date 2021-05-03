package fr.data.drug;

import java.util.ArrayList;

import fr.data.Database;
import fr.data.ISerializable;
import fr.data.Row;
import fr.data.customer.Customer;
import fr.data.event.Action;
import fr.data.event.DatabaseEvent;
import fr.data.event.DatabaseSearchEvent;

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
public class DrugsDataBase extends Database<Drug> implements ISerializable {
    /**
     * Ctor of the drug data base
     */
    public DrugsDataBase() {
	if(instance == null)
	    instance = this;
	this.rows = new ArrayList<Drug>();
    }

    /**
     * Singleton ref
     */
    private static DrugsDataBase instance;
    /**
     * Singleton Referece Access
     * @return
     */
    public static DrugsDataBase Instance() {
	if(instance == null)
	    instance = new DrugsDataBase();
	return instance;
    }
    
    /**
     * Add a drug to the data base
     * @param drug The drug to add
     */
    public void addDrug(Drug drug) {
	drug.setId(rows.size());
	this.rows.add(drug);
	OnRowAdded(new DatabaseEvent<Drug>(this, Drug.class, drug, Action.ADD));
    }

    /**
     * Delete a drug from the data base
     * @param drug The drug to delete
     */
    public void deleteDrug(Drug drug){
	this.rows.remove(drug);
	OnRowAdded(new DatabaseEvent<Drug>(this, Drug.class, drug, Action.REMOVE));
    }
    
    /**
     * Return a drug depending on its id
     * @param id The drug's id
     * @return Drug The drug to get
     */
    public Drug getDrug(int id) {
	for(int drugIndex = 0; drugIndex < rows.size(); drugIndex++) {
	    Drug drug = this.rows.get(drugIndex);
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
	for(int drugIndex = 0; drugIndex < rows.size(); drugIndex++) {
	    Drug drug = this.rows.get(drugIndex);
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
	for(int drugIndex = 0; drugIndex < rows.size(); drugIndex++) {
	    Drug drug = rows.get(drugIndex);
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
	for(int drugIndex = 0; drugIndex < rows.size(); drugIndex++) {
	    Drug drug = rows.get(drugIndex);
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
	this.rows = new ArrayList<Drug>(database.rows);
    }

    @Override
    public void SearchRows(DatabaseSearchEvent event) {
	ArrayList<Drug> resultRow = new ArrayList<Drug>(rows);
	resultRow.removeIf(drug -> !(drug.getName().contains(event.searchData[0])
				&& drug.getLaboratory().contains(event.searchData[1])
				&& drug.getType().toString().contains(event.searchData[2])));
	event.resultRow = new Row[resultRow.size()];
	event.resultRow = resultRow.toArray(event.resultRow);
	OnSearch(event);
    }
}