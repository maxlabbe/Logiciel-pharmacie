package fr.data;

import java.util.ArrayList;

import javax.swing.event.EventListenerList;

import fr.data.event.DatabaseEvent;
import fr.data.event.DatabaseListener;
import fr.userinterface.event.MenuSelectedEvent;
import fr.userinterface.event.MenuSelectedListener;

public class Database<T> {
    protected ArrayList<T> rows;
    private EventListenerList listeners = new EventListenerList();
    
    protected void  OnRowAdded(DatabaseEvent<T> event){
	Object[] listeners = this.listeners.getListenerList();
	for(int i = 0; i < listeners.length; i+=2) {
	    if(listeners[i] == DatabaseListener.class) {
		((DatabaseListener<T>)listeners[i+1]).OnRowAdded(event);
		((DatabaseListener<T>)listeners[i+1]).OnDatabaseUpdate(event);
	    }
	}
    }
    
    protected void OnRowRemoved(DatabaseEvent<T> event){
	Object[] listeners = this.listeners.getListenerList();
	for(int i = 0; i < listeners.length; i+=2) {
	    if(listeners[i] == DatabaseListener.class) {
		((DatabaseListener<T>)listeners[i+1]).OnRowAdded(event);
		((DatabaseListener<T>)listeners[i+1]).OnDatabaseUpdate(event);
	    }
	}
    }
    
    public void AddDatabaseListener(DatabaseListener<T> listener) {
	listeners.add(DatabaseListener.class, listener);
    }
    public void removeDatabaseListener(DatabaseListener<T> listener) {
	listeners.remove(DatabaseListener.class, listener);
    }
    
    public ArrayList<T> GetRows(){
	return rows;
    }
}
