package gui.dialog;

import javax.swing.JFrame;

public class OneTabDialog extends Dialog{
	private static final long serialVersionUID = -1532191688826690608L;

	protected DialogTab mainTab;
	
	public OneTabDialog(JFrame frame, String title, EntityType entityType)
	{
		super(frame, title, entityType);
		
		mainTab = new DialogTab(this);
		tabPanels.add(mainTab);
		this.add(mainTab);
	}
	
	public void addTextField(String labelText)
	{
		this.mainTab.panels.get(0).addTextField(labelText);
	}
	
	public void addDateField(String labelText)
	{
		this.mainTab.panels.get(0).addDateField(labelText);
	}
	
	public void addComboBox(String labelText, String[] arr)
	{
		this.mainTab.panels.get(0).addComboBox(labelText, arr);
	}
}
