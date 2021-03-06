package gui.dialog.utility;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import gui.MainWindow;
import gui.dialog.OneTabDialog;

public class ConfirmDialog extends OneTabDialog {
	private static final long serialVersionUID = 4484919395472986840L;
	
	public ConfirmDialog()
	{
		super("", null);
		this.init();
		this.pack();
	}
	
	public ConfirmDialog(String title) {
		super(title, null);
		this.init();
		this.pack();
	}
	
	public ConfirmDialog(String title, ActionListener actionListener) {
		super(title, null);
		this.init();
		this.setListener(actionListener);
		this.pack();
	}
	
	private void init()
	{
		this.setMinimumSize(new Dimension(200, 0));
		this.mainTab.createPanel();
		this.mainTab.createPanel();
		this.addLabel(MainWindow.getInstance().GetLocalization("titleDaLiSteSigurni"));
	}
	
	public void setListener(ActionListener actionListener)
	{
		this.setButtons(0, 1, new String[] {MainWindow.getInstance().GetLocalization("titleDa"), MainWindow.getInstance().GetLocalization("titleNe")}, actionListener);
		this.pack();
	}
	
	public void setTitle(String title)
	{
		super.setTitle(title);
	}
	
}




