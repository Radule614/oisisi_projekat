package gui.bar;

import javax.swing.*;

import gui.MainWindow;

import java.awt.*;
import java.text.SimpleDateFormat;  
import java.util.Date;     

import java.awt.event.ActionEvent;

public class StatusBar extends JPanel {
	private static final long serialVersionUID = 1696597433259221588L;
	
	JPanel leftPanel;
	JPanel rightPanel;
	
	public MainWindow mainWindow;
	private int currentPanel= 0;
	static StatusBar instance;
	public StatusBarLabel stsBarLabel;
	public StatusBarTimeLabel stsBarTimer;
	
	private StatusBar()
	{
		super(new GridLayout(1, 2));

		
		leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		stsBarLabel = new StatusBarLabel("Main panel");
		stsBarTimer = new StatusBarTimeLabel();
		
        leftPanel.add(stsBarLabel);
        rightPanel.add(stsBarTimer);
        
        this.add(leftPanel);
        this.add(rightPanel);
        
        mainWindow = MainWindow.getInstance();
        RefreshStatusBar(0);
	}
	
	public static StatusBar getInstance()
	{
		if(StatusBar.instance == null) 
		{
			StatusBar.instance = new StatusBar();
		}
		
		return StatusBar.instance;
	}
	
	
	public void RefreshStatusBar(int activePanel)
	{
		if(activePanel == 0) 
		{
			stsBarLabel.setText(mainWindow.GetResourceBundle().getObject("stsBarStudent").toString());
			currentPanel = 0;
		}
		else if (activePanel == 1)
		{
			stsBarLabel.setText(mainWindow.GetResourceBundle().getObject("stsBarProfesor").toString());
			currentPanel = 1;
		}
		else if (activePanel == 2)
		{
			stsBarLabel.setText(mainWindow.GetResourceBundle().getObject("stsBarPredmet").toString());
			currentPanel = 2;
		}
		else //Prosledi 3 da ostane isti panel
		{
			RefreshStatusBar(currentPanel);
		}
		
	}
	
	public void UpdateTimeAndDate(StatusBarTimeLabel lbl)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");  
		Date date = new Date();   
		lbl.setText(formatter.format(date));
	}
	
	
	
	private void activateTimer()
	{
	    Timer myTimer = new Timer(1000, myAction);
	    myTimer.start();
	}

	private Action myAction = new AbstractAction()
	{
	    private static final long serialVersionUID = 1L;

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	UpdateTimeAndDate(stsBarTimer);
	    	activateTimer();
	    }
	};
	
	
	
	class StatusBarLabel extends JLabel
	{
		
		private static final long serialVersionUID = 3198607465635042565L;

		public StatusBarLabel(String panel)
		{
			super("Studentska slu??ba - " + panel);
			
		}
		
		public void RefreshStatusBar(String text)
		{
			this.setText("Studentska slu??ba - " + text);
		}
		
	}
	
	class StatusBarTimeLabel extends JLabel
	{
		
		private static final long serialVersionUID = 3198607465635042565L;

		public StatusBarTimeLabel()
		{
			super();
			activateTimer();
		}

	}
}
