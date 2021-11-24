package gui.dialog;

import javax.swing.JFrame;

public class EditPredmetDialog extends OneTabDialog{
	private static final long serialVersionUID = -268052684667075413L;

	public EditPredmetDialog(JFrame frame, String title, EntityType entityType) {
		super(frame, title, entityType);
		
		this.mainTab.createPanel();	//prvi panel
		this.mainTab.createPanel();	//drugi panel
	}
}
