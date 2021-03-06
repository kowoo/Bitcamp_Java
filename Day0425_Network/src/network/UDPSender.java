package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPSender {
	public static void main(String[] args) {
		//UDP 방식으로 데이터를 보내는 프로그램
		//1. 목적지의 ip 주소와 port번호가 필요하다.
		//2. 데이터를 DatagramPacket에 담을 준비
		//3. IP와 port정보를 저장
		//4. 데이터 전송(데이터가 나가는 통로: DatagramSocket}
		//5. 전송할 데이터는 byte[]로 준비

		try {
			//패킷을 내보내야 하기 때문에 데이터를 내보낼 소켓을 준비한다
			//UDP 방식에서 소켓은 DatagramSocket
			DatagramSocket socket = new DatagramSocket();
			//데이터를 보낼 목적지의 ip주소를 저장할 객체
			InetAddress ia = InetAddress.getByName("192.168.0.55");
			//데이터를 내보낼 데이터패킷의 참조 변수 선언
			DatagramPacket packet=null;
			//데이터를 담을 byte[] 준비
			byte[] buf;
			//키보드로부터 입력을 반복해서 받는다

			Scanner scan = new Scanner(System.in);
			while(true) {
				String msg = scan.nextLine();
				if(msg.equals("quit")) {
					break;
				}
				buf = msg.getBytes();
				packet = new DatagramPacket(buf, buf.length, ia, 5500); //데이터, 데이터의 길이, 호스트, 포트번호
				//패킷 만들고 통로(socket)를 통해 전송
				socket.send(packet);
				socket.send(packet);
				socket.send(packet);
				socket.send(packet);
				socket.send(packet);
				socket.send(packet);
				socket.send(packet);
				socket.send(packet);
				socket.send(packet);
				socket.send(packet);
				socket.send(packet);
				socket.send(packet);			
			}


		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
