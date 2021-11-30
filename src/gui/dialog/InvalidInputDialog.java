package gui.dialog;

import java.awt.Dimension;
import java.util.ArrayList;

public class InvalidInputDialog extends OneTabDialog {
	private static final long serialVersionUID = -363672527656760257L;

	public InvalidInputDialog(String title, ArrayList<String> messages) 
	{
		super(title, null);
		this.setMinimumSize(new Dimension(200, 0));
		this.mainTab.createPanel();
		this.printMessages(messages);
		this.pack();
	}

	protected void printMessages(ArrayList<String> messages)
	{
		for(String s: messages)
		{
			this.addLabel(s);
		}
		this.pack();
	}
	
}
