package byteStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		//파일 읽어와서 그대로 다른 파일에 쓰면 됨.
		//buffer를 이용해보자 (데이터 바구니): 한꺼번에 많은 데이터를 읽어오기 위해 사용
		//FileInputStream에서 많은 데이터를 한꺼번에 읽어오기 위해서는
		//byte[]을 이용하면 된다.
		byte[] buffer = new byte[512];
		
		System.out.println(10269%512); // 29가 남네?!
		//마지막 짜투리를 위해서 읽어온 데이터의 길이가 필요하다.
		int readLength;
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		
		try {
			fis = new FileInputStream("ham.jpg");
			fos = new FileOutputStream("ham_copy.jpg");
			while((readLength = fis.read(buffer)) != -1) {
				//읽어왔으면 데이터는 buffer에 들어있다.
				//읽은 길이는 readLength에 들어있다.
				
				//buffer에 있는 내용을 모두 파일에 작성.
				//fos.write(buffer);
				//이렇게 되면 마지막에 남는 짜투리 29가 이상하게 저장된다
				//[o][o][o][o][x][x][x][x][x][x][x]이런식으로 o는 마지막 부분이지만 x는 이전 부분이 저장되버림. 왜? 뒤에 값이 없으니까 이전에 저장된 것들이 남아있으므로.
				
				//필요없는 내용이 같이 써질 수 있기 때문에 읽어온 만큼만 쓰기
				fos.write(buffer,0,readLength);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
