package gui.dialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MultiTabDialog extends Dialog {
	private static final long serialVersionUID = 7200065442734182446L;

	public MultiTabDialog(String title, EntityType entityType, String[] tabLabels) {
		super(title, entityType);
		
		for(int i = 0; i < tabLabels.length; ++i)
		{
			DialogTab tabPanel = new DialogTab(this);
			
			tabPanels.add(tabPanel);
			tabbedPane.addTab(null, tabPanel);
			
			JLabel temp = new JLabel(tabLabels[i]);
			temp.setBorder(new EmptyBorder(5, 10, 5, 10));
			tabbedPane.setTabComponentAt(i, temp);
			
			tabPanel.createPanel();
		}
		
		this.add(tabbedPane);
		this.pack();
	}
	
	
}













