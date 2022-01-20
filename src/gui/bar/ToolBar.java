package gui.bar;

import javax.swing.*;

import app.Main;
import gui.MainWindow;
import gui.manager.DialogManager;
import gui.manager.TableManager;
import gui.table.MyRowFilter;
import gui.table.Table;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = -6297787221312734786L;

	ToolBarButton btnNew, btnEdit, btnDelete, btnSearch;
	public ToolBarTextField searchTextField;
	static ToolBar instance;
	
	private ToolBar()
	{	
		super(SwingConstants.HORIZONTAL);
		this.setLayout(new GridLayout(1, 2));
		JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
        
        btnNew = new ToolBarButton("img/icon_new.png", "New", MainWindow.getInstance().GetLocalization("btnDodaj"));
        left.add(btnNew);
        
        btnEdit = new ToolBarButton("img/icon_edit.png","Edit", MainWindow.getInstance().GetLocalization("menuBarIzmeni"));
        left.add(btnEdit);
        
        btnDelete = new ToolBarButton("img/icon_delete.png", "Delete", MainWindow.getInstance().GetLocalization("menuBarObrisi"));
        left.add(btnDelete);
        
        searchTextField = new ToolBarTextField();
        right.add(searchTextField);        
        
        btnSearch = new ToolBarButton("img/icon_search.png","Search", MainWindow.getInstance().GetLocalization("menuBarPretrazi"));
        right.add(btnSearch);
        
		this.add(left);
		this.add(right);
		this.setFloatable(false);

	}
	
	
	public static ToolBar getInstance()
	{
		if(ToolBar.instance == null) 
		{
			ToolBar.instance = new ToolBar();
		}
		
		
		return ToolBar.instance;
	}
	
	class ToolBarButton extends JButton
	{
		private static final long serialVersionUID = -747644966302195350L;
		
		private String buttonType;
		
		public ToolBarButton(String path, String buttonType, String ToolTip)
		{
			super(new ImageIcon(path));
			this.buttonType = buttonType;
			this.setPreferredSize(new Dimension(32, 32));	
			this.setToolTipText(ToolTip);
			this.addActionListener(new ToolBarButtonListener());				
		}	
		
		
		public class ToolBarButtonListener implements ActionListener 
		{
			public void actionPerformed(ActionEvent ae)
			{
				ToolBarButton btn = (ToolBarButton)ae.getSource();
				String temp = btn.buttonType;
				MainWindow window = MainWindow.getInstance();
				if(temp == "New")
				{
					DialogManager.createAddDialog(window.getActivePane());
				}
				else if(temp == "Edit")
				{
					int active = window.getActivePane();
					int row = TableManager.getSelectedTableRow(active);
					if(row != -1) 
					{
						DialogManager.createEditDialog(active, row);
					}
				}
				else if(temp == "Delete")
				{
					int active = window.getActivePane();
					int row = TableManager.getSelectedTableRow(active);
					if(row != -1) 
					{
						DialogManager.createDeleteDialog(active , row);
					}
				}
				else if(temp == "Close")
				{
					System.exit(0);
				}
				else if(temp == "Search")
				{
					String search = ToolBar.getInstance().searchTextField.getText();

				    if(StatusBar.getInstance().stsBarLabel.getText() == MainWindow.getInstance().GetResourceBundle().getObject("stsBarStudent").toString())
				    {
				    	TableManager.studentiTable.sorter.setRowFilter(new MyRowFilter(search, 0));
				    }
				    else if(StatusBar.getInstance().stsBarLabel.getText() == MainWindow.getInstance().GetResourceBundle().getObject("stsBarProfesor").toString())
				    {
				    	TableManager.profesoriTable.sorter.setRowFilter(new MyRowFilter(search, 1));
				    }
				    else if(StatusBar.getInstance().stsBarLabel.getText() == MainWindow.getInstance().GetResourceBundle().getObject("stsBarPredmet").toString())
				    {
				    	TableManager.predmetiTable.sorter.setRowFilter(new MyRowFilter(search, 2));
				    }
				}
			}
		}
	
	}

	public class ToolBarTextField extends JTextField
	{

		private static final long serialVersionUID = -9107600755725276369L;

		public ToolBarTextField()
		{
			super();
			this.setFocusAccelerator('f');
			this.setPreferredSize(new Dimension(150, 25));
		}
	}
	
	
	
	
	
}
