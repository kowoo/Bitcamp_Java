package byteStream_Re;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamEx {
	public static void main(String[] args) {
		//데이터 처리 스트림 예제2
		//DataInputStream, DataOutputStream
		//byte단위로 데이터를 쓰던 것을
		//자바 기초자료형 데이터로 쓸 수 있게 구현해놓은 스트림
		
		DataInputStream in=null;
		DataOutputStream out=null;
		
		try {
			out = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("data.dat")));			
			in = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream("data.dat")));		
			out.writeInt(100);
			out.writeDouble(3.14);
			out.writeBoolean(false);
			out.writeUTF("Hello!! world!!");
			
			//버퍼가 꽉 차지 않으면 내보내지 않음.
			//버퍼가 꽉 차지 않아도 현재 버퍼에 있는 내용을 내보내기 위해서 flush()를 호출
			out.flush(); // 이거 안넣으면 오류발생
			
			//쓴 순서대로 저장이 되기 때문에 읽어 올 때 도 저장한 순서대로 읽어야한다.
			int intNum = in.readInt();
			double doubleNum = in.readDouble();
			boolean bool = in.readBoolean();
			String str = in.readUTF();
			
			//화면에 출력할 때는 순서 상관없음~
			System.out.println(doubleNum);
			System.out.println(intNum);
			System.out.println(bool);
			System.out.println(str);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
