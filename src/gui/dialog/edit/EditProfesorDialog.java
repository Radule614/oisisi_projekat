package gui.dialog.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import gui.MainWindow;
import gui.dialog.Dialog;
import gui.dialog.MultiTabDialog;
import gui.manager.DialogManager;
import gui.manager.TableManager;
import gui.table.Table;

public class EditProfesorDialog extends MultiTabDialog {
	private static final long serialVersionUID = -268052684667075413L;
	protected int tableRow;
	JButton submit;
	protected int profesorTableRow;
	protected Table predmetiTable;
	
	protected TablePanel predmetiTablePanel;
	
	public EditProfesorDialog(String title, EntityType entityType, int tableRow, String[] tabLabels) {
		super(title, entityType, tabLabels);
		this.tableRow = tableRow;
		this.tabPanels.get(0).createPanel();
		this.setEditButtons();
		this.tabPanels.get(1).createPanel();
		this.pack();
		profesorTableRow = tableRow;
		this.tabPanels.get(0).createPanel();
		this.tabPanels.get(0).setBorder(new CompoundBorder(this.tabPanels.get(0).getBorder(), new EmptyBorder(0, 75, 0, 75)));
		this.setPredmetiTable();
		this.predmetiTablePanel = new TablePanel(this.predmetiTable);
		this.setPredmetButtons();
		this.tabPanels.get(1).setBorder(new EmptyBorder(25, 40, 25, 40));
		this.tabPanels.get(1).panels.get(0).add(this.predmetiTablePanel);
		this.tabPanels.get(1).createPanel();

	}
	
	
	public void setEditButtons()
	{
		EditActionListener action = new EditActionListener(this, tableRow);
		submit = this.setButtons(0, 1, null, action);
	}
	
	public void setSubmitEnabledEvents()
	{
		this.tabPanels.get(0).panels.get(0).setEmptyDocumentListeners(submit);
	}
	
	
	public void setPredmetiTable()
	{
		ArrayList<String[]> dataArray = Controller.profesor.getPredmeti(profesorTableRow);
		this.predmetiTable = TableManager.createProfesorPredmetiTable(dataArray);	
	}
	
	
	protected void setPredmetButtons()
	{
		JButton btnDodaj 		= new JButton(MainWindow.getInstance().GetLocalization("titleAddPredmet"));
		JButton btnObrisi 		= new JButton(MainWindow.getInstance().GetLocalization("titleRemovePredmet"));
		
		Dialog.setButtonHover(btnDodaj, "#95bcf2");
		Dialog.setButtonHover(btnObrisi, "#9b5377");
		
		this.predmetiTablePanel.addButton(btnDodaj);
		this.predmetiTablePanel.addButton(btnObrisi);
		
		EditProfesorDialog dialog = this;
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogManager.createDodajPredmetProfesoruDialog(dialog);
			}
		});
		
		btnObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int predmetRow = predmetiTable.getSelectedRowFromModel();
				if(predmetRow != -1) 
				{
					DialogManager.createRemovePredmetProfesoruDialog(dialog, predmetRow);
				}
			}
		});
		//DODAJ LISTENERE

	}
	
	public int getProfesorIndex()
	{
		return this.profesorTableRow;
	}
	
	public void updatePredmetiKojePredajeTable()
	{
		this.setPredmetiTable();
		this.predmetiTablePanel.updateTable(this.predmetiTable);
		this.predmetiTablePanel.revalidate();
	}
	
	public Table getPredmetiTable()
	{
		return this.predmetiTable;
	}
}










