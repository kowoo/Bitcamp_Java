package byteStream;
import java.io.IOException;

public class StreamEx1 {
	
	public static void main(String[] args) throws IOException {
		//Stream은 키보드로 부터 입력받을 때도 사용하고, 모니터에 출력할 때도 사용하고 있다
		//이때까지 해오던것들
		//System.in == Standard InputStream(키보드로 부터 입력 받음)
		//Scanner scan = new Scanner(System.in); //여기서 in이 인풋스트림!
		//스캐너 없이 inputStream의 데이터 읽어오기
		//프로그램이 할 일: 키보드로부터 들어오는 입력을 처리
		//Stream에서 데이터를 읽어와서 ASCII Code로 출력
		//만약 읽어온 데이터가 'q', 'Q'라면 출력하지 않고 종료
		//System.in.read(): 표준 입력스트림으로부터 1byte를 읽어옴
		//반환은 int를 반환: 제대로 값을 읽어오면 값을 반환, 읽어오지 못하면 -1을 반환
		
		System.out.println("문자를 입력하세요...");
		int read;
		//읽어온 값이 있으면 계속해서 반복하다가 없으면 반복 종료
		//읽어온 값이 없다 == read() 했을 때 반환 값이 -1인 경우
		while((read=System.in.read())!=-1) {
			//데이터가 있음: Q나 q라면 출력안하고 종료!
			if(read=='\n' || read=='\r')
				continue; //개행문자 입력되면 아무것도 안하고 다음으로 진행
			if(read=='q' || read=='Q') {
				//반복종료
				System.out.println("종료합니다.");
				break;
			}
			char c = (char)read;
			System.out.print("["+c+"] = "+read);
			
		}
	}
}
