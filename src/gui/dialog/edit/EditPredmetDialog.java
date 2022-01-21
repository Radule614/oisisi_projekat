package gui.dialog.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import controller.Controller;
import gui.MainWindow;
import gui.dialog.Dialog;
import gui.dialog.OneTabDialog;
import gui.dialog.Dialog.TablePanel;
import gui.manager.DialogManager;
import gui.table.Table;
import model.Profesor;

public class EditPredmetDialog extends OneTabDialog{
	private static final long serialVersionUID = -268052684667075413L;
	protected int tableRow;
	JButton submit;
	JButton plus 		= new JButton("+");
	JButton minus 		= new JButton("-");
	JTextField profesorText = new JTextField(16);
	
	protected Table predmetiTable;
	protected TablePanel editPredmetPanel;
	
	public EditPredmetDialog(String title, int tableRow, EntityType entityType) {
		super(title, entityType);
		this.tableRow = tableRow;
		this.mainTab.createPanel();	//prvi panel
		this.mainTab.createPanel();	//drugi panel
		
		
		EditPredmetDialog d = this;
		//plus.setEnabled(false);
		plus.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				DialogManager.createDodajProfesoraNaPredmetDialog(d);
				minus.setEnabled(true);
				plus.setEnabled(false);
				updateTextField();
			}
		});
		
		//minus.setEnabled(false);
		minus.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Controller.removeProfesorFromPredmet(tableRow);
				plus.setEnabled(true);
				minus.setEnabled(false);
				updateTextField();
			}
		});
		
		profesorText.setEnabled(false);
		
		updateTextField();
		
		this.setEditButtons();
		this.pack();
	}
	
	public void updateTextField()
	{
		Profesor p = Controller.getProfesorFromPredmet(tableRow);
		if(p != null)
		{
			profesorText.setText(p.getIme() + " " + p.getPrezime()); 
			minus.setEnabled(true);
			plus.setEnabled(false);
		}
		else
		{
			profesorText.setText(""); 
			minus.setEnabled(false);
			plus.setEnabled(true);
		}
	}
	
	public void setEditButtons()
	{
		EditActionListener action = new EditActionListener(this, tableRow);
		submit = this.setButtons(0, 1, null, action, this.plus, this.minus, this.profesorText);
	}
	
	public void setSubmitEnabledEvents()
	{
		this.tabPanels.get(0).panels.get(0).setEmptyDocumentListeners(submit);
	}
	
	public int getPredmetIndex()
	{
		return this.tableRow;
	}
	
	protected void setProfesorButtons()
	{
		
		
		Dialog.setButtonHover(plus, "#95bcf2");
		Dialog.setButtonHover(minus, "#9b5377");
		
		this.editPredmetPanel.addButton(plus);
		this.editPredmetPanel.addButton(minus);
		
		EditPredmetDialog dialog = this;
		plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogManager.createDodajPredmetProfesoruDialog(null);
			}
		});
		
		//DODAJ LISTENERE
	}
}












