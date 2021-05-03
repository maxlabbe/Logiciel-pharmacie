package fr.data.event;

import java.util.EventListener;

public class DatabaseListener<T> implements EventListener{
    public void OnRowAdded(DatabaseEvent<T> event) {};
    public void OnRowRemove(DatabaseEvent<T> event) {};
    public void OnRowUpdated(DatabaseEvent<T> event) {};
    public void OnDatabaseUpdate(DatabaseEvent<T> event) {};
    public void OnDatabaseSearch(DatabaseSearchEvent event) {};
}
