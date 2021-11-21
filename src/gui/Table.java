package gui;

import java.awt.Component;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {
	private static final long serialVersionUID = -2108154469027694188L;
	protected DefaultTableModel model;
	
	public Table(String[] columnLabels)
	{
		super(new DefaultTableModel(columnLabels, 0));
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
	
	public void addRow(Object[] data)
	{
		this.model.addRow(data);
		
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
}










