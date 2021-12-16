package gui.dialog;

public class OneTabDialog extends Dialog{
	private static final long serialVersionUID = -1532191688826690608L;

	protected DialogTab mainTab;
	
	public OneTabDialog(String title, EntityType entityType)
	{
		super(title, entityType);
		
		mainTab = new DialogTab(this);
		tabPanels.add(mainTab);
		this.add(mainTab);
	}
	
	public void addLabel(String labelText)
	{
		this.mainTab.panels.get(0).addLabel(labelText);
	}
	public void addTextField(String labelText)
	{
		this.mainTab.panels.get(0).addTextField(labelText);
	}
	public void addTextField(String labelText, String value)
	{
		this.mainTab.panels.get(0).addTextField(labelText, value);
	}
	public void addTextField(String labelText, String value, boolean editable)
	{
		this.mainTab.panels.get(0).addTextField(labelText, value, editable);
	}
	public void addDateField(String labelText)
	{
		this.mainTab.panels.get(0).addDateField(labelText);
	}
	public void addDateField(String labelText, String value)
	{
		this.mainTab.panels.get(0).addDateField(labelText, value);
	}
	public void addDateField(String labelText, String value, boolean editable)
	{
		this.mainTab.panels.get(0).addDateField(labelText, value, editable);
	}
	public void addComboBox(String labelText, String[] arr)
	{
		this.mainTab.panels.get(0).addComboBox(labelText, arr);
	}
	public void addComboBox(String labelText, String[] arr, int optionIndex)
	{
		this.mainTab.panels.get(0).addComboBox(labelText, arr, optionIndex);
	}
	public void addComboBox(String labelText, String[] arr, int optionIndex, boolean editable)
	{
		this.mainTab.panels.get(0).addComboBox(labelText, arr, optionIndex, editable);
	}
}










