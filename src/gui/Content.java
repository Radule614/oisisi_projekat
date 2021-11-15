package gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.ArrayList;

public class Content extends JPanel {
	private static final long serialVersionUID = -6293741523398644702L;
	
	protected final String[] tabLabels = {"Studenti", "Profesori", "Predmeti"};
	
	TableManager tableManager;
	ArrayList<JPanel> panels;
	JTabbedPane tabbedPane;
	
	public Content() {
		super();
		panels = new ArrayList<JPanel>();
		tableManager = new TableManager();
		tabbedPane = new JTabbedPane();
		for(int i = 0; i < 3; ++i)
		{
			JPanel panelTemp = new JPanel();

			panels.add(panelTemp);
		}
		
		this.setLayout(new BorderLayout());
		this.setBorder(new CompoundBorder(new EmptyBorder(30, 0, 10, 0), this.getBorder()));
		
		this.setTabbedPane();
	}
	
	public void addToTable(Object obj)
	{	
		tableManager.add(obj);		
	}
	
	public int getActivePane()
	{
		return this.tabbedPane.getSelectedIndex();
	}
	
	protected void setTabbedPane()
	{
		int i = 0;
		for(JPanel p: panels)
		{
			p.setLayout(new BorderLayout());
			
			JScrollPane sp = new JScrollPane(tableManager.getTables().get(i));
			sp.setBorder(new CompoundBorder(new EmptyBorder(25, 40, 25, 40), sp.getBorder()));
			p.add(sp, BorderLayout.CENTER);
			
			tabbedPane.addTab(null, p);
			
			JLabel temp = new JLabel(tabLabels[i]);
			temp.setBorder(new EmptyBorder(5, 10, 5, 10));
			tabbedPane.setTabComponentAt(i, temp);
			
			++i;
		}
		tabbedPane.setBorder(new EmptyBorder(0, 30, 0, 30));
		this.add(tabbedPane, BorderLayout.CENTER);
	}
}






