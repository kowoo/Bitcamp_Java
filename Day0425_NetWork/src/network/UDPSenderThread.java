package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class UDPSenderThread implements Runnable{
	Server server;
	public void run() {
		//소켓으로 부터 들어오는 데이터를 출력
		try {
			//패킷을 내보내야 하기 때문에 데이터를 내보낼 소켓을 준비한다
			//UDP 방식에서 소켓은 DatagramSocket
			DatagramSocket socket = new DatagramSocket();
			//데이터를 보낼 목적지의 ip주소를 저장할 객체
			
			
			//내용을 확인해야 할 일이 있다! >> Iterator를 이용
			//Iterator : 하나씩, 모든 요소에 대해서 반복하면서 요소를 가져다준다.
			Iterator<InetAddress> it = server.ip.iterator();
			//hasNext(): 다음 수가 있다면 트루!
			//데이터를 내보낼 데이터패킷의 참조 변수 선언
			DatagramPacket packet=null;
			
			//데이터를 담을 byte[] 준비
			byte[] buf;
			//키보드로부터 입력을 반복해서 받는다

			Scanner scan = new Scanner(System.in);
			while(true) {
				InetAddress ia = (InetAddress)it;
				String msg = scan.nextLine();
				if(msg.equals("quit")) {
					break;
				}
				buf = msg.getBytes();
				//패킷 만들고 통로(socket)를 통해 전송
				packet = new DatagramPacket(buf, buf.length, ia, 5000); //데이터, 데이터의 길이, 호스트, 포트번호
				socket.send(packet); //  つ ◕_◕ ༽つ!! つ ◕_◕ ༽つ!!! つ ◕_◕ ༽つ!!!! つ ◕_◕ ༽つ!!!!! つ ◕_◕ ༽つ!!!!!!
	
				while(it.hasNext()) {
					InetAddress inet = it.next();
				}
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
	//UDP 방식으로 데이터를 보내는 프로그램
	//1. 목적지의 ip 주소와 port번호가 필요하다.
	//2. 데이터를 DatagramPacket에 담을 준비
	//3. IP와 port정보를 저장
	//4. 데이터 전송(데이터가 나가는 통로: DatagramSocket}
	//5. 전송할 데이터는 byte[]로 준비
}
