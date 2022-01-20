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
	MainWindow main = MainWindow.getInstance();
	final String[] fileNames = {main.GetLocalization("menuBarNovi"), main.GetLocalization("menuBarSacuvaj"), main.GetLocalization("menuBarOtvori"), main.GetLocalization("menuBarZatvori")};
	final String[] editNames = {main.GetLocalization("menuBarIzmeni"), main.GetLocalization("menuBarObrisi")};
	final String[] helpNames = {main.GetLocalization("menuBarPomoc"), main.GetLocalization("menuBarOAplikaciji")};
	final String[] languageNames = {main.GetLocalization("menuBarEngleski"),main.GetLocalization("menuBarSrpski")};
	
	JMenu file = new JMenu(main.GetLocalization("menuBarFile"));
	JMenu edit = new JMenu(main.GetLocalization("menuBarIzmeni"));
	JMenu help = new JMenu(main.GetLocalization("menuBarPomoc"));
	JMenu language = new JMenu(main.GetLocalization("lblJezik"));
	JMenu submenu = new JMenu(main.GetLocalization("menuBarOtvori"));
	static MenuBar instance;
	
	private MenuBar()
	{
		super();
		
		
		
		file.setMnemonic('F');
		edit.setMnemonic('E');
		help.setMnemonic('H');
		language.setMnemonic('L');
		
		file.add(new MenuItem(main.GetLocalization("menuBarNovi"), 'N'));
		file.add(new MenuItem(main.GetLocalization("menuBarSacuvaj"), 'S'));
		
		 
		submenu.setMnemonic('O');
		submenu.setPreferredSize(new Dimension(180, 32));
		submenu.setIcon(new ImageIcon("img/icon_open.png"));
		submenu.add(new MenuItem(main.GetLocalization("lblStudenti"), 'T', "img/icon_student.png"));
        submenu.add(new MenuItem(main.GetLocalization("lblProfesori"), 'P', "img/icon_profesor.png"));
        submenu.add(new MenuItem(main.GetLocalization("lblPredmeti"), 'R', "img/icon_predmet.png"));
        submenu.add(new MenuItem(main.GetLocalization("lblKatedre"), 'K', "img/icon_katedra.png"));
		
		file.add(submenu);
		file.addSeparator();
		file.add(new MenuItem(main.GetLocalization("menuBarZatvori"), 'C'));
		
		for(String s: editNames)
		{
			edit.add(new MenuItem(s, s.charAt(0)));
		}
		
		for(String s: helpNames)
		{
			help.add(new MenuItem(s, s.charAt(0)));
		}
		
		for(String s: languageNames)
		{
			language.add(new MenuItem(s));
		}
		
		add(file);
		add(edit);
		add(help);
		add(language);
	}
	
	public void RefreshText()
	{
		file.setText(main.GetLocalization("menuBarFile"));
		file.getItem(0).setText(main.GetLocalization("menuBarNovi"));
		file.getItem(1).setText(main.GetLocalization("menuBarSacuvaj"));
		file.getItem(2).setText(main.GetLocalization("menuBarOtvori"));
		file.getItem(4).setText(main.GetLocalization("menuBarZatvori"));
		
		submenu.getItem(0).setText(main.GetLocalization("lblStudenti"));
		submenu.getItem(1).setText(main.GetLocalization("lblProfesori"));
		submenu.getItem(2).setText(main.GetLocalization("lblPredmeti"));
		submenu.getItem(3).setText(main.GetLocalization("lblKatedre"));
		
		edit.setText(main.GetLocalization("menuBarIzmeni"));
		edit.getItem(0).setText(main.GetLocalization("menuBarIzmeni"));
		edit.getItem(1).setText(main.GetLocalization("menuBarObrisi"));
		
		help.setText(main.GetLocalization("menuBarPomoc"));
		help.getItem(0).setText(main.GetLocalization("menuBarPomoc"));
		help.getItem(1).setText(main.GetLocalization("menuBarOAplikaciji"));
		
		language.setText(main.GetLocalization("lblJezik"));
		language.getItem(0).setText(main.GetLocalization("menuBarEngleski"));
		language.getItem(1).setText(main.GetLocalization("menuBarSrpski"));
		
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
				if(temp == main.GetLocalization("menuBarNovi"))
				{
					DialogManager.createAddDialog(window.getActivePane());
				}
				else if(temp == main.GetLocalization("menuBarIzmeni"))
				{
					int active = window.getActivePane();
					int row = TableManager.getSelectedTableRow(active);
					if(row != -1) DialogManager.createEditDialog(active, row);
				}
				else if(temp == main.GetLocalization("menuBarObrisi"))
				{
					int active = window.getActivePane();
					int row = TableManager.getSelectedTableRow(active);
					if(row != -1) DialogManager.createDeleteDialog(active , row);
				}
				else if(temp == main.GetLocalization("menuBarZatvori"))
				{
					System.exit(0);
				}
				else if(temp == main.GetLocalization("lblStudenti")){
					main.setActivePane(0);
				}
				else if(temp == main.GetLocalization("lblProfesori")){
					main.setActivePane(1);
				}
				else if(temp == main.GetLocalization("lblPredmeti")){
					main.setActivePane(2);
				}
				else if(temp == main.GetLocalization("lblKatedre")){
					//create departments dialog
				}
				else if(temp == main.GetLocalization("menuBarEngleski"))
				{
					main.SetLanguageToEnglish();
				}
				else if(temp == main.GetLocalization("menuBarSrpski"))
				{
					main.SetLanguageToSerbian();
				}
			}
		}
	}
}













