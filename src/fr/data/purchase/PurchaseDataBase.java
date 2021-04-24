package fr.data.purchase;

import java.util.ArrayList;

import fr.data.customer.Customer;
import fr.data.drug.Drug;

import fr.data.ISerializable;
import com.google.gson.Gson;

public class PurchaseDataBase implements ISerializable {
    
    /** List of purchases*/
    private ArrayList<Purchase> purchases;
    
    /**
     * Ctor of the purchase data base
     */
    public PurchaseDataBase() {
    }

    /**
     * Add it to the data base
     * @param purchase The purchase to add
     */
    public void addPurchase(Purchase purchase){
	this.purchases.add(purchase);
    }
    
    /**
     * Delete a purchase from the data base
     * @param purchase The purchase to delete
     */
    public void deletePurchase(Purchase purchase) {
	this.purchases.remove(purchase);
    }
    
    public Purchase getPurchase(int id) {
	for(int purchaseIndex = 0; purchaseIndex < purchases.size(); purchaseIndex++) {
	    Purchase purchase = this.purchases.get(purchaseIndex);
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
	for(int purchaseIndex = 0; purchaseIndex < purchases.size(); purchaseIndex++) {
	    Purchase purchase = this.purchases.get(purchaseIndex);
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
	
	for(int purchaseIndex = 0; purchaseIndex < purchases.size(); purchaseIndex++) {
	    Purchase purchase = this.purchases.get(purchaseIndex);
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
	
	for(int purchaseIndex = 0; purchaseIndex < purchases.size(); purchaseIndex++) {
	    Purchase purchase = this.purchases.get(purchaseIndex);
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
	this.purchases = new ArrayList<Purchase>(database.purchases);
    }
}