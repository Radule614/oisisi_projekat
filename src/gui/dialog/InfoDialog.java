package gui.dialog;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InfoDialog extends OneTabDialog {
	private static final long serialVersionUID = -2702013850163258103L;

	public InfoDialog(String title) {
		super(title, null);
		
		this.mainTab.createPanel();
		this.mainTab.createPanel();
		
		addCloseButton();
		this.pack();
	}
	
	public void addText(String s){
		DialogTab.DialogPanel parentPanel = this.mainTab.panels.get(0);
		JPanel panel = Dialog.createRowPanel(1);
		JLabel label = new JLabel(s);
		panel.add(label);
		parentPanel.add(panel);
		this.pack();
	}

	protected void addCloseButton(){
        DialogTab.DialogPanel parentPanel = this.mainTab.panels.get(1);
        JPanel panel = Dialog.createRowPanel(1);
        panel.setLayout(new FlowLayout());
        panel.setBorder(new EmptyBorder(15, 0, 0, 0));

        JButton btn = new JButton("OK");
        btn.addActionListener(e -> this.close());

        panel.add(btn);
        parentPanel.add(panel);
    }
}
