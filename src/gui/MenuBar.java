package gui;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = -5511353684955783810L;
	
	public MenuBar()
	{
		super();
		
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		this.add(file);
		this.add(edit);
		this.add(help);
	}
}
