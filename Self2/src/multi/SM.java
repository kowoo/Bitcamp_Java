package multi;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JMenu;

public class SM extends JFrame {
	JButton btOpen;
	JList list;
	
	public static void main(String[] args) {
		SM s = new SM();
	}
	
	public SM() {
		this.setTitle("0회용 프로그램");
		this.setSize(317, 503);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		list = new JList();
		list.setBounds(12, 10, 235, 389);
		panel.add(list);
		
		btOpen = new JButton("열기");
		btOpen.setBounds(12, 409, 97, 23);
		panel.add(btOpen);
		btOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.setVisible(true);
	}
}
