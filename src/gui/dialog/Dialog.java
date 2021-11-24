package gui.dialog;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import main.Settings;

public abstract class Dialog extends JDialog {
	private static final long serialVersionUID = -1676308500879210531L;
	enum EntityType {STUDENT, PROFESOR, PREDMET};
	protected final JFrame frame;
	
	protected JTabbedPane tabbedPane;
	protected ArrayList<DialogTab> tabPanels;
	
	EntityType entityType;
	
	public Dialog(JFrame frame, String title, EntityType et)
	{
		super(frame, title, true);
		this.frame = frame;
		this.init();	
		this.entityType = et;
		
		this.pack();
	}
	
	public void open()
	{
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void close()
	{
		this.setVisible(false);
	}
	
	static protected JPanel createRowPanel(int columnNumber)
	{
		if(columnNumber < 1) columnNumber = 1;
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(0, columnNumber, 32, 0));
		temp.setBorder(new EmptyBorder(5, 0, 5, 0));
		
		return temp;
	}
	
	static protected void setButtonHover(JButton btn, String color)
	{
		btn.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	btn.setBackground(Color.decode(color));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	btn.setBackground(UIManager.getColor("control"));
		    }
		});
	}
	
	private void init()
	{
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		
		this.tabPanels = new ArrayList<DialogTab>();
		this.tabbedPane = new JTabbedPane();
		this.setContentPane(container);
		
		this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(false);
	}
	
	protected class DialogTab extends JPanel{
		private static final long serialVersionUID = -1130421378464245296L;
		
		Dialog dialog;
		
		protected ArrayList<DialogPanel> panels = new ArrayList<DialogPanel>();
		
		public DialogTab(Dialog dialog)
		{
			super();
			
			this.dialog = dialog;
			
			this.setBorder(new EmptyBorder(10, 15, 10, 15));
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		}
		
		public void createPanel()
		{
			DialogPanel panel = new DialogPanel(dialog);
			
			this.panels.add(panel);
			this.add(panel);
			this.dialog.pack();
		}
		
		public void addLabel(int panelIndex, String labelText)
		{
			this.panels.get(panelIndex).addLabel(labelText);
		}
		
		public void addTextField(int panelIndex, String labelText)
		{
			this.panels.get(panelIndex).addTextField(labelText);
		}
		
		public void addTextField(int panelIndex, String labelText, String value)
		{
			this.panels.get(panelIndex).addTextField(labelText, value);
		}
		
		public void addDateField(int panelIndex, String labelText)
		{
			this.panels.get(panelIndex).addDateField(labelText);
		}
		
		public void addDateField(int panelIndex, String labelText, String value)
		{
			this.panels.get(panelIndex).addDateField(labelText, value);
		}
		
		public void addComboBox(int panelIndex, String labelText, String[] arr)
		{
			this.panels.get(panelIndex).addComboBox(labelText, arr);
		}
		
		public void addComboBox(int panelIndex, String labelText, String[] arr, int optionIndex)
		{
			this.panels.get(panelIndex).addComboBox(labelText, arr, optionIndex);
		}
		
		protected class DialogPanel extends JPanel{
			private static final long serialVersionUID = 840831711625149150L;
			
			Dialog dialog;
			
			protected ArrayList<JComponent> fields = new ArrayList<JComponent>();
			
			public DialogPanel(Dialog dialog)
			{
				super();
				
				this.dialog = dialog;
				
				this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			}
			
			protected void addLabel(String labelText)
			{
				JPanel panel = Dialog.createRowPanel(1);
				this.add(panel);
				JLabel label = new JLabel(labelText);
				panel.add(label);
				this.dialog.pack();
			}

			protected void addTextField(String labelText)
			{
				this.createTextField(labelText);
			}
			
			protected void addTextField(String labelText, String value)
			{
				JTextField textField = this.createTextField(labelText);
				textField.setText(value);
			}
			
			protected void addDateField(String labelText)
			{
				this.createDataField(labelText);
				//this.createTextField(labelText);
			}
			
			protected void addDateField(String labelText, String value)
			{
				JFormattedTextField dateTextField = this.createDataField(labelText);
				dateTextField.setText(value);
				//JTextField dateTextField = this.createTextField(labelText);
				//dateTextField.setText(value);
			}
			
			protected void addComboBox(String labelText, String[] arr)
			{
				this.createComboBox(labelText, arr);
			}
			
			protected void addComboBox(String labelText, String[] arr, int optionIndex)
			{
				JComboBox<?> comboBox = this.createComboBox(labelText, arr);
				comboBox.setSelectedIndex(optionIndex);
			}
			
			private JTextField createTextField(String labelText)
			{
				JPanel panel = Dialog.createRowPanel(2);
				this.add(panel);
				JLabel label = new JLabel(labelText);
				JTextField textField = new JTextField(16);
				textField.setBorder(new CompoundBorder(textField.getBorder(), new EmptyBorder(4, 2, 4, 4)));
				
				panel.add(label);
				panel.add(textField);
				
				this.fields.add(textField);
				this.dialog.pack();
				
				return textField;
			}
			
			private JFormattedTextField createDataField(String labelText)
			{
				
				JPanel panel = Dialog.createRowPanel(2);
				this.add(panel);
				JLabel label = new JLabel(labelText);
				DateFormat simpleDateFormat = new SimpleDateFormat(Settings.dateFormat);
		        JFormattedTextField dateTextField = new JFormattedTextField(simpleDateFormat);
		        dateTextField.setBorder(new CompoundBorder(dateTextField.getBorder(), new EmptyBorder(4, 2, 4, 4)));
		        
		        panel.add(label);
				panel.add(dateTextField);
				
				this.fields.add(dateTextField);
				this.dialog.pack();
				
				return dateTextField;
			}
			
			private JComboBox<?> createComboBox(String labelText, String[] arr)
			{
				JPanel panel = Dialog.createRowPanel(2);
				this.add(panel);
				JLabel label = new JLabel(labelText);
				JComboBox<String> comboBox = new JComboBox<String>(arr);
				JComponent tempComp = (JComponent) comboBox.getComponent(0);
				tempComp.setBorder(new CompoundBorder(tempComp.getBorder(), new EmptyBorder(1, 1, 1, 1)));
				
				panel.add(label);
				panel.add(comboBox);
				
				this.fields.add(comboBox);
				this.dialog.pack();
				
				return comboBox;
			}
		}
		
	}
	
}


















