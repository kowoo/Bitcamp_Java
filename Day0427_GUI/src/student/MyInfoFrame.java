package student;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class MyInfoFrame extends JFrame {
		public MyInfoFrame() {
			getContentPane().setLayout(null);
			
			this.setSize(316, 337);
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			//absolute layout: 컴포넌트의 위치를 마음대로 지정
			panel.setLayout(null);
			
			JButton button1 = new JButton("ㅎㅎ"); //버튼에 표시될 글자
			button1.setBounds(0, 0, 105, 70); //버튼 1의 위치, 크기를 셋
			panel.add(button1);
			
			//글자 입력을 위한 컴퍼넌트
			//JTextField
			JTextField textField = new JTextField();
			textField.setBounds(12, 10, 129, 61);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			//글자를 표시하는 컴퍼넌트
			//JLabel
			JLabel label = new JLabel("당신은 바보인가요?");
			label.setBounds(19, 81, 122, 19);
			getContentPane().add(label);
			
			JButton btnNewButton = new JButton("버튼");
			btnNewButton.setBounds(153, 10, 135, 61);
			getContentPane().add(btnNewButton);
			
			JCheckBox checkBox = new JCheckBox("예");
			checkBox.setBounds(149, 79, 45, 23);
			getContentPane().add(checkBox);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("아니오");
			chckbxNewCheckBox.setBounds(219, 79, 73, 23);
			getContentPane().add(chckbxNewCheckBox);
			
			//컬렉션 중 하나, List와 매우 유사하다
			Vector<String> contents = new Vector<String>();
			contents.add("쥐");
			contents.add("소");
			contents.add("랑이");
			contents.add("토끼");
			contents.add("용");
			
			System.out.println(checkBox.isSelected());
			
			
			JList list = new JList(contents);
			list.setBounds(12, 123, 129, 129);
			getContentPane().add(list);
			
			
			
			ButtonGroup group = new ButtonGroup();

			JRadioButton a = new JRadioButton("1번");
			a.setBounds(153, 130, 121, 23);
			getContentPane().add(a);
			
			JRadioButton b = new JRadioButton("2번");
			b.setBounds(153, 162, 121, 23);
			getContentPane().add(b);
			
			group.add(a);
			group.add(b);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			this.setVisible(true);
		}
}
