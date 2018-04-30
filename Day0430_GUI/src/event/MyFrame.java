/*package event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements KeyListener{
	private JButton btnEvent; 
	private JTextField tfDollar;
	private JLabel lblResult;
	JLabel lblIntro;
	public MyFrame() {
		this.setTitle("이벤트 처리");
		this.setSize(300, 200);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//JButton btnNewButton = new JButton("New button"); //원래 이렇게 되어있지만 멤버변수로 하는게 사용할때 편하다.
		btnEvent = new JButton("이벤트 발생!");
		btnEvent.setBounds(88, 113, 122, 38);
		//이벤트 처리를 위해서는 컴포넌트에 Listener를 등록해야한다.
		//Action이벤트를 처리하기 위해서는 ActionListener를 달아주면 된다.
		//Key이벤트를 처리하기 위해서는 ActionListener를 달아주면 된다.
		//Mouse이벤트를 처리하기 위해서는 ActionListener를 달아주면 된다.
		
		//addActionListener(리스너 객체);
		//리스너 객체는 Listener인터페이스로 구현 클래스 객체를 넣어주면 된다.
		//익명클래스로 Listener인터페이스를 구현해서 인자로 넘겨주면 된다는 뜻.
		btnEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//여기다가 btnEvent 버튼이 눌리면 동작할 코드를 작성한다.
				
//				System.out.println(e.getActionCommand());
//				System.out.println("버튼 이벤트 발생!!");
				//버튼이 눌리면 해야할 일
				//textField에 있는 문자열 가져와서 1067을 곱해서 lblResult에 저장
				
				String dollar = tfDollar.getText();
				int dolloarInt = Integer.parseInt(dollar);
				int result = dolloarInt*1067;
				
				lblResult.setText(result+"원 입니다.");
				
				
			}			
		});
		
		panel.add(btnEvent);
		

		tfDollar = new JTextField();
		tfDollar.setBounds(30, 40, 180, 30);
		panel.add(tfDollar);
		
		//키보드 이벤트 처리를 위해 KeyListener 등록
		tfDollar.addKeyListener(this); //소괄호에는 임플리먼츠를 구현한 클래스가 필요함.
		
		lblIntro = new JLabel("달러를 입력하세요");
		lblIntro.setBounds(30, 10, 143, 20);
		panel.add(lblIntro);
		
		lblResult = new JLabel("계산하세요.");
		lblResult.setBounds(73, 80, 158, 23);
		panel.add(lblResult);
		this.setVisible(true);
		
	}
	
	

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		
		class MyKeyListener implements KeyListener {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// 키를 눌렀을 때
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// 키가 올라왔을 때
				System.out.println("키보드가 올라옴!!");
				
				//키보드가 올라왔을 때 처리
				//System.out.println("키보드가 올라옴!!");
				//그냥 keyRelease 이벤트를  처리하면, 모든 키가 올라올때 처리
				//우리가 하려는 것은 엔터를 쳤을 때 textField에 있는 값을 처리 하는일
				//눌려진 키가 엔터인지 아닌지 확인하는 작업이 필요
				//어떤 키보드가 눌려졌는 지에 관한 정보는 이벤트 객체가 가지고 있다.
				// e.getKeyCode(): 어떤 키를 눌렀는지에 관한 정보를 가져온다.
				//System.out.println(e.getKeyCode());
				//엔터는 10 ==> KeyEvent.VK_ENTER
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					//엔터가 눌려졌다가 떼지면 얘가 해야할일 
					String dollar = tfDollar.getText();
					int dolloarInt = Integer.parseInt(dollar);
					int result = dolloarInt * 1067;
					lblResult.setText(result + "원 입니다.");
				}
				
				
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				// 키가 내려갔다가 올라왔을 때, 사실상 키 릴리즈와 같다고 보면 된다.
				
			}
		}
			
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
*/