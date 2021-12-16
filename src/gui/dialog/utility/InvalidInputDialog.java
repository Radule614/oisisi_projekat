package gui.dialog.utility;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.dialog.Dialog;
import gui.dialog.OneTabDialog;

public class InvalidInputDialog extends OneTabDialog {
	private static final long serialVersionUID = -363672527656760257L;

	public InvalidInputDialog(String title, ArrayList<String> messages) 
	{
		super(title, null);
		this.setMinimumSize(new Dimension(200, 0));
		this.mainTab.createPanel();
		this.mainTab.createPanel();
		this.printMessages(messages);
		this.addCloseButton();
		this.pack();
	}

	protected void printMessages(ArrayList<String> messages)
	{
		this.mainTab.panels.get(0).setBorder(new EmptyBorder(3, 5, 3, 5));
		for(String s: messages)
		{
			this.addLabel(s);
		}
		this.pack();
	}
	
	protected void addCloseButton()
    {
        DialogTab.DialogPanel parentPanel = this.mainTab.panels.get(1);
        JPanel panel = Dialog.createRowPanel(1);
        panel.setLayout(new FlowLayout());
        panel.setBorder(new EmptyBorder(15, 0, 0, 0));

        JButton btn = new JButton("OK");
        btn.addActionListener(e -> this.close());

        panel.add(btn);
        parentPanel.add(panel);
    }
}
