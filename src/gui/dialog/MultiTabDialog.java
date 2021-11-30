package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import gui.table.Table;

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
	
	public class TablePanel extends JPanel{
		private static final long serialVersionUID = 1733942904388036989L;
		
		Table table;
		
		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		
		JPanel buttonPanel;
		
		public TablePanel(Table table)
		{
			super();
			this.table = table;
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			this.setPanels();
		}
		
		protected void setPanels()
		{
			this.setButtonPanel();
			this.setTable();
			
			for(JPanel panel: panels) this.add(panel);
		}
		
		protected void setButtonPanel()
		{
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1, 1));
			JPanel buttonContainer = new JPanel();
			buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.LINE_AXIS));
			panel.add(buttonContainer);
			
			this.buttonPanel = buttonContainer;
			this.panels.add(panel);
		}
		
		public void addButton(JButton btn)
		{
			this.buttonPanel.add(btn);
			this.buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		}
		
		protected void setTable()
		{
			this.table.getTableHeader().setFont(new Font("Monaco", Font.PLAIN, 13));
			this.table.setFont(new Font("Monaco", Font.PLAIN, 13));
			
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			JScrollPane sp = new JScrollPane(this.table);
			sp.setBorder(new CompoundBorder(new EmptyBorder(15, 0, 25, 0), sp.getBorder()));
			panel.add(sp, BorderLayout.CENTER);
			
			this.panels.add(panel);
		}
		
	}
}













