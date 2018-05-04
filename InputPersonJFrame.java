import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InputPersonJFrame extends JFrame implements ActionListener 
{
	JTextField txtName;
	JTextField txtAge;
	JTextField txtAddr;

	JButton btnSave;
	JButton btnOpen;

	JLabel lblState;

	class DataFilter extends javax.swing.filechooser.FileFilter {
		final static String ext_data = "dat";
		final static String DESCRIPTION = "DataFile(.dat)";
		//필터에 이름

		//필터에 추가 가능한지를 true false로 반환
		public boolean accept(File f) {

			//필터에 추가할려는 파일이 디렉토리면
			if(f.isDirectory() ) {
				return true;
			}

			String s = f.getName();
			int i = s.lastIndexOf('.');
				//.에 index를 받아서 
			if( i>0 && i<s.length() -1) {
				//확장자
				String extension = s.substring(i +1);

				//현재 필터로 거르려고 하는 파일이
				//.java 확장자나 .class 확장자를 가지면
				if( ext_data.equalsIgnoreCase(extension))
					return true;
			}
			return false;
		}

		public String getDescription() {
			
			return DESCRIPTION;
		}
	}

	

	InputPersonJFrame(String title)
	{
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponent();
		this.addEvent();
		this.addComponent();
		this.setBounds(200,200,200,200);
		//this.setLocation(200,200);
		//this.pack();
		this.setVisible(true);
	}
	private void initComponent()
	{
		txtName = new JTextField(10);
		txtAge = new JTextField(10);
		txtAddr = new JTextField(10);

		btnSave = new JButton("저장");
		btnOpen = new JButton("불러오기");	
		
		lblState = new JLabel("인적사항을 입력해 주세요~^^~");
	}

	private void addEvent()
	{
		btnSave.addActionListener(this);
		btnOpen.addActionListener(this);
	}

	private void addComponent()
	{
		

		JPanel pnlName = new JPanel();
		pnlName.add(new JLabel("이 름"));
		pnlName.add(txtName);

		JPanel pnlAge = new JPanel();
		pnlAge.add(new JLabel("나 이"));
		pnlAge.add(txtAge);

		JPanel pnlAddr = new JPanel();
		pnlAddr.add(new JLabel("주 소"));
		pnlAddr.add(txtAddr);

		JPanel pnlBtn = new JPanel();
		pnlBtn.add(btnOpen);
		pnlBtn.add(btnSave);

		JPanel pnlAll = new JPanel(new GridLayout(4,1));
		pnlAll.add(pnlName);
		pnlAll.add(pnlAge);
		pnlAll.add(pnlAddr);
		pnlAll.add(pnlBtn);

		this.getContentPane().add(pnlAll);
		this.getContentPane().add(lblState, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent ae)
	{
		JButton btn = (JButton)ae.getSource();

		JFileChooser chooser = new JFileChooser(".");
		chooser.addChoosableFileFilter(new DataFilter());
		

		if(btn == btnOpen)
		{
			chooser.showOpenDialog(this);
			
			if()
			{
				File f = chooser.getSelectedFile(); 
				this.openEvent(f.getName());
			}
			else if()
			{
			}
			
		}
		else if(btn == btnSave)
		{
			chooser.showSaveDialog(this);
			File f = chooser.getSelectedFile(); 
			this.saveEvent(f.getName());

			txtName.setText("");
			txtAge.setText("");
			txtAddr.setText("");
		}
	}

	private void openEvent(String name)
	{
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try
		{
			
			fis = new FileInputStream(name);
			ois = new ObjectInputStream(fis);

			Person p = (Person)ois.readObject();

			txtName.setText(p.getName());
			txtAge.setText(Integer.toString(p.getAge()));
			txtAddr.setText(p.getAddr());
			
			lblState.setText(name + "이 불러왔습니다.");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				ois.close();
			}
			catch(IOException ie)
			{
			}

			try
			{
				fis.close();
			}
			catch(IOException ie)
			{
			}
		}
	}

	private void saveEvent(String name)
	{
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try
		{
			
			fout = new FileOutputStream(name);
			oos = new ObjectOutputStream(fout);

			Person p = new Person(txtName.getText(), 
									Integer.parseInt(txtAge.getText()),
									txtAddr.getText());		

			//마샬링
			oos.writeObject(p);		

			lblState.setText(name + "에 저장되었습니다.");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				oos.close();
			}
			catch(IOException ie)
			{
			}

			try
			{
				fout.close();
			}
			catch(IOException ie)
			{
			}
		}
	}
	public static void main(String[] args) 
	{
		new InputPersonJFrame("인적사항 입력");
	}
}
