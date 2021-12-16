package gui.bar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.*;

import gui.MainWindow;
import gui.manager.DialogManager;
import gui.manager.TableManager;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 5187148993070894847L;
	
	final String[] fileNames = {"New", "Save", "Open", "Close"};
	final String[] editNames = {"Edit", "Delete"};
	final String[] helpNames = {"Help", "About"};
	
	static MenuBar instance;
	
	private MenuBar()
	{
		super();
		
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		file.setMnemonic('F');
		edit.setMnemonic('E');
		help.setMnemonic('H');
		
		file.add(new MenuItem("New", 'N'));
		file.add(new MenuItem("Save", 'S'));
		
		JMenu submenu = new JMenu("Open");
		submenu.setMnemonic('O');
		submenu.setPreferredSize(new Dimension(180, 32));
		submenu.setIcon(new ImageIcon("img/icon_open.png"));
		submenu.add(new MenuItem("Studenti", 'T', "img/icon_student.png"));
        submenu.add(new MenuItem("Profesori", 'P', "img/icon_profesor.png"));
        submenu.add(new MenuItem("Predmeti", 'R', "img/icon_predmet.png"));
        submenu.add(new MenuItem("Katedra", 'K', "img/icon_katedra.png"));
		
		file.add(submenu);
		file.addSeparator();
		file.add(new MenuItem("Close", 'C'));
		
		for(String s: editNames)
		{
			edit.add(new MenuItem(s, s.charAt(0)));
		}
		
		for(String s: helpNames)
		{
			help.add(new MenuItem(s, s.charAt(0)));
		}
		
		add(file);
		add(edit);
		add(help);
	}
	
	public static MenuBar getInstance()
	{
		if(MenuBar.instance == null) MenuBar.instance = new MenuBar();
		return MenuBar.instance;
	}
	
	class MenuItem extends JMenuItem
	{
		private static final long serialVersionUID = 5161695778852331256L;
		public MenuItem(String name)
		{
			super(name, new ImageIcon("img/icon_" + name.toLowerCase() + ".png"));
			this.setPreferredSize(new Dimension(180, 32));
			this.setMnemonic(name.charAt(0));
			this.addActionListener(new MenuItemListener());
		}
		public MenuItem(String name, char shortcut)
		{
			super(name, new ImageIcon("img/icon_" + name.toLowerCase() + ".png"));
			this.setAccelerator(KeyStroke.getKeyStroke(shortcut, InputEvent.CTRL_DOWN_MASK));
			this.setPreferredSize(new Dimension(180, 32));
			this.setMnemonic(shortcut);
			this.addActionListener(new MenuItemListener());
		}
		public MenuItem(String name, char shortcut, String path)
		{
			super(name, new ImageIcon(path));
			this.setAccelerator(KeyStroke.getKeyStroke(shortcut, InputEvent.CTRL_DOWN_MASK));
			this.setPreferredSize(new Dimension(180, 32));
			this.setMnemonic(shortcut);
			this.addActionListener(new MenuItemListener());
		}
		
		public class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent ae)
			{
				MenuItem btn = (MenuItem)ae.getSource();
				String temp = btn.getText();
				MainWindow window = MainWindow.getInstance();
				if(temp == "New")
				{
					DialogManager.createAddDialog(window.getActivePane());
				}
				else if(temp == "Edit")
				{
					int active = window.getActivePane();
					int row = TableManager.getSelectedTableRow(active);
					if(row != -1) DialogManager.createEditDialog(active, row);
				}
				else if(temp == "Delete")
				{
					int active = window.getActivePane();
					int row = TableManager.getSelectedTableRow(active);
					if(row != -1) DialogManager.createDeleteDialog(active , row);
				}
				else if(temp == "Close")
				{
					System.exit(0);
				}
			}
		}
	}
}













