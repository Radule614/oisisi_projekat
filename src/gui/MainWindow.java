package gui;

import javax.swing.*;

import gui.bar.MenuBar;
import gui.bar.StatusBar;
import gui.bar.ToolBar;

import java.awt.*;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 2740437090361841747L;
	private static MainWindow instance;
	
	public int width;
	public int height;
	
	protected MenuBar menuBar;
	protected ToolBar toolBar;
	protected Content content;
	protected StatusBar statusBar;

	private MainWindow()
	{
		super();
		
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
	}
	
	public static MainWindow getInstance()
	{
		if(MainWindow.instance == null) MainWindow.instance = new MainWindow();
		return MainWindow.instance;
	}
	
	public int getActivePane()
	{
		return this.content.getActivePane();
	}
	
	protected void setPaneStatus(int activePane)
	{
		statusBar.RefreshStatusBar(activePane);
	}
}










