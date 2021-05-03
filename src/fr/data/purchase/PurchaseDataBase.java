package fr.data.purchase;

import java.util.ArrayList;

import fr.data.customer.Customer;
import fr.data.drug.Drug;
import fr.data.drug.DrugsDataBase;
import fr.data.event.Action;
import fr.data.event.DatabaseEvent;
import fr.data.event.DatabaseSearchEvent;
import fr.data.Database;
import fr.data.ISerializable;
import fr.data.Row;

import com.google.gson.Gson;

public class PurchaseDataBase extends Database<Purchase> implements ISerializable {
    
    /**
     * Ctor of the purchase data base
     */
    public PurchaseDataBase() {
	if(instance == null)
	    instance = this;
	this.rows = new ArrayList<Purchase>();
    }

    /**
     * Singleton ref
     */
    private static PurchaseDataBase instance;
    /**
     * Singleton Referece Access
     * @return
     */
    public static PurchaseDataBase Instance() {
	if(instance == null)
	    instance = new PurchaseDataBase();
	return instance;
    }

    /**
     * Add it to the data base
     * @param purchase The purchase to add
     */
    public void addPurchase(Purchase purchase){
	purchase.setId(rows.size());
	DrugsDataBase drugDB = DrugsDataBase.Instance();
	this.rows.add(purchase);
	for(Drug drug : purchase.getMedicines()) {
	    Drug drugRef = drugDB.getDrug(drug.getId());
	    int quantity = drugRef.getQuantity();
	    drugDB.getDrug(drug.getId()).setQuantity(quantity - drug.getQuantity());
	}
	System.out.println("purchase added");
	OnRowAdded(new DatabaseEvent<Purchase>(this, Purchase.class, purchase, Action.ADD));
    }
    
    /**
     * Delete a purchase from the data base
     * @param purchase The purchase to delete
     */
    public void deletePurchase(Purchase purchase) {
	this.rows.remove(purchase);
	OnRowAdded(new DatabaseEvent<Purchase>(this, Purchase.class, purchase, Action.REMOVE));
    }
    
    public Purchase getPurchase(int id) {
	for(int purchaseIndex = 0; purchaseIndex < rows.size(); purchaseIndex++) {
	    Purchase purchase = this.rows.get(purchaseIndex);
	    if(purchase.getId() == id) {
		return purchase;
	    }
	}
	
	return null;
    }
    
    /**
     * Return a list of all the purchases made on a specific date
     * @param day The specific date's day
     * @param month The specific date's month
     * @param year The specific date's year
     * @return ArrayList The list of all the purchases
     */
    public ArrayList<Purchase> getPurchases(int day, int month, int year){
	ArrayList<Purchase> purchasesOnDate = new ArrayList<Purchase>();
	for(int purchaseIndex = 0; purchaseIndex < rows.size(); purchaseIndex++) {
	    Purchase purchase = this.rows.get(purchaseIndex);
	    if(purchase.getDate()[0] == day && purchase.getDate()[1] == month && purchase.getDate()[2] == year) {
		purchasesOnDate.add(purchase);
	    }
	}
	
	return purchasesOnDate;
	
    }
    
    /**
     * Return a list of all the purchases that contain a specific drug
     * @param drug The specific drug
     * @return ArrayList The list with the purchases
     */
    public ArrayList<Purchase> getPurchases(Drug drug) {
	ArrayList<Purchase> purchasesWithDrug = new ArrayList<Purchase>();
	
	for(int purchaseIndex = 0; purchaseIndex < rows.size(); purchaseIndex++) {
	    Purchase purchase = this.rows.get(purchaseIndex);
	    Drug[] drugs = purchase.getMedicines();
	    for (Drug drug2 : drugs) {
		if(drug2 == drug) {
		    purchasesWithDrug.add(purchase);
		}
		break;
	    }
	}
	return purchasesWithDrug;
    }
    
    /**
     * Return a list of all the purchases made by a specific customer
     * @param customer The specific customer
     * @return ArrayList The list with the purchases
     */
    public ArrayList<Purchase> getPurchases(Customer customer) {
	ArrayList<Purchase> purchasesByCustomer = new ArrayList<Purchase>();
	
	for(int purchaseIndex = 0; purchaseIndex < rows.size(); purchaseIndex++) {
	    Purchase purchase = this.rows.get(purchaseIndex);
	    if(purchase.getCustomer() == customer) {
		purchasesByCustomer.add(purchase);
	    }
	}
	
	return purchasesByCustomer;
    }

    public String Serialize() {
	return new Gson().toJson(this);
    }

    public void Deserialize(String json) {
	PurchaseDataBase database = new Gson().fromJson(json, this.getClass());
	this.rows = new ArrayList<Purchase>(database.rows);
    }

    @Override
    public void SearchRows(DatabaseSearchEvent event) {
	//int[] birthDay = Arrays.stream(event.searchData[2].split("/")).mapToInt(Integer::parseInt).toArray();
	ArrayList<Purchase> resultRow = new ArrayList<Purchase>(rows);
	resultRow.removeIf(purchase -> !(("" + purchase.getId()).contains(event.searchData[0])
				&& ("" + purchase.getCustomer().getId()).contains(event.searchData[1])
				/*&& purchase.getDate()[0] == birthDay[0]
				&& purchase.getDate()[1] == birthDay[1]
				&& purchase.getDate()[2] == birthDay[2]*/));
	event.resultRow = new Row[resultRow.size()];
	event.resultRow = resultRow.toArray(event.resultRow);
	OnSearch(event);
    }
}