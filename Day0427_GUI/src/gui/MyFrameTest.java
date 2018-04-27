package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrameTest {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
		
	}
}

class MyFrame extends JFrame {
	public MyFrame() {
		this.setTitle("내가 만든 프레임");
		this.setSize(560, 420);
		//패널: 다른 컴퍼넌트들을 포함할 컴퍼넌트(컨테이너): JPanel
		
		JPanel panel = new JPanel();
		this.add(panel);
	}
}
