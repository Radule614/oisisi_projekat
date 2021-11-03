package gui;

import javax.swing.*;

import java.awt.*;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 2740437090361841747L;
	public int width;
	public int height;

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
		
		MenuBar menu_bar = new MenuBar();
        JToolBar tool_bar = new ToolBar();
        JPanel content = new Content();
        StatusBar status_bar = new StatusBar();
        
        this.setJMenuBar(menu_bar);
        this.getContentPane().add(BorderLayout.NORTH, tool_bar);
        this.getContentPane().add(BorderLayout.CENTER, content);
        this.getContentPane().add(BorderLayout.SOUTH, status_bar);
	}
}
