package gui.dialog;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import main.Events;

public class AddDialog extends OneTabDialog{
	private static final long serialVersionUID = -4200341794375887919L;
	protected EntityType entityType;
	public AddDialog(JFrame frame, String title, EntityType entityType) {
		super(frame, title, entityType);
		this.entityType = entityType;
		this.mainTab.createPanel();	//prvi panel
		this.mainTab.createPanel();	//drugi panel
		this.setAddButtons();
        this.pack();
	}
	
	void setAddButtons()
	{
		AddDialog dialog = this;
		this.setButtons(0, 1, new ActionListener()
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
						error = !Events.createStudent(data, messages);
						break;
					case PROFESOR:
						error = !Events.createProfesor(data, messages);
						break;
					case PREDMET:
						error = !Events.createPredmet(data, messages);
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











