package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = -6297787221312734786L;

	public ToolBar()
	{
		super(SwingConstants.HORIZONTAL);
		this.setLayout(new GridLayout(1, 2));
		JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
        left.add(new toolBarButton("img/icon_new.png"));
        left.add(new toolBarButton("img/icon_edit.png"));
        left.add(new toolBarButton("img/icon_delete.png"));

        right.add(new toolBarTextField());        
        right.add(new toolBarButton("img/icon_search.png"));
        
		this.add(left);
		this.add(right);
		this.setFloatable(false);
	}
	
	
	class toolBarButton extends JButton
	{
		public toolBarButton(String path)
		{
			super(new ImageIcon(path));
			this.setPreferredSize(new Dimension(32, 32));
		}
	}

	class toolBarTextField extends JTextField
	{
		public toolBarTextField()
		{
			super();
			this.setPreferredSize(new Dimension(150, 25));
		}
	}
	
	
	
}
