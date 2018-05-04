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
		//���Ϳ� �̸�

		//���Ϳ� �߰� ���������� true false�� ��ȯ
		public boolean accept(File f) {

			//���Ϳ� �߰��ҷ��� ������ ���丮��
			if(f.isDirectory() ) {
				return true;
			}

			String s = f.getName();
			int i = s.lastIndexOf('.');
				//.�� index�� �޾Ƽ� 
			if( i>0 && i<s.length() -1) {
				//Ȯ����
				String extension = s.substring(i +1);

				//���� ���ͷ� �Ÿ����� �ϴ� ������
				//.java Ȯ���ڳ� .class Ȯ���ڸ� ������
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

		btnSave = new JButton("����");
		btnOpen = new JButton("�ҷ�����");	
		
		lblState = new JLabel("���������� �Է��� �ּ���~^^~");
	}

	private void addEvent()
	{
		btnSave.addActionListener(this);
		btnOpen.addActionListener(this);
	}

	private void addComponent()
	{
		

		JPanel pnlName = new JPanel();
		pnlName.add(new JLabel("�� ��"));
		pnlName.add(txtName);

		JPanel pnlAge = new JPanel();
		pnlAge.add(new JLabel("�� ��"));
		pnlAge.add(txtAge);

		JPanel pnlAddr = new JPanel();
		pnlAddr.add(new JLabel("�� ��"));
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
			
			lblState.setText(name + "�� �ҷ��Խ��ϴ�.");
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

			//������
			oos.writeObject(p);		

			lblState.setText(name + "�� ����Ǿ����ϴ�.");
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
		new InputPersonJFrame("�������� �Է�");
	}
}
