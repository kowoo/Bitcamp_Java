package tcp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient2 {
	public static void main(String[] args) {
		// 연결요청을 하는 쪽
		// Client가 할 일
		// 프로그램이 시작되면 Server에 연결 요청!
		// 연결이 되면 데이터 준비 및 전송
		Socket socket = null;
		Scanner scan = new Scanner(System.in);
		try {
			// 소켓 객체를 ip와 port를 입력하여 생성하는것도 연결 요청을 하는 것이다.
			// Socket(서버 ip, 서버 port)
			socket = new Socket("192.168.0.55", 5001);
			// 요청이 수락되면 소켓을 통해서 데이터를 전송한다
			// 데이터는 소켓 내부의 스트림을 이용해서 전송!

			// 서버가 보내는 메시지를 BufferedReader를 이용해서 받자
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			// 인&아웃풋 스트림은 바이트, 버퍼는라이터는 문자열 스트림이므로 바꿔줘야함!
			OutputStream out = socket.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

			while (true) {
				String outMsg = scan.nextLine();
				writer.write(outMsg);
				writer.newLine();
				writer.flush();

				if (outMsg == "quit") {
					break;
				}

				// 스트림을 통해서 들어오는 문자열 읽기
				String msg = reader.readLine();
				System.out.println("반사: " + msg);
			}
			System.out.println("클라이언트 종료");
			socket.close();
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
