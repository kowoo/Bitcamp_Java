package byteStream_Re;

import java.io.IOException;

public class StreamEx1 {
	
	public static void main(String[] args) throws IOException{
		//1. 스캐너없이 데이터 읽어오기 (영문자!)
		//2. 데이터를 읽어와서 아스키코드로 출력
		//3. 읽어온 데이터가 q, Q면 종료
		// System.in.read()를 이용하자.
		//표준입력스트림으로부터 1byte를 읽어옴
		//int를 반환한다. (읽어온 값이 있으면 값, 없으면 -1)
		
		System.out.println("문자를 입력하세요!");
		int read;
		
		while((read = System.in.read()) != -1) {
			if(read=='\n' || read=='\r') continue;
			if(read=='q' || read=='Q') {
				System.out.println("종료합니다!");
				break;
			}
			char c = (char)read;
			System.out.println("["+c+"] = "+read);
		}
		
		
		
	}
}