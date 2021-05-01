package fr.userinterface.event;

import java.util.EventObject;

public class MenuSelectedEvent extends EventObject{
    public String tableName;
    public String searchPanelName;
    public MenuSelectedEvent(Object source, String tableName, String searchPanelName) {
	super(source);
	this.tableName = tableName;
	this.searchPanelName = searchPanelName;
	// TODO Auto-generated constructor stub
    }
    

}

