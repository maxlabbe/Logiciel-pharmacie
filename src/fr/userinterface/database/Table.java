package fr.userinterface.database;

import java.util.ArrayList;

import javax.swing.JPanel;

import fr.data.Database;
import fr.data.Row;
import fr.data.event.DatabaseEvent;
import fr.data.event.DatabaseListener;

public class Table<T> extends JPanel {
    private Database<T> database;
    private Header header;
    private TableRow[] rows = new TableRow[0];
    public Table(Database<T> database, String[] colHeaders) {
	this.database = database;
	header = new Header(colHeaders);
	add(header);

	database.AddDatabaseListener(new DatabaseListener<T>() {
	    @Override
	    public void OnDatabaseUpdate(DatabaseEvent<T> event) {
		LoadRows();
	    }
	});
	LoadRows();
    }
    
    public void LoadRows() {
	for(int i = 0; i < rows.length; i++) {
	    this.remove(rows[i]);
	}
	ArrayList<Row> rowsValues = (ArrayList<Row>) database.GetRows();
	rows = new TableRow[rowsValues.size()];
	for(int i = 0; i < rowsValues.size(); i++) {
	    rows[i] = new TableRow(rowsValues.get(i).GetRowValues());
	    add(rows[i]);
	}
    }
}
