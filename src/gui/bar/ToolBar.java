package gui.bar;

import javax.swing.*;

import gui.MainWindow;
import gui.manager.DialogManager;
import gui.manager.TableManager;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = -6297787221312734786L;

	ToolBarButton btnNew, btnEdit, btnDelete;
	static ToolBar instance;
	
	private ToolBar()
	{	
		super(SwingConstants.HORIZONTAL);
		this.setLayout(new GridLayout(1, 2));
		JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
        
        btnNew = new ToolBarButton("img/icon_new.png", "New", "Add new user");
        left.add(btnNew);
        
        btnEdit = new ToolBarButton("img/icon_edit.png","Edit", "Edit user");
        left.add(btnEdit);
        
        btnDelete = new ToolBarButton("img/icon_delete.png", "Delete", "Delete user");
        left.add(btnDelete);

        right.add(new ToolBarTextField());        
        right.add(new ToolBarButton("img/icon_search.png","Search", "Search user"));
        
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
			}
		}
	
	}

	class ToolBarTextField extends JTextField
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
