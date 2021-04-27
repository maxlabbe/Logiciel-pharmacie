package fr.userinterface.event;

import java.util.EventObject;

public class MenuSelectedEvent extends EventObject{
    public String menuName;
    public MenuSelectedEvent(Object source, String menuName) {
	super(source);
	this.menuName = menuName;
	// TODO Auto-generated constructor stub
    }

}
