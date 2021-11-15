package gui;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;  
import java.util.Date;     

public class StatusBar extends JPanel {
	private static final long serialVersionUID = 1696597433259221588L;
	JPanel leftPanel;
	JPanel rightPanel;
	JLabel statusBar;
	public MainWindow globalWindow;
	
	public StatusBar(MainWindow main)
	{
		super(new GridLayout(1, 2));
		globalWindow = main;
		
		leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		statusBar = new statusBarLabel("Main panel");
   
        leftPanel.add(statusBar);
        rightPanel.add(new statusBarLabel());
        
        this.add(leftPanel);
        this.add(rightPanel);
	}
	
	
	public void RefreshStatusBar(int activePanel)
	{
		if(activePanel == 0) 
		{
			statusBar.setText("Studentska služba - Studenti" );
		}
		else if (activePanel == 1)
		{
			statusBar.setText("Studentska služba - Profesori");
		}
		else if (activePanel == 2)
		{
			statusBar.setText("Studentska služba - Predmeti");
		}
		
	}
	
	
	class statusBarLabel extends JLabel
	{
		
		private static final long serialVersionUID = 3198607465635042565L;

		public statusBarLabel(String panel)
		{
			super("Studentska služba - " + panel);
			
		}
		
		public void RefreshStatusBar(String text)
		{
			this.setText("Studentska služba - " + text);
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
