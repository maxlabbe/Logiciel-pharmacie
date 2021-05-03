package fr.userinterface.database;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

import fr.data.Database;
import fr.data.Row;
import fr.data.event.DatabaseEvent;
import fr.data.event.DatabaseListener;
import fr.data.event.DatabaseSearchEvent;

public class Table<T> extends JPanel {
    
    private Database<T> database;
    private Header header;
    private TableRow[] tableRows = new TableRow[0];
    


    private Color mainColor;
    private JPanel rowsPanel;

    public Table(Database<T> database, String[] colHeaders, Color mainColor) {
	this.mainColor = mainColor;
	this.setBackground(this.mainColor);
	GridBagLayout gbl_rightPanel = new GridBagLayout();
	gbl_rightPanel.columnWidths = new int[] {686};
	gbl_rightPanel.rowHeights = new int[] {50, 750, 0};
	gbl_rightPanel.columnWeights = new double[]{1.0};
	gbl_rightPanel.rowWeights = new double[]{1.0, 1.0, 1.0};
	this.setLayout(gbl_rightPanel);

	this.header = new Header(colHeaders);
	this.header.setBackground(this.mainColor);
	GridBagConstraints gbc_HeadPanel = new GridBagConstraints();
	gbc_HeadPanel.insets = new Insets(0, 0, 5, 0);
	gbc_HeadPanel.fill = GridBagConstraints.BOTH;
	gbc_HeadPanel.gridx = 0;
	gbc_HeadPanel.gridy = 0;
	this.add(this.header, gbc_HeadPanel);

	JScrollPane scrollpane = new JScrollPane();
	GridBagConstraints scrollPaneConstraint = new GridBagConstraints();
	scrollPaneConstraint.fill = GridBagConstraints.BOTH;
	scrollPaneConstraint.gridx = 0;
	scrollPaneConstraint.gridy = 1;
	scrollpane.setLayout(new ScrollPaneLayout());
	this.add(scrollpane, scrollPaneConstraint);

	this.rowsPanel = new JPanel();
	rowsPanel.setLayout(new GridLayout(0, 1, 0, 0));
	scrollpane.setViewportView(rowsPanel);

	this.database = database;
	database.AddDatabaseListener(new DatabaseListener<T>() {
	    @Override
	    public void OnDatabaseUpdate(DatabaseEvent<T> event) {
		System.out.println("database update");
		LoadRows();
	    }
	    @Override
	    public void  OnDatabaseSearch(DatabaseSearchEvent event) {
		boolean flag = true;
		int i = 0;
		while(flag && i < event.searchData.length) {
		    if(event.searchData[i] != "") {
			flag = false;
		    }
		    i++;
		}
		if(flag)
		    LoadRows();
		else
		    LoadRows(event.resultRow);
	    }
	});
	
	LoadRows();
    }
    
    private void DeleteRows() {
	for(int i = 0; i < tableRows.length; i++) {
	    rowsPanel.remove(tableRows[i]);
	}
    }
    
    private void LoadRows() {
	ArrayList<Row> rowsValues = (ArrayList<Row>) database.GetRows();
	Row[] rows = new Row[rowsValues.size()];
	LoadRows(rowsValues.toArray(rows));
    }

    private void LoadRows(Row[] rows) {
	DeleteRows();
	tableRows = new TableRow[rows.length];
	for(int i = 0; i < rows.length; i++) {
	    tableRows[i] = new TableRow(rows[i].GetRowValues());
	    rowsPanel.add(tableRows[i]);
	}
	this.rowsPanel.revalidate();
    }
}
