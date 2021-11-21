package gui;

import java.awt.Color;
import java.awt.FlowLayout;
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

import main.Events;

public class Dialog extends JDialog {
	private static final long serialVersionUID = -1676308500879210531L;
	ArrayList<JComponent> fields = new ArrayList<JComponent>();
	JPanel fieldContainer;
	
	enum EntityType {STUDENT, PROFESOR, PREDMET};
	
	EntityType entityType;
	
	public Dialog(JFrame frame, String title, EntityType entityType)
	{
		super(frame, title, true);
		this.entityType = entityType;
		this.setContainer();
        this.setButtons();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(false);
	}
	
	
	//PUBLIC METHODS
	
	public void addField(String labelText)
	{
		this.addTextField(labelText);
	}
	
	public void addField(String labelText, String dateFormat)
	{
		this.addDateField(labelText, dateFormat);
	}
	
	public void addField(String labelText, String[] arr)
	{
		this.addComboBox(labelText, arr);
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
	
	//PUBLIC END
	
	
	protected void setContainer()
	{
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		container.setBorder(new EmptyBorder(10, 15, 10, 15));
		
		fieldContainer = new JPanel();
		fieldContainer.setLayout(new BoxLayout(fieldContainer, BoxLayout.PAGE_AXIS));
		
		container.add(fieldContainer);
		this.setContentPane(container);
	}
	
	protected JPanel createRowPanel()
	{
		JPanel temp = new JPanel();
		temp.setLayout(new GridLayout(0, 2, 32, 0));
		temp.setBorder(new EmptyBorder(5, 0, 5, 0));
		
		return temp;
	}
	
	protected void addTextField(String labelText)
	{
		JPanel panel = this.createRowPanel();
		fieldContainer.add(panel);
		JLabel label = new JLabel(labelText);
		JTextField textField = new JTextField(16);
		textField.setBorder(new CompoundBorder(textField.getBorder(), new EmptyBorder(4, 2, 4, 4)));
		
		panel.add(label);
		panel.add(textField);
		
		this.fields.add(textField);
		this.pack();
	}
	
	protected void addDateField(String labelText, String format)
	{
		JPanel panel = this.createRowPanel();
		fieldContainer.add(panel);
		JLabel label = new JLabel(labelText);
		DateFormat dateFormat = new SimpleDateFormat(format);
        JFormattedTextField dateTextField = new JFormattedTextField(dateFormat);
        dateTextField.setBorder(new CompoundBorder(dateTextField.getBorder(), new EmptyBorder(4, 2, 4, 4)));
        
        panel.add(label);
		panel.add(dateTextField);
		
		this.fields.add(dateTextField);
		this.pack();
	}
	
	protected void addComboBox(String labelText, String[] arr)
	{
		JPanel panel = this.createRowPanel();
		fieldContainer.add(panel);
		JLabel label = new JLabel(labelText);
		JComboBox<String> comboBox = new JComboBox<String>(arr);
		JComponent tempComp = (JComponent) comboBox.getComponent(0);
		tempComp.setBorder(new CompoundBorder(tempComp.getBorder(), new EmptyBorder(1, 1, 1, 1)));
		
		panel.add(label);
		panel.add(comboBox);
		
		this.fields.add(comboBox);
		this.pack();
	}
	
	protected void setButtonHover(JButton btn, String color)
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
	
	protected void setButtons()
	{
		JPanel panel = this.createRowPanel();
		this.add(panel);
		
		FlowLayout leftPanelLayout = new FlowLayout(FlowLayout.RIGHT);
		leftPanelLayout.setHgap(0);
		FlowLayout rightPanelLayout = new FlowLayout(FlowLayout.LEFT);
		rightPanelLayout.setHgap(0);
		
		JPanel leftPanel = new JPanel(leftPanelLayout);
		JPanel rightPanel = new JPanel(rightPanelLayout);		
		
		JButton submit = new JButton("Potvrdi");
		JButton cancel = new JButton("Odustani");
		
		this.setButtonHover(submit, "#95bcf2");
		this.setButtonHover(cancel, "#9b5377");
		
		leftPanel.add(submit);
		rightPanel.add(cancel);
		
		Dialog dialog = this;
		
		submit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int r = 0;
				boolean error = false;
				String[] arr = new String[fields.size()];
				
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
						arr[r] = new String(temp.getText());
					}
					else if(field instanceof JFormattedTextField)
					{
						JFormattedTextField temp = (JFormattedTextField)field;
						if(temp.getText().isEmpty())
						{
							error = true;
							break;
						}
						arr[r] = new String(temp.getText());
					}
					else if(field instanceof JComboBox)
					{
						JComboBox<?> temp = (JComboBox<?>)field;
						arr[r] = new String(Integer.toString(temp.getSelectedIndex()));
					}
					++r;
				}
				
				if(!error)
				{
					switch(entityType)
					{
					case STUDENT:
						Events.createStudent(arr);
						break;
					case PROFESOR:
						Events.createProfesor(arr);
						break;
					case PREDMET:
						Events.createPredmet(arr);
						break;
					}
					
					dialog.close();
				}
			}
		});
		
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
	}
}


















