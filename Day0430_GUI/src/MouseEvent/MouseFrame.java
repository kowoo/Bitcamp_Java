package MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class MouseFrame extends JFrame implements MouseListener, ActionListener{
	JTextArea taMouse;
	JButton btnExit;
	private JScrollPane scrollPane;
	
	public MouseFrame() {
		//마우스가 textArea 영역에 들어오거나 나갈때 마다 textArea에 출력하게 만들기.
		//마우스를 클릭하면 좌표 찍기.
		
		this.setTitle("마우스 이벤트");
		this.setSize(500, 400);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnExit = new JButton("New button");
		btnExit.setBounds(188, 281, 97, 23);
		panel.add(btnExit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 10, 370, 261);
		panel.add(scrollPane);
		
		taMouse = new JTextArea();
		scrollPane.setViewportView(taMouse);
		taMouse.addMouseListener(this);
		
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//마우스 클릭
		taMouse.append("Mouse Clicked....\n");
		taMouse.append("좌표: "+e.getX()+", "+e.getY()+'\n'); //x좌표와 y좌표를 데려옴.
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//마우스가 컴포넌트 영역에 들어가면 발생하는 이벤트
		taMouse.append("Mouse Entered....\n");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//마우스가 컴포넌트 영역에서 빠져나가면 발생하는 이벤트
		taMouse.append("Mouse Exit....\n");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//마우스 버튼을 누르는 이벤트
		taMouse.append("Mouse Pressed....\n");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//마우스 버튼을 떼는 이벤트
		taMouse.append("Mouse Released....\n");
	}
	
	public static void main(String[] args) {
		MouseFrame frame = new MouseFrame();
	}
}
