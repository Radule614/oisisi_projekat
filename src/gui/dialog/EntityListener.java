package gui.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import gui.dialog.Dialog.DialogTab.DialogPanel;

public abstract class EntityListener implements ActionListener
{
	enum ActionType {ADD, EDIT};
	
	protected Dialog dialog;
	protected DialogPanel fieldPanel;
	
	String[] data;
	
	boolean error = false;
	
	public EntityListener(Dialog dialog, DialogPanel fieldPanel)
	{
		super();
		this.dialog = dialog;
		this.fieldPanel = fieldPanel;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		data = this.getData(fieldPanel.fields);
		
		if(data != null)
		{
			this.action();
			if(!this.error) dialog.close();
		}
		this.error = false;
	}
	
	protected String[] getData(ArrayList<?> fields)
	{
		String[] data = new String[fieldPanel.fields.size()];
		
		boolean error = false;
		int r = 0;
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
				data[r] = new String(temp.getText());
			}
			else if(field instanceof JFormattedTextField)
			{
				JFormattedTextField temp = (JFormattedTextField)field;
				if(temp.getText().isEmpty())
				{
					error = true;
					break;
				}
				data[r] = new String(temp.getText());
			}
			else if(field instanceof JComboBox)
			{
				JComboBox<?> temp = (JComboBox<?>)field;
				data[r] = new String(Integer.toString(temp.getSelectedIndex()));
			}
			++r;
		}
		if(error) return null;
		return data;
	}
	
	abstract void action();
}









