package gui.dialog;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import main.Events;

public class DeleteDialog extends OneTabDialog {
	private static final long serialVersionUID = 4356774835454995373L;
	protected int tableRow;
	public DeleteDialog(JFrame frame, String title, EntityType entityType, int tableRow) 
	{
		super(frame, title, entityType);
		this.tableRow = tableRow;
		this.setMinimumSize(new Dimension(200, 0));
		this.mainTab.createPanel();
		this.mainTab.createPanel();
		this.setDeleteButtons();
		this.addLabel("Da li ste sigurni?");
		this.pack();
	}
	
	private void setDeleteButtons()
	{
		DeleteDialog dialog = this;
		this.setButtons(0, 1, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				switch(entityType)
				{
				case STUDENT:
					Events.deleteStudent(tableRow);
					break;
				case PROFESOR:
					Events.deleteProfesor(tableRow);
					break;
				case PREDMET:
					Events.deletePredmet(tableRow);
					break;
				default:;
				}
				dialog.close();
			}
			
		});
		this.pack();
	}
}

	
	
	
	
	
	
	
