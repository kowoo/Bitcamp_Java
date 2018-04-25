package byteStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		//문장을 파일에 작성하기
		String msg = "Hello!! FileOutputStream???!!!";
		FileOutputStream fos = null;

		//사용할 메서드는 write()
		//FileOutStream은 byteStream 이기 때문에
		//데이터 처리 단위가 byte..데이터를 넘겨줄때도 byte로 넘겨줘야함
		//문자열>>>byte[] 형태로 바꾸어서 전달해야 한다.
		//String 클래스의 getBytes() 메서드 사용해서 byte[] 얻어옴
		
		
		try{
			fos = new FileOutputStream("src/data.txt");
			byte[] bytes = msg.getBytes();
			fos.write(bytes);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {				
				if(fos !=null) fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
