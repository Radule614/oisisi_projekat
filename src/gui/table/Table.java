package gui.table;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import gui.bar.ToolBar;

public class Table extends JTable {
	private static final long serialVersionUID = -2108154469027694188L;
	public TableRowSorter<TableModel> sorter;
	protected DefaultTableModel model;
	
	
	
	public Table(int colNumber)
	{
		super(new DefaultTableModel(0, colNumber));
		init();
	}
	
	public Table(String[] columnLabels)
	{ 
		super(new DefaultTableModel(columnLabels, 0));
		
		sorter = new TableRowSorter<TableModel>(this.getModel());
		this.setRowSorter(sorter);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
	
		init();
	}
	
	
	
	
	private void init()
	{
		this.model = (DefaultTableModel) this.getModel();
		this.setRowHeight(30);
		this.setDefaultRenderer(Object.class, new TableRenderer());
		this.getTableHeader().setReorderingAllowed(false);
		//this.getTableHeader().setResizingAllowed(false);
		this.setDefaultEditor(Object.class, null);
		this.getTableHeader().setFont(new Font("Monaco", Font.PLAIN, 15));
		this.setFont(new Font("Monaco", Font.PLAIN, 15));
		this.setPreferredScrollableViewportSize(this.getPreferredSize());
		this.setFillsViewportHeight(true);
	}
	
	public void addRow(String[] data)
	{
		this.model.addRow(data);
	}
	
	public void insertRow(String[] data, int row)
	{
		this.model.insertRow(row, data);
	}
	
	public void addRows(ArrayList<String[]> dataArray)
	{
		for(String[] data: dataArray)
		{
			this.addRow(data);
		}
	}
	
	public void removeRow(int tableRow)
	{
		if(tableRow != -1) 
		{
			this.model.removeRow(tableRow);
		}
	}
	
	protected class TableRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 8513478726201670798L;
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			this.setBorder(new EmptyBorder(0, 5, 0, 5));
			return this;
		}
	}
	
	public int getSelectedRowFromModel(){
		if(this.getSelectedRow() == -1)
			return -1;
		return this.convertRowIndexToModel(this.getSelectedRow());
	}
}










