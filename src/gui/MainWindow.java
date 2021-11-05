package gui;

import javax.swing.*;

import java.awt.*;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 2740437090361841747L;
	public int width;
	public int height;
	
	protected MenuBar menuBar = new MenuBar();
	protected ToolBar toolBar = new ToolBar();
	protected Content content = new Content();
	protected StatusBar statusBar = new StatusBar();

	public MainWindow()
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
		
		menuBar = new MenuBar();
        toolBar = new ToolBar();
        content = new Content();
        statusBar = new StatusBar();
        
        this.setJMenuBar(menuBar);
        this.getContentPane().add(BorderLayout.NORTH, toolBar);
        this.getContentPane().add(BorderLayout.CENTER, content);
        this.getContentPane().add(BorderLayout.SOUTH, statusBar);
	}
	
	public void addToTable(Object obj)
	{
		this.content.addToTable(obj);
	}
}
