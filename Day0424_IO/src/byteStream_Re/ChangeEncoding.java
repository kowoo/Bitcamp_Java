package byteStream_Re;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class ChangeEncoding {
	//문서 인코딩 방법 바꾸기
	public static void main(String[] args) {
		//UTF-8로 작성된 문서를 읽어서 MS949방식의 인코딩으로 바꾸어서 복사
		
		//1. 파일 읽어오기 위해서 FileInputStream, 쓰기 위해서 FileOutputStream
		//2. InputStreamReader, OutputStreamWriter
		//3. BufferedReader, BufferedWriter
		
		BufferedReader in=null;
		BufferedWriter out=null;
//		new InputStreamReader(스트림,"UTF-8");
		
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("test.java"), "UTF-8"));
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test_copy.java"), "MS949"));
			int readChar;
			while((readChar=in.read()) != -1) {
				//읽어왔으니 출력함!
				out.write(readChar);
			}
			out.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
