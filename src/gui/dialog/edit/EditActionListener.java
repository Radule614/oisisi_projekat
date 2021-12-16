package gui.dialog.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.Controller;
import gui.dialog.Dialog;
import gui.manager.DialogManager;

public class EditActionListener implements ActionListener {
	Dialog dialog;
	int tableRow;
	public EditActionListener(Dialog dialog, int tableRow)
	{
		this.dialog = dialog;
		this.tableRow = tableRow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<String> messages = new ArrayList<String>();
		String[] data = dialog.tabPanels.get(0).getData(0);
		boolean error = false;
		if(data != null)
		{
			switch(dialog.entityType)
			{
			case STUDENT:
				error = !Controller.student.edit(data, tableRow, messages);
				break;
			case PROFESOR:
				error = !Controller.profesor.edit(data, tableRow, messages);
				break;
			case PREDMET:
				error = !Controller.predmet.edit(data, tableRow, messages);
				break;
			default:;
			}
			
			if(error) 	DialogManager.createInvalidInputDialog(messages);
			else		dialog.close();
		}
	}

}
