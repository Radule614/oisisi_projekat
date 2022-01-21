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
import gui.dialog.Dialog.TablePanel;
import gui.dialog.edit.EditPredmetDialog;
import gui.dialog.edit.EditProfesorDialog;
import gui.dialog.utility.ConfirmDialog;
import gui.manager.TableManager;
import gui.table.Table;

public class AddProfesorPredmetuDialog extends OneTabDialog{
	

	private static final long serialVersionUID = 1L;
	public static AddProfesorPredmetuDialog instance;
	EditPredmetDialog editDialog;
	protected int predmetTableRow;
	
	ArrayList<Integer> profesoriDataIndexes;  
	protected Table profesoriTable;
	protected TablePanel profesoriTablePanel;
	
	
	public AddProfesorPredmetuDialog(EditPredmetDialog editDialog) {
		super(MainWindow.getInstance().GetLocalization("titleAddProfesor"), Dialog.EntityType.PROFESOR);
		this.editDialog = editDialog;
		this.predmetTableRow = editDialog.getPredmetIndex();
		this.profesoriDataIndexes = new ArrayList<Integer>();
		this.mainTab.createPanel();
		this.mainTab.createPanel();
		this.setTable();
		this.setButtons();
		this.setMinimumSize(new Dimension(450, 450));
		this.pack();
		instance = this;
	}
	
	protected void setTable()
	{
		HashMap<Integer, String> data = Controller.getEligibleProfesoriForPredmet();
		ArrayList<String[]> tableData = new ArrayList<String[]>();
		for (HashMap.Entry<Integer, String> set : data.entrySet()) 
		{
			String[] temp = new String[1];
			temp[0] = set.getValue();
			tableData.add(temp);
			this.profesoriDataIndexes.add(set.getKey());
		}
		this.profesoriTable = TableManager.createIspitiTable(tableData);
		this.profesoriTablePanel = new TablePanel(this.profesoriTable);
		this.mainTab.panels.get(0).setBorder(new EmptyBorder(20, 20, 20, 20));
		this.mainTab.panels.get(0).add(profesoriTablePanel);
		this.profesoriTablePanel.scrollPane.getColumnHeader().setVisible(false);
	}

	protected void setButtons()
	{
		AddProfesorPredmetuDialog d = this;
		ActionListener listener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				int profesorRow = profesoriTable.getSelectedRowFromModel();
				System.out.println("ONO " + profesorRow);
				if(profesorRow != -1) 
				{
					d.addToPredaje(profesorRow);
				}
				
			}
		};
		super.setButtons(0, 1, null, listener);
	}
	
	
	
	protected void addToPredaje(int profesorRow)
	{
		ConfirmDialog d = new ConfirmDialog(MainWindow.getInstance().GetLocalization("titleAddProfesor"));
		ActionListener listener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.predmet.addProfesorToPredmet(profesoriDataIndexes.get(profesorRow), predmetTableRow);
				profesoriTable.removeRow(profesorRow);
				editDialog.close();
				profesoriDataIndexes.remove(profesorRow);
				d.close();
				instance.close();
			}
		};
		
		d.setListener(listener);
		d.open();
		
		
	}

}
