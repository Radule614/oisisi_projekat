package gui.dialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;

import gui.dialog.Dialog.DialogTab.DialogPanel;
import main.Events;
import utility.Utility;

public class AddDialog extends OneTabDialog{
	private static final long serialVersionUID = -4200341794375887919L;

	public AddDialog(JFrame frame, String title, EntityType entityType) {
		super(frame, title, entityType);
		
		this.mainTab.createPanel();	//prvi panel
		this.mainTab.createPanel();	//drugi panel
		
		this.setButtons();
        this.pack();
	}
	
	protected void setButtons()
	{
		DialogPanel buttonPanel = mainTab.panels.get(1);
		JPanel panel = Dialog.createRowPanel(2);
		buttonPanel.add(panel);
		
		FlowLayout leftPanelLayout = new FlowLayout(FlowLayout.RIGHT);
		leftPanelLayout.setHgap(0);
		FlowLayout rightPanelLayout = new FlowLayout(FlowLayout.LEFT);
		rightPanelLayout.setHgap(0);
		
		JPanel leftPanel = new JPanel(leftPanelLayout);
		JPanel rightPanel = new JPanel(rightPanelLayout);
		
		JButton submit = new JButton("Potvrdi");
		JButton cancel = new JButton("Odustani");
		
		Dialog.setButtonHover(submit, "#95bcf2");
		Dialog.setButtonHover(cancel, "#9b5377");
		
		leftPanel.add(submit);
		rightPanel.add(cancel);
		
		AddDialog dialog = this;
		DialogPanel fieldPanel = mainTab.panels.get(0);
		
		AddEntityListener addListener = new AddEntityListener(dialog, fieldPanel, entityType);
		submit.addActionListener(addListener);
		
		cancel.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dialog.close();
			}
		});
		
		panel.add(leftPanel);
		panel.add(rightPanel);
	}
	
	protected class AddEntityListener extends EntityListener
	{
		protected EntityType entityType;
		
		public AddEntityListener(Dialog dialog, DialogPanel fieldPanel, EntityType entityType) {
			super(dialog, fieldPanel);
			this.entityType = entityType;
		}

		@Override
		void action() {
			Utility.trimEach(this.data);
			ArrayList<String> messages = new ArrayList<String>();
			switch(this.entityType)
			{
			case STUDENT:
				if(this.error = !Events.createStudent(this.data, messages))
				{
					DialogManager.createInvalidInputDialog(messages);
				}
				break;
			case PROFESOR:
				if(this.error = !Events.createProfesor(this.data, messages))
				{
					DialogManager.createInvalidInputDialog(messages);
				}
				break;
			case PREDMET:
				if(this.error = !Events.createPredmet(this.data, messages))
				{
					DialogManager.createInvalidInputDialog(messages);
				}
				break;
			default:;
			}
		}
		
	}
}











