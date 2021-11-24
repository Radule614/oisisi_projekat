package gui.dialog;

import javax.swing.JFrame;

public class EditStudentDialog extends MultiTabDialog {
	private static final long serialVersionUID = -268052684667075413L;

	public EditStudentDialog(JFrame frame, String title, EntityType entityType, String[] tabLabels) {
		super(frame, title, entityType, tabLabels);
		
	}

}
