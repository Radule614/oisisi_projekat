package gui.dialog.edit;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import gui.dialog.Dialog;
import gui.dialog.MultiTabDialog;
import gui.manager.DialogManager;
import gui.manager.TableManager;
import gui.table.Table;

public class EditStudentDialog extends MultiTabDialog {
	private static final long serialVersionUID = -268052684667075413L;
	protected int studentTableRow;
	
	protected Table polozeniTable;
	protected TablePanel polozeniTablePanel;
	
	protected Table nepolozeniTable;
	protected TablePanel nepolozeniTablePanel;
	
	JButton submit;
	
	public EditStudentDialog(String title, EntityType entityType, int tableRow, String[] tabLabels) {
		super(title, entityType, tabLabels);
		this.studentTableRow = tableRow;
		
		this.init();
		this.pack();
	}
	
	private void init()
	{
		this.tabPanels.get(0).createPanel();
		this.tabPanels.get(0).setBorder(new CompoundBorder(this.tabPanels.get(0).getBorder(), new EmptyBorder(0, 75, 0, 75)));
		this.setEditButtons();
		
		this.setPolozeniTable();
		this.setNepolozeniTable();
		
		this.polozeniTablePanel = new TablePanel(this.polozeniTable);
		this.tabPanels.get(1).setBorder(new EmptyBorder(25, 40, 25, 40));
		this.tabPanels.get(1).panels.get(0).add(this.polozeniTablePanel);
		
		this.nepolozeniTablePanel = new TablePanel(this.nepolozeniTable);
		this.tabPanels.get(2).setBorder(new EmptyBorder(25, 40, 25, 40));
		this.tabPanels.get(2).panels.get(0).add(this.nepolozeniTablePanel);

		this.tabPanels.get(1).createPanel();
		
		this.setRemoveOcenaButton();
		this.setNepolozeniButtons();
		
		this.setPolozeniLabels();
	}
	
	protected void setEditButtons()
	{
		EditActionListener action = new EditActionListener(this, studentTableRow);
		submit = this.setButtons(0, 1, null, action);
	}
	
	public void setSubmitEnabledEvents()
	{
		this.tabPanels.get(0).panels.get(0).setEmptyDocumentListeners(submit);
	}
	
	protected void setRemoveOcenaButton()
	{
		JButton btn = new JButton("Poništi ocenu");
		Dialog.setButtonHover(btn, "#95bcf2");
		this.polozeniTablePanel.addButton(btn);
		
		EditStudentDialog dialog = this;
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int gradeRow = polozeniTable.getSelectedRowFromModel();
				if(gradeRow != -1) DialogManager.createRemoveOcenaDialog(dialog, gradeRow);
			}
		});
	}
	
	protected void setNepolozeniButtons()
	{
		JButton btnDodaj 		= new JButton("Dodaj");
		JButton btnObrisi 		= new JButton("Obrisi");
		JButton btnPolaganje 	= new JButton("Polaganje");
		
		Dialog.setButtonHover(btnDodaj, "#95bcf2");
		Dialog.setButtonHover(btnObrisi, "#9b5377");
		Dialog.setButtonHover(btnPolaganje, "#95bcf2");
		
		this.nepolozeniTablePanel.addButton(btnDodaj);
		this.nepolozeniTablePanel.addButton(btnObrisi);
		this.nepolozeniTablePanel.addButton(btnPolaganje);
		
		EditStudentDialog dialog = this;
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogManager.createAddIspitDialog(dialog);
			}
		});
		
		btnObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int predmetRow = nepolozeniTable.getSelectedRowFromModel();
				if(predmetRow != -1) DialogManager.createRemovePredmetDialog(dialog, predmetRow);
			}
		});
		
		btnPolaganje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int predmetRow = nepolozeniTable.getSelectedRowFromModel();
				if(predmetRow != -1) DialogManager.createAddOcenaDialog(dialog, predmetRow);
			}
		});
	}
	
	public void setPolozeniTable()
	{
		ArrayList<String[]> dataArray = Controller.student.getPolozeniIspiti(studentTableRow);
		this.polozeniTable = TableManager.createPolozeniTable(dataArray);	
	}
	
	public void setNepolozeniTable()
	{
		ArrayList<String[]> dataArray = Controller.student.getNepolozeniIspiti(studentTableRow);
		this.nepolozeniTable = TableManager.createNepolozeniTable(dataArray);
	}
	
	public void updatePolozeniTable()
	{
		this.setPolozeniTable();
		this.polozeniTablePanel.updateTable(this.polozeniTable);
		this.polozeniTablePanel.revalidate();
	}
	
	public void updateNepolozeniTable()
	{
		this.setNepolozeniTable();
		this.nepolozeniTablePanel.updateTable(this.nepolozeniTable);
		this.nepolozeniTablePanel.revalidate();
	}
	
	public void setPolozeniLabels()
	{
		double avg = Controller.student.getProsek(studentTableRow);
		int ESPB = Controller.student.getTotalESPB(studentTableRow);
		
		String[] data = new String[2];
		data[0] = new String("Prosečna ocena: " + avg);
		data[1] = new String("Ukupno ESPB: " + ESPB);
		JPanel panel = this.tabPanels.get(1).panels.get(1);
		panel.removeAll();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
		for(String s: data)
		{
			innerPanel.add(new JLabel(s));
			innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		}
		
		panel.add(innerPanel);
		panel.revalidate();
		panel.repaint();
	}
	
	public Table getPolozeniTable()
	{
		return this.polozeniTable;
	}
	
	public Table getNepolozeniTable()
	{
		return this.nepolozeniTable;
	}
	
	public int getStudentIndex()
	{
		return this.studentTableRow;
	}
	
}












