package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	
	public MyFrame2() {
		this.setSize(457, 355);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(302, 9, 106, 23);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(12, 10, 278, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 42, 396, 246);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
