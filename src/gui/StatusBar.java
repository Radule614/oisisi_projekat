package gui;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JPanel {
	private static final long serialVersionUID = 1696597433259221588L;
	JPanel leftPanel;
	JPanel rightPanel;
	
	public StatusBar()
	{
		super(new GridLayout(1, 2));
		
		leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
        leftPanel.add(new JLabel("left"));
        rightPanel.add(new JLabel("right"));
        
        this.add(leftPanel);
        this.add(rightPanel);
	}
}
