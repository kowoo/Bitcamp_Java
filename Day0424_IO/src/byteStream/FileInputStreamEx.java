package byteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) {
		//표준입력스트림(System.in): 키보드로부터 데이터를 읽어옴
		//FileInputStream: 파일로부터 데이터를 읽어온다.
		
		FileInputStream fis=null; //선언은 try밖에서 해주는게 좋다! 왜냐하면 트라이 안에서 선언하면 블록 벗어나면 끝이잖아
		try {
			fis = new FileInputStream("data.txt");
			int data;
			while((data=fis.read()) != -1) {
				System.out.print((char)data);
			}
		}catch(FileNotFoundException e) {
			System.out.println("파일이 없어요!");
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			//우리가 사용한 자원 닫아주기
			try {
				if(fis!=null) fis.close();//finally 구문이 너무 길기 때문에 중괄호를 생략하는 경우가 많다.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
