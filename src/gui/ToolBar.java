package gui;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = -6297787221312734786L;

	public ToolBar()
	{
		super(SwingConstants.HORIZONTAL);
		this.setLayout(new GridLayout(1, 2));
		
		JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
        left.add(new JLabel("left"));
        right.add(new JLabel("right"));
        
		this.add(left);
		this.add(right);
		this.setFloatable(false);
	}
}
