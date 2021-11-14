package gui;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;  
import java.util.Date;     

public class StatusBar extends JPanel {
	private static final long serialVersionUID = 1696597433259221588L;
	JPanel leftPanel;
	JPanel rightPanel;
	
	public StatusBar()
	{
		super(new GridLayout(1, 2));
		
		leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
   
        leftPanel.add(new statusBarLabel("Main panel"));
        rightPanel.add(new statusBarLabel());
        
        this.add(leftPanel);
        this.add(rightPanel);
	}
	
	class statusBarLabel extends JLabel
	{
		public statusBarLabel(String panel)
		{
			super("Studentska služba - " + panel);
		}
		
		public statusBarLabel()
		{
			super();
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");  
			Date date = new Date();   
			this.setText(formatter.format(date));
		}
	}
}
