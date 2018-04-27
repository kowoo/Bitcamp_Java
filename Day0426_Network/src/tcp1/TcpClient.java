package tcp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	public static void main(String[] args) {
		//연결요청을 하는 쪽
		//Client가 할 일
		//프로그램이 시작되면 Server에 연결 요청!
		//연결이 되면 데이터 준비 및 전송		
		Socket socket = null;
		try {
			//소켓 객체를 ip와 port를 입력하여 생성하는것도 연결 요청을 하는 것이다.
			//Socket(서버 ip, 서버 port)
			socket = new Socket("192.168.0.55", 5001);
			//요청이 수락되면 소켓을 통해서 데이터를 전송한다
			//데이터는 소켓 내부의 스트림을 이용해서 전송!
			
			//서버가 보내는 메시지를 BufferedReader를 이용해서 받자
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			//스트림을 통해서 들어오는 문자열 읽기
			String msg = reader.readLine();
			System.out.println("서버메시지: "+msg);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
