package tcp1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) {
		//연결요청을 받는 쪽
		//Server가 할 일
		//1. 요청을 기다리다가 요청이 들어오면 수락(Socket 생성): ServerSocket
		//2. 소켓이 생성되면 메시지 보내기
		
		try {
			//요청을 받을 서버소켓 생성
			ServerSocket serverSocket = new ServerSocket(5001);
			
			//요청을 받고 나서 연결이 되면 생성될 소켓을 저장할 변수
			Socket socket;
			
			//요청 기다리기 및 수락
			System.out.println("연결 대기 중...");
			socket = serverSocket.accept(); 
			
			//여기까지 오면 이미 연결이 된 상태이므로 Client에 인사말을 보내보자
			OutputStream out = socket.getOutputStream(); //얘는 바이트, 버퍼는라이터는 문자열 스트림이므로 바꿔줄 녀석이 있어야함!
			
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			writer.write("안녕하세요!, 안녕히가세요!\n");
			writer.newLine();
			writer.flush();
			
			while(true) {
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
