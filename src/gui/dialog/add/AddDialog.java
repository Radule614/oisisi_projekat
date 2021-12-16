package gui.dialog.add;

import controller.Controller;
import gui.dialog.OneTabDialog;
import gui.manager.DialogManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddDialog extends OneTabDialog{
	private static final long serialVersionUID = -4200341794375887919L;
	protected EntityType entityType;
	public AddDialog(String title, EntityType entityType) {
		super(title, entityType);
		this.entityType = entityType;
		this.mainTab.createPanel();
		this.mainTab.createPanel();
		this.setAddButtons();
        this.pack();
	}
	
	void setAddButtons()
	{
		AddDialog dialog = this;
		this.setButtons(0, 1, null, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ArrayList<String> messages = new ArrayList<String>();
				String[] data = mainTab.getData(0);
				boolean error = false;
				if(data != null)
				{
					switch(entityType)
					{
					case STUDENT:
						error = !Controller.student.create(data, messages);
						break;
					case PROFESOR:
						error = !Controller.profesor.create(data, messages);
						break;
					case PREDMET:
						error = !Controller.predmet.create(data, messages);
						break;
					default:;
					}
					if(!error) 	dialog.close();
					else		DialogManager.createInvalidInputDialog(messages);
				}
			}
			
		});
		this.pack();
	}
}











