package fr.data.event;

import java.util.EventObject;

import fr.data.Row;

public class DatabaseSearchEvent extends EventObject {
    public String[] searchData;
    public Row[] resultRow;
    public DatabaseSearchEvent(Object source, String[] searchData) {
	super(source);
	this.resultRow = null;
	this.searchData = searchData;
    }
    
}
