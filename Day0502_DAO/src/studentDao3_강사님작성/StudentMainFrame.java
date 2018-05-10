package studentDao3_강사님작성;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StudentMainFrame extends JFrame{
	private JTextField tfName;
	private JTextField tfGrade;
	private JTextField tfSnum;
	private JButton btnDetail;
	private JButton btnSelect;
	private JList<Student> studentJList; //목록을 화면에 보여주는 컴포넌트
	
	//데이터를 읽어오기 위해서 DAO 객체가 필요
	private StudentDao dao;
	
	//학생리스트 보여주고 선택하여 기본정보를 보여주는 화면
	//데이터: 학생리스트  >>실제학생 정보를 가지고 있는 리스트 객체
	private Vector<Student> sList;
	
	public StudentMainFrame() {
		this.setTitle("학생관리");
		this.setSize(489,354);
		
		//기본데이터 생성 및 sList에 데이터 넣기
		setDefaultData();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//학생 목록을 화면에 보여줄 컴포넌트 
		studentJList = new JList<Student>(sList);
		studentJList.setBounds(33, 29, 187, 234);
		//기본 선택값 주기
		studentJList.setSelectedIndex(0);
		panel.add(studentJList);
		
		studentJList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Student student = studentJList.getSelectedValue();
				tfName.setText(student.getSname());
				tfGrade.setText(student.getSgrade()+"");
				tfSnum.setText(student.getSnum()+"");
			}
		});
		
		
		
		btnDetail = new JButton("상세보기");
		btnDetail.setBounds(243, 240, 97, 23);
		
		btnDetail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewFrame();
			}
		});
		panel.add(btnDetail);
		
		btnSelect = new JButton("점수보기");
		btnSelect.setBounds(352, 240, 97, 23);
		panel.add(btnSelect);
		
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//지금 선택된 목록의 학생 객체 가져오기
				Student student = studentJList.getSelectedValue();
				
			}
		});
		
		
		tfName = new JTextField();
		tfName.setBounds(319, 73, 116, 21);
		panel.add(tfName);
		tfName.setColumns(10);
		
		tfGrade = new JTextField();
		tfGrade.setBounds(319, 123, 116, 21);
		panel.add(tfGrade);
		tfGrade.setColumns(10);
		
		tfSnum = new JTextField();
		tfSnum.setBounds(319, 173, 116, 21);
		panel.add(tfSnum);
		tfSnum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(250, 76, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("학년");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(250, 126, 57, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("번호");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(250, 176, 57, 15);
		panel.add(lblNewLabel_2);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		StudentMainFrame mainFrame = new StudentMainFrame();
	}
	//임의의 데이터를 만들어주는 메서드 작성
	public void setDefaultData() {
		
		//데이터 읽어오기
		dao = new StudentDao();
		//DB에서 데이터 읽어오기
		List<Student> studentList = dao.selectAll();
		
		//DB에서 읽어온 데이터로 Vector 만들기
		sList = new Vector<Student>(studentList);
		
	}
	
}
