package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class EventFrame extends JFrame {
	//사용자의 특정한 행동을 이벤트라고 부른다.
	//이벤트가 일어났을 때 결과를 내보내 주는 것을 이벤트처리라고 한다.
	//이벤트 중 컴포넌트를 조작하는 행위: Action (버튼 클릭, 글자 입력, 목록 선택 같은 행위들)
	//Action을 처리하는 인터페이스 ActionListener
	JButton button;
	JButton button2;
	boolean isClicked;
	String name = "홍길동";

	public EventFrame() {
		isClicked = false;
		this.setTitle("이벤트 처리");
		this.setSize(300, 200);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

		button = new JButton("눌러봐!");
		button.setBounds(12, 10, 97, 23);
		panel.add(button);

		//버튼이 눌리는 액션이 발생하면, MyActionListener에 구현한 코드를 실행한다
		button.addActionListener(new MyActionListener());
		panel.add(button);
		
		button2 = new JButton("네 이름이 뭐니?");
		button2.setBounds(121, 10, 151, 23);
		panel.add(button2);
		
		JLabel lblName = new JLabel("New label");
		lblName.setBackground(Color.BLACK);
		lblName.setBounds(22, 43, 238, 97);
		panel.add(lblName);
		
		//액션리스너 처리할 때는 보통 익명 클래스를 사용한다.
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblName.setText(name);
				
			}
		});
		

		this.setVisible(true);
	}

	public static void main(String[] args) {
		EventFrame frame = new EventFrame();

	}

	//버튼이 눌리는 액션을 처리하기 위해서 액션리스너를 작성
	//ActionListener를 구현하는 구현 클래스 만들기
	//버튼이 눌리는 Action이 일어나면 처리하기
	//1. 액션이 일어났을떄 동작할 코드 작성하기 == ActionListener 구현하기
	//2. 액션을 처리하고 싶은 컴포넌트에 ActionListener 달아주기

	class MyActionListener implements ActionListener  {
		@Override

		public void actionPerformed(ActionEvent e) {

			if(isClicked == false) {
				button.setText("눌러봐!");
				isClicked = true;
			} else {
				button.setText("누르지마!");
				isClicked = false;
			}

			//			if(button.getText().equals("누르지마!")) {
			//				button.setText("눌러봐!");
			//			} else {
			//				button.setText("누르지마!");
			//			}
		}


	}

}
