package byteStream_Re;

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
		//BufferedInput/Output 스트림은 데이터 처리 스트림

		FileInputStream fileIn=null;
		FileOutputStream fileOut=null;

		BufferedInputStream bufin=null;
		BufferedOutputStream bufout=null;

		try {
			//fileOut = new FileOutputStream("number.txt");
			bufout = new BufferedOutputStream(new FileOutputStream("number.txt"));
			for(int i=1; i<300; i++) {
				bufout.write(i);
			}
			bufout.flush();
			
			int data;
			bufin = new BufferedInputStream(new FileInputStream("number.txt"));
			while((data=bufin.read())!=-1) {
				System.out.println(data);
			}
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}