package gui.dialog;

import javax.swing.JFrame;

public class EditStudentDialog extends MultiTabDialog {
	private static final long serialVersionUID = -268052684667075413L;
	protected int tableRow;
	public EditStudentDialog(JFrame frame, String title, EntityType entityType, int tableRow, String[] tabLabels) {
		super(frame, title, entityType, tabLabels);
		this.tableRow = tableRow;
		this.tabPanels.get(0).createPanel();
		this.setEditButtons();
		this.pack();
	}
	
	public void setEditButtons()
	{
		EditActionListener action = new EditActionListener(this, tableRow);
		this.setButtons(0, 1, action);
	}
}












