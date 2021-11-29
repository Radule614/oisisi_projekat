package gui.dialog;

import javax.swing.JFrame;

public class EditPredmetDialog extends OneTabDialog{
	private static final long serialVersionUID = -268052684667075413L;
	protected int tableRow;
	public EditPredmetDialog(JFrame frame, String title, int tableRow, EntityType entityType) {
		super(frame, title, entityType);
		this.tableRow = tableRow;
		this.mainTab.createPanel();	//prvi panel
		this.mainTab.createPanel();	//drugi panel
		this.setEditButtons();
		this.pack();
	}
	
	public void setEditButtons()
	{
		EditActionListener action = new EditActionListener(this, tableRow);
		this.setButtons(0, 1, action);
	}
}












