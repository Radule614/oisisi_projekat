package gui;

import javax.swing.*;

import gui.dialog.DialogManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = -6297787221312734786L;
	public MainWindow windowGlobal;
	
	public ToolBar(MainWindow window )
	{	
		super(SwingConstants.HORIZONTAL);
		windowGlobal = window;
		this.setLayout(new GridLayout(1, 2));
		JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
        left.add(new toolBarButton("img/icon_new.png", 0, "Add new user"));
        left.add(new toolBarButton("img/icon_edit.png", 1, "Edit user"));
        left.add(new toolBarButton("img/icon_delete.png", 2, "Delete user"));

        right.add(new toolBarTextField());        
        right.add(new toolBarButton("img/icon_search.png", 3, "Search user"));
        
		this.add(left);
		this.add(right);
		this.setFloatable(false);
	}
	
	
	class toolBarButton extends JButton
	{
		private static final long serialVersionUID = -747644966302195350L;
		
		public toolBarButton(String path, int buttonType, String ToolTip)
		{
			super(new ImageIcon(path));
			this.setPreferredSize(new Dimension(32, 32));
			
			this.setToolTipText(ToolTip);
			
			if(buttonType == 2)
			{
				
			}
			
			this.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					if(windowGlobal.getActivePane() == 0 && buttonType == 0) 
					{
						DialogManager.createAddStudentDialog();
					}
					else if (windowGlobal.getActivePane() == 1 && buttonType == 0)
					{
						DialogManager.createAddProfesorDialog();
					}
					else if(windowGlobal.getActivePane() == 2 && buttonType == 0)
					{
						DialogManager.createAddPredmetDialog();
					}
					
				} 
			});
		}
		

		
	}

	class toolBarTextField extends JTextField
	{

		private static final long serialVersionUID = -9107600755725276369L;

		public toolBarTextField()
		{
			super();
			this.setFocusAccelerator('f');
			this.setPreferredSize(new Dimension(150, 25));
		}
	}
	
	
	
}
