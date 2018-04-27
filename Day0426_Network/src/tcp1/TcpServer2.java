package tcp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TcpServer2 {
	public static void main(String[] args) {
		// 연결요청을 받는 쪽
		// Server가 할 일
		// 1. 요청을 기다리다가 요청이 들어오면 수락(Socket 생성): ServerSocket
		// 2. 소켓이 생성되면 메시지 보내기

		// 요청을 받을 서버소켓 생성
		// 요청을 받고 나서 연결이 되면 생성될 소켓을 저장할 변수
		Socket socket = null;
		ServerSocket serverSocket = null;
		try {

			serverSocket = new ServerSocket(5001);
			
			// 요청 기다리기 및 수락
			System.out.println("연결 대기 중...");
			socket = serverSocket.accept();

			InputStream in = socket.getInputStream(); // 데이터를 받기 위해 필요한 녀석임.
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			// 여기까지 오면 이미 연결이 된 상태이므로 Client에 인사말을 보내보자
			OutputStream out = socket.getOutputStream(); // 얘는 바이트, 버퍼는라이터는 문자열 스트림이므로 바꿔줄 녀석이 있어야함!
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

			while (true) {
				String msg = reader.readLine();
				System.out.println("클라이언트 메시지: " + msg);

				writer.write(msg);
				writer.newLine();
				writer.flush();
				
				if(socket.isClosed()) {
					break;
				}

			}
			System.out.println("서버 종료");
			

		} catch(SocketException e) {
			System.out.println("클라이언트와 연결이 끊겼습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
