package gui.dialog.add;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.border.EmptyBorder;

import controller.Controller;
import gui.MainWindow;
import gui.dialog.Dialog;
import gui.dialog.OneTabDialog;
import gui.dialog.edit.EditStudentDialog;
import gui.dialog.utility.ConfirmDialog;
import gui.manager.TableManager;
import gui.table.Table;

public class AddIspitDialog extends OneTabDialog {
	private static final long serialVersionUID = 904193011924022021L;
	EditStudentDialog editDialog;
	protected int studentTableRow;
	
	ArrayList<Integer> predmetiDataIndexes;  
	protected Table predmetiTable;
	protected TablePanel predmetiTablePanel;
	
	public AddIspitDialog(EditStudentDialog editDialog) {
		super(MainWindow.getInstance().GetLocalization("titleAddPredmet"), Dialog.EntityType.STUDENT);
		this.editDialog = editDialog;
		this.studentTableRow = editDialog.getStudentIndex();
		this.predmetiDataIndexes = new ArrayList<Integer>();
		this.mainTab.createPanel();
		this.mainTab.createPanel();
		this.setTable();
		this.setButtons();
		this.setMinimumSize(new Dimension(450, 450));
		this.pack();
	}
	
	protected void setTable()
	{
		HashMap<Integer, String> data = Controller.getEligiblePredmeti(this.studentTableRow);
		ArrayList<String[]> tableData = new ArrayList<String[]>();
		for (HashMap.Entry<Integer, String> set : data.entrySet()) 
		{
			String[] temp = new String[1];
			temp[0] = set.getValue();
			tableData.add(temp);
			this.predmetiDataIndexes.add(set.getKey());
		}
		this.predmetiTable = TableManager.createIspitiTable(tableData);
		this.predmetiTablePanel = new TablePanel(this.predmetiTable);
		this.mainTab.panels.get(0).setBorder(new EmptyBorder(20, 20, 20, 20));
		this.mainTab.panels.get(0).add(predmetiTablePanel);
		this.predmetiTablePanel.scrollPane.getColumnHeader().setVisible(false);
	}

	protected void setButtons()
	{
		AddIspitDialog d = this;
		ActionListener listener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				int predmetRow = predmetiTable.getSelectedRowFromModel();
				if(predmetRow != -1) d.addToNepolozeni(predmetRow);
			}
		};
		super.setButtons(0, 1, null, listener);
	}
	
	protected void addToNepolozeni(int predmetRow)
	{
		ConfirmDialog d = new ConfirmDialog(MainWindow.getInstance().GetLocalization("titleAddPredmet"));
		ActionListener listener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.student.addToNepolozeni(studentTableRow, predmetiDataIndexes.get(predmetRow));
				predmetiTable.removeRow(predmetRow);
				editDialog.updateNepolozeniTable();
				predmetiDataIndexes.remove(predmetRow);
				d.close();
			}
		};
		d.setListener(listener);
		d.open();
	}
}










