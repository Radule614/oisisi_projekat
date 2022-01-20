package gui.dialog.edit;

import javax.swing.JButton;

import gui.dialog.OneTabDialog;

public class EditPredmetDialog extends OneTabDialog{
	private static final long serialVersionUID = -268052684667075413L;
	protected int tableRow;
	JButton submit;
	
	protected TablePanel editPredmetPanel;
	
	public EditPredmetDialog(String title, int tableRow, EntityType entityType) {
		super(title, entityType);
		this.tableRow = tableRow;
		this.mainTab.createPanel();	//prvi panel
		this.mainTab.createPanel();	//drugi panel
		
		
		
		
		
		this.setEditButtons();
		this.pack();
	}
	
	public void setEditButtons()
	{
		EditActionListener action = new EditActionListener(this, tableRow);
		submit = this.setButtons(0, 1, null, action);
	}
	
	public void setSubmitEnabledEvents()
	{
		this.tabPanels.get(0).panels.get(0).setEmptyDocumentListeners(submit);
	}
}












