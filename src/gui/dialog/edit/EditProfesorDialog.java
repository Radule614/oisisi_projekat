package gui.dialog.edit;

import gui.dialog.MultiTabDialog;

public class EditProfesorDialog extends MultiTabDialog {
	private static final long serialVersionUID = -268052684667075413L;
	protected int tableRow;
	public EditProfesorDialog(String title, EntityType entityType, int tableRow, String[] tabLabels) {
		super(title, entityType, tabLabels);
		this.tableRow = tableRow;
		this.tabPanels.get(0).createPanel();
		this.setEditButtons();
		this.pack();
	}
	
	public void setEditButtons()
	{
		EditActionListener action = new EditActionListener(this, tableRow);
		this.setButtons(0, 1, null, action);
	}
}










