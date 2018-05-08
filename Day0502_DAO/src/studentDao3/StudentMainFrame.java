package studentDao3;

import java.awt.BorderLayout;
import java.awt.Font;
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

public class StudentMainFrame extends JFrame {

	//학생 리스트를 보여주고 선택하여 기본 정보를 보여주는 화면
	//데이터: 학생리스트 (실제 학생 정보를 가지고 있는 리스트 객체)

	private static final long serialVersionUID = 3639397401352739935L;
	private JTextField tfName;
	private JTextField tfGrade;
	private JTextField tfSnum;
	private JButton btnDetail;
	private JButton btnSelect;
	private JList<Student> studentJList; //화면에 뿌려줄 때 List가 아니라 Vector를 이용한다.

	//데이터를 읽어오기 위해서 DAO객체가 필요하다.
	private StudentDao dao;

	private Vector<Student> sList;

	public StudentMainFrame() {
		this.setTitle("학생관리");
		this.setSize(379, 332);

		setDefaultData();

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		//학생 목록을 화면에 보여줄 컴포넌트
		studentJList = new JList<Student>(sList);
		studentJList.setFont(new Font("돋움", Font.PLAIN, 12));
		studentJList.setBounds(12, 10, 141, 273);
		//기본 선택값 주기. 이렇게하면 첫번째 녀석이 선택된채로 실행된다
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
		btnDetail.setFont(new Font("돋움", Font.PLAIN, 12));
		btnDetail.setBounds(165, 222, 91, 31);
		btnDetail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewFrame();
			}
		});
		panel.add(btnDetail);

		btnSelect = new JButton("점수보기");
		btnSelect.setFont(new Font("돋움", Font.PLAIN, 12));
		btnSelect.setBounds(259, 222, 91, 31);
		panel.add(btnSelect);

		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Student student = studentJList.getSelectedValue();

			}
		});

		tfName = new JTextField();
		tfName.setFont(new Font("돋움", Font.PLAIN, 12));
		tfName.setBounds(234, 70, 116, 21);
		panel.add(tfName);
		tfName.setColumns(10);

		tfGrade = new JTextField();
		tfGrade.setFont(new Font("돋움", Font.PLAIN, 12));
		tfGrade.setBounds(234, 120, 116, 21);
		panel.add(tfGrade);
		tfGrade.setColumns(10);

		tfSnum = new JTextField();
		tfSnum.setFont(new Font("돋움", Font.PLAIN, 12));
		tfSnum.setBounds(234, 170, 116, 21);
		panel.add(tfSnum);
		tfSnum.setColumns(10);

		JLabel lblSname = new JLabel("이름");
		lblSname.setFont(new Font("돋움", Font.PLAIN, 12));
		lblSname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSname.setBounds(165, 73, 57, 15);
		panel.add(lblSname);

		JLabel lblGrade = new JLabel("학년");
		lblGrade.setFont(new Font("돋움", Font.PLAIN, 12));
		lblGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrade.setBounds(165, 123, 57, 15);
		panel.add(lblGrade);

		JLabel lbSnum = new JLabel("번호");
		lbSnum.setFont(new Font("돋움", Font.PLAIN, 12));
		lbSnum.setHorizontalAlignment(SwingConstants.RIGHT);
		lbSnum.setBounds(165, 173, 57, 15);
		panel.add(lbSnum);
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
		//DB에서 읽어온 데이터로 Vector만들기
		sList = new Vector<Student>(studentList);
	}

}
