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

public class Table<T> extends JPanel {
    
    private Database<T> database;
    private Header header;
    private TableRow[] rows = new TableRow[0];
    


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
		LoadRows();
	    }
	});
	LoadRows();
    }
    
    public void LoadRows() {
	for(int i = 0; i < rows.length; i++) {
	    rowsPanel.remove(rows[i]);
	}
	ArrayList<Row> rowsValues = (ArrayList<Row>) database.GetRows();
	rows = new TableRow[rowsValues.size()];
	for(int i = 0; i < rowsValues.size(); i++) {
	    rows[i] = new TableRow(rowsValues.get(i).GetRowValues());
	    rowsPanel.add(rows[i]);

	    rowsPanel.add(new TableRow(rowsValues.get(i).GetRowValues()));
	}
    }
}
