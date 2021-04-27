package fr.data.event;

import java.util.EventObject;

public class DatabaseEvent<T> extends EventObject {
    public Class<T> type;
    public T row;
    public Action action;
    public DatabaseEvent(Object source, Class<T> type, T row, Action action) {
	super(source);
	this.type = type;
	this.row = row;
	this.action = action;
    }

}
