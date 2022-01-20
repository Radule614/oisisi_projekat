package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import app.Settings;
import gui.MainWindow;
import gui.dialog.Dialog.DialogTab.DialogPanel;
import gui.table.Table;

public abstract class Dialog extends JDialog {
	private static final long serialVersionUID = -1676308500879210531L;
	public enum EntityType {STUDENT, PROFESOR, PREDMET};
	protected final static MainWindow window = MainWindow.getInstance();
	
	protected JTabbedPane tabbedPane;
	public ArrayList<DialogTab> tabPanels;
	
	public EntityType entityType;
	
	public Dialog(String title, EntityType et)
	{
		super(window, title, true);
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
	
	protected JButton setButtons(int tabIndex, int panelIndex, String[] labels, ActionListener listener)
	{
		DialogTab tab = tabPanels.get(tabIndex);
		DialogPanel buttonPanel = tab.panels.get(1);
		JPanel panel = Dialog.createRowPanel(2);
		buttonPanel.add(panel);
		
		FlowLayout leftPanelLayout = new FlowLayout(FlowLayout.RIGHT);
		leftPanelLayout.setHgap(0);
		FlowLayout rightPanelLayout = new FlowLayout(FlowLayout.LEFT);
		rightPanelLayout.setHgap(0);
		
		JButton submit = null;
		JButton cancel = null;
		
		if(labels != null && labels.length == 2)
		{
			submit = new JButton(labels[0]);
			cancel = new JButton(labels[1]);
		}
		else
		{
			submit = new JButton(MainWindow.getInstance().GetResourceBundle().getObject("btnPotvrdi").toString());
			cancel = new JButton(MainWindow.getInstance().GetResourceBundle().getObject("btnOdustani").toString());
		}
		
		JPanel leftPanel = new JPanel(leftPanelLayout);
		JPanel rightPanel = new JPanel(rightPanelLayout);
		
		Dialog.setButtonHover(submit, "#95bcf2");
		Dialog.setButtonHover(cancel, "#9b5377");
		
		leftPanel.add(submit);
		rightPanel.add(cancel);
		
		Dialog dialog = this;
		submit.addActionListener(listener);
		
		cancel.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dialog.close();
			}
		});
		
		panel.add(leftPanel);
		panel.add(rightPanel);
		
		return submit;
	}
	
	public class DialogTab extends JPanel{
		private static final long serialVersionUID = -1130421378464245296L;
		Dialog dialog;
		
		public ArrayList<DialogPanel> panels = new ArrayList<DialogPanel>();
		
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
		public void addTextField(int panelIndex, String labelText, String value, boolean editable)
		{
			this.panels.get(panelIndex).addTextField(labelText, value, editable);
		}
		public void addDateField(int panelIndex, String labelText)
		{
			this.panels.get(panelIndex).addDateField(labelText);
		}
		public void addDateField(int panelIndex, String labelText, String value)
		{
			this.panels.get(panelIndex).addDateField(labelText, value);
		}
		public void addDateField(int panelIndex, String labelText, String value, boolean editable)
		{
			this.panels.get(panelIndex).addDateField(labelText, value, editable);
		}
		public void addComboBox(int panelIndex, String labelText, String[] arr)
		{
			this.panels.get(panelIndex).addComboBox(labelText, arr);
		}
		public void addComboBox(int panelIndex, String labelText, String[] arr, int optionIndex)
		{
			this.panels.get(panelIndex).addComboBox(labelText, arr, optionIndex);
		}
		public void addComboBox(int panelIndex, String labelText, String[] arr, int optionIndex, boolean editable)
		{
			this.panels.get(panelIndex).addComboBox(labelText, arr, optionIndex, editable);
		}
		
		public String[] getData(int panelIndex)
		{
			return this.panels.get(panelIndex).getData();
		}
		
		public class DialogPanel extends JPanel{
			private static final long serialVersionUID = 840831711625149150L;
			Dialog dialog;
			public int textFieldLength = 16;
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
			protected void addTextField(String labelText, String value, int enabled)
			{
				
				JTextField textField = this.createTextField(labelText);
				textField.setText(value);
				if(enabled == 1)
				{
					textField.setEnabled(true);
				}
				else
				{
					textField.setEnabled(false);
				}
			}
			protected void addButton(String labelText, String value)
			{
				JTextField textField = this.createTextField(labelText);
				textField.setText(value);
			}
			protected void addTextField(String labelText, String value)
			{
				JTextField textField = this.createTextField(labelText);
				textField.setText(value);
			}
			protected void addTextField(String labelText, String value, boolean editable)
			{
				JTextField textField = this.createTextField(labelText);
				textField.setText(value);
				textField.setEditable(editable);
			}
			protected void addDateField(String labelText)
			{
				this.createDataField(labelText);
			}
			protected void addDateField(String labelText, String value)
			{
				JFormattedTextField dateTextField = this.createDataField(labelText);
				dateTextField.setText(value);
			}
			protected void addDateField(String labelText, String value, boolean editable)
			{
				JFormattedTextField dateTextField = this.createDataField(labelText);
				dateTextField.setText(value);
				dateTextField.setEditable(editable);
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
			protected void addComboBox(String labelText, String[] arr, int optionIndex, boolean editable)
			{
				JComboBox<?> comboBox = this.createComboBox(labelText, arr);
				comboBox.setSelectedIndex(optionIndex);
				comboBox.setEditable(editable);
			}
			
			protected String[] getData()
			{
				String[] data = new String[fields.size()];
				
				boolean error = false;
				int r = 0;
				for(JComponent field: fields)
				{
					if(field instanceof JTextField)
					{
						JTextField temp = (JTextField)field;
						if(temp.getText().isEmpty())
						{
							error = true;
							break;
						}
						data[r] = new String(temp.getText());
					}
					else if(field instanceof JFormattedTextField)
					{
						JFormattedTextField temp = (JFormattedTextField)field;
						if(temp.getText().isEmpty())
						{
							error = true;
							break;
						}
						data[r] = new String(temp.getText());
					}
					else if(field instanceof JComboBox)
					{
						JComboBox<?> temp = (JComboBox<?>)field;
						data[r] = new String(Integer.toString(temp.getSelectedIndex()));
					}
					++r;
				}
				if(error) return null;
				return data;
			}
			
			private boolean checkFields()
			{
				boolean error = false;
				for(JComponent field: fields)
				{
					if(field instanceof JTextField)
					{
						JTextField temp = (JTextField)field;
						if(temp.getText().isEmpty())
						{
							error = true;
							break;
						}
					}
					else if(field instanceof JFormattedTextField)
					{
						JFormattedTextField temp = (JFormattedTextField)field;
						if(temp.getText().isEmpty())
						{
							error = true;
							break;
						}
					}
				}
				return !error;
			}
			
			public void setEmptyDocumentListeners(JButton btn)
			{
				DocumentListener listener = new DocumentListener() {
					@Override
					public void insertUpdate(DocumentEvent e) {
						if(!checkFields())
							btn.setEnabled(false);
						else
							btn.setEnabled(true);
					}
					@Override
					public void removeUpdate(DocumentEvent e) {
						if(!checkFields())
							btn.setEnabled(false);
						else
							btn.setEnabled(true);
					}
					@Override
					public void changedUpdate(DocumentEvent e) {
						
					}
				};
				
				for(JComponent field: fields)
				{
					if(field instanceof JTextField)
						((JTextField)field).getDocument().addDocumentListener(listener);
					if(field instanceof JFormattedTextField)
						((JFormattedTextField)field).getDocument().addDocumentListener(listener);
				}
			}
			
			private JTextField createTextField(String labelText)
			{
				JPanel panel = Dialog.createRowPanel(2);
				this.add(panel);
				JLabel label = new JLabel(labelText);
				JTextField textField = new JTextField(this.textFieldLength);
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
	
	public class TablePanel extends JPanel{
		private static final long serialVersionUID = 1733942904388036989L;
		
		Table table;
		
		public ArrayList<JPanel> panels = new ArrayList<JPanel>();
		public ArrayList<JButton> buttons = new ArrayList<JButton>();
		
		public JPanel buttonPanel;
		public JScrollPane scrollPane;
		public JPanel scrollPanel;
		
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
			
			this.scrollPanel = panel;
			this.scrollPane = sp;
			this.panels.add(panel);
		}
		
		public void updateTable(Table table)
		{
			this.table = table;
			this.table.getTableHeader().setFont(new Font("Monaco", Font.PLAIN, 13));
			this.table.setFont(new Font("Monaco", Font.PLAIN, 13));
			
			JScrollPane sp = new JScrollPane(this.table);
			sp.setBorder(new CompoundBorder(new EmptyBorder(15, 0, 25, 0), sp.getBorder()));
			this.scrollPane = sp;
			this.scrollPanel.removeAll();
			this.scrollPanel.add(sp);
		}
		
	}
}


















