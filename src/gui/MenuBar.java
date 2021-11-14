package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 5187148993070894847L;
	
	String[] fileNames = {"New", "Save", "Open", "Close"};
	String[] editNames = {"Edit", "Delete"};
	String[] helpNames = {"Help", "About"};
	
	MainWindow window;
	
	public MenuBar(MainWindow window)
	{
		super();
		
		this.window = window;
		
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
		submenu.add(new MenuItem("Studenti", 'T', "img/icon_arrow.png"));
		submenu.add(new MenuItem("Profesori", 'P', "img/icon_arrow.png"));
		submenu.add(new MenuItem("Predmeti", 'R', "img/icon_arrow.png"));
		submenu.add(new MenuItem("Katedre", 'K', "img/icon_arrow.png"));
		
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
				if(temp == "New")
				{
					int active = window.getActivePane();
					switch(active)
					{
					case 0:
						window.dialogManager.createAddStudentDialog();
						break;
					case 1:
						window.dialogManager.createAddProfesorDialog();
						break;
					case 2:
						window.dialogManager.createAddPredmetDialog();
						break;
					default:;
					}
				}
			}
		}
	}
}













