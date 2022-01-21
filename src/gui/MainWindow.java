package gui;

import javax.swing.*;

import gui.bar.MenuBar;
import gui.bar.StatusBar;
import gui.bar.ToolBar;
import gui.manager.TableManager;

import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 2740437090361841747L;
	private static MainWindow instance;
	
	public int width;
	public int height;
	
	protected MenuBar menuBar;
	protected ToolBar toolBar;
	protected Content content;
	protected StatusBar statusBar;

	private ResourceBundle resourceBundle;
	private MainWindow()
	{
		super();
		instance = this;
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		height = 3 * screenSize.height / 4;
		width = 3 * screenSize.width / 4;
		setSize(width, height);
		setTitle("Studentska Služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.setFont(new Font("Monaco", Font.PLAIN, 15));
		
		menuBar = MenuBar.getInstance();
		toolBar = ToolBar.getInstance();
        content = Content.getInstance();
        statusBar = StatusBar.getInstance();
        
        this.setJMenuBar(menuBar);
        this.getContentPane().add(BorderLayout.NORTH, toolBar);
        this.getContentPane().add(BorderLayout.CENTER, content);
        this.getContentPane().add(BorderLayout.SOUTH, statusBar);
        
        resourceBundle = ResourceBundle.getBundle("gui.localization.MessageResources", Locale.getDefault());
        
	}
	
	public static MainWindow getInstance()
	{
		if(instance == null) 
		{
			instance = new MainWindow();
		}
		
		return instance;
	}
	
	public void setActivePane(int index)
	{
		this.content.setActivePane(index);
	}
	
	public int getActivePane()
	{
		return this.content.getActivePane();
	}
	
	protected void setPaneStatus(int activePane)
	{
		statusBar.RefreshStatusBar(activePane);
	}
	
	public ResourceBundle GetResourceBundle()
	{
		resourceBundle = ResourceBundle.getBundle("gui.localization.MessageResources", Locale.getDefault());
		return resourceBundle;
	}
	
	public String GetLocalization(String name)
	{
		return GetResourceBundle().getObject(name).toString();
	}
	
	public void SetLanguageToSerbian()
	{
		Locale.setDefault(new Locale("sr", "RS"));
		menuBar.RefreshText();
		statusBar.RefreshStatusBar(3);
		Content.RefreshTabs();
		TableManager.RefreshTables();
	}
	
	public void SetLanguageToEnglish()
	{
		Locale.setDefault(new Locale("en", "US"));
		menuBar.RefreshText();
		statusBar.RefreshStatusBar(3);
		TableManager.RefreshTables();
		Content.RefreshTabs();
	}
	
	
	
}










