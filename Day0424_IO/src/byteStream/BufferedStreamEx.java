package byteStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamEx {
	public static void main(String[] args) {
		//데이터 처리 스트림 예제1
		
		//데이터 처리 스트림: 데이터 소스에서 값을 가져오거나 쓰는게 아니라
		//				  데이터를 받아서 쓰기 편하게 만들어주는 역할!
		//데이터 처리 스트림 중 Buffered(Input/Output)Stream
		//파일에 숫자 1부터 300까지 작성
		//파일에 작성된 내용을 읽어와 보자
		//파일에 내용을 작성할 것이기 때문에 File(Input/Output)Stream이 필요하다.

		//파일 input/output 스트림은 데이터 싱크 스트림
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		//BufferedInput/Output 스트림은 데이터 처리 스트림
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		//반복문 돌면서 파일에 숫자 쓰기
		
		try {
			fos = new FileOutputStream("number.txt");
			//조금 더 효율적으로 사용하기 위해서 Buffered스트림을 이용하여 데이터를 보낸다.
			bos = new BufferedOutputStream(new FileOutputStream("number.txt")); //데이터 싱크 스트림을 처리 스트림과 같이 쓰고 싶다면 이렇게, 하지만 이러면 두줄!
			//버퍼의 크기 4096 byte
			
			for(int i=1; i<=300; i++) {
				//파일에 숫자를 씀
				//BufferedOutputStream를 이용해서 데이터 쓰기
				//버퍼에 데이터를 담아뒀다가 꽉차면 스트림으로부터 내 보낸다
				bos.write(i);
			}
			//다 작성하고나서 버퍼를 비워주는 작업을 해야한다.
			bos.flush(); //버퍼 비워주기
			
			//파일에 써져있는 데이터를 다시 읽어오기
			//fis = new FileInputStream("number.txt");
			//데이터 싱크 스트림으로부터 데이터 읽어오기
			bis = new BufferedInputStream(new FileInputStream("number.txt")); //보통은 이런식으로 씀. 이러면 한줄!
			
			int data;
			while((data=bis.read()) != -1) {
				System.out.println(data);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		
	}
}
