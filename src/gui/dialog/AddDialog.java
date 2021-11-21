package gui.dialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.dialog.Dialog.DialogTab.DialogPanel;
import main.Events;

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
		JPanel panel = Dialog.createRowPanel();
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
		
		AddActionListener addListener = new AddActionListener(dialog, fieldPanel);
		
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
	
	protected class AddActionListener implements ActionListener
	{
		protected Dialog dialog;
		protected DialogPanel fieldPanel;
		
		public AddActionListener(Dialog dialog, DialogPanel fieldPanel)
		{
			super();
			this.dialog = dialog;
			this.fieldPanel = fieldPanel;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			int r = 0;
			boolean error = false;
			String[] arr = new String[fieldPanel.fields.size()];
			
			for(JComponent field: fieldPanel.fields)
			{
				if(field instanceof JTextField)
				{
					JTextField temp = (JTextField)field;
					if(temp.getText().isEmpty())
					{
						error = true;
						break;
					}
					arr[r] = new String(temp.getText());
				}
				else if(field instanceof JFormattedTextField)
				{
					JFormattedTextField temp = (JFormattedTextField)field;
					if(temp.getText().isEmpty())
					{
						error = true;
						break;
					}
					arr[r] = new String(temp.getText());
				}
				else if(field instanceof JComboBox)
				{
					JComboBox<?> temp = (JComboBox<?>)field;
					arr[r] = new String(Integer.toString(temp.getSelectedIndex()));
				}
				++r;
			}

			if(!error)
			{
				switch(entityType)
				{
				case STUDENT:
					Events.createStudent(arr);
					break;
				case PROFESOR:
					Events.createProfesor(arr);
					break;
				case PREDMET:
					Events.createPredmet(arr);
					break;
				}
				
				dialog.close();
			}
		}
		
	}
}











