package gui.dialog.add;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import gui.dialog.OneTabDialog;
import gui.dialog.edit.EditStudentDialog;
import gui.manager.DialogManager;

public class AddOcenaDialog extends OneTabDialog {
	private static final long serialVersionUID = -5215125962181860018L;
	EditStudentDialog editDialog;
	protected int studentTableRow;
	protected int predmetTableRow;
	public AddOcenaDialog(EditStudentDialog editDialog, int predmetIndex) {
		super("Unos ocene", editDialog.entityType);
		this.editDialog = editDialog;
		this.studentTableRow = editDialog.getStudentIndex();
		this.predmetTableRow = predmetIndex;
		this.mainTab.createPanel();
		this.mainTab.createPanel();
		this.setFields();
		this.setButtons();
		this.pack();
	}

	protected void setFields()
	{
		ArrayList<String[]> data = Controller.student.getNepolozeniIspiti(studentTableRow);
		String[] ocenaData = data.get(predmetTableRow);
		this.mainTab.panels.get(0).textFieldLength = 12;
		
		this.addTextField("Šifra", ocenaData[0], false);
		this.addTextField("Naziv", ocenaData[1], false);
		this.addComboBox("Ocena", new String[] {"6", "7", "8", "9", "10"});
		this.addDateField("Datum");
	}
	
	protected void setButtons()
	{
		AddOcenaDialog dialog = this;
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> messages = new ArrayList<String>();
				String[] data = dialog.mainTab.getData(0);
				boolean error;
				if(data != null)
				{
					error = !Controller.student.addToPolozeni(studentTableRow, predmetTableRow, data, messages);
					if(!error) 	
					{
						editDialog.updateNepolozeniTable();
						editDialog.updatePolozeniTable();
						editDialog.setPolozeniLabels();
						dialog.close();
					}
					else 
					{
						DialogManager.createInvalidInputDialog(messages);
					}
				}
			}
		};
		JPanel panel = this.mainTab.panels.get(1);
		panel.setBorder(new CompoundBorder(panel.getBorder(), new EmptyBorder(10, 0, 0, 0)));
		super.setButtons(0, 1, null, listener);
	}
}

















