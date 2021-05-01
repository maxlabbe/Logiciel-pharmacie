package fr.userinterface.event;

import java.util.EventObject;

public class MenuSelectedEvent extends EventObject{
    public String mainPanelName;
    public String searchPanelName;
    public MenuSelectedEvent(Object source, String mainPanelName, String searchPanelName) {
	super(source);
	this.mainPanelName = mainPanelName;
	this.searchPanelName = searchPanelName;
	// TODO Auto-generated constructor stub
    }
    

}

