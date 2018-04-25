package readerwriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriter {
	public static void main(String[] args) {
		//문자스트림 예제
		//파일로부터 데이터를 읽어와서 처리
		//FileReader, FileWriter를 사용
		
		FileReader reader=null;
		FileWriter writer=null;
		
		int readChar;
		try {
			reader = new FileReader("test.txt");
			writer = new FileWriter("test_copy.txt");
			
			while((readChar = reader.read()) != -1) {
				//문자열 하나씩 읽어옴! 읽어올 문자열이 없으면 -1을 반환하는 녀석이라 != -1을 넣음.
				//읽어올 문자열을 복사할 파일에 쓰기
				writer.write((char)readChar);
				writer.flush(); //안에 있는 녀석을 지우고 복사해둔걸 집어넣게 만든다.
			}	
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(reader!=null) reader.close();
				if(writer!=null) writer.close();
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
