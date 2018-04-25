package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiverThread implements Runnable {
	Server server;
	Thread sender = new Thread(new UDPSenderThread());
	public void run() {
		//키보드로부터 입력을 받다가 'quit'를 입력받으면 종료
		try {
			//받는 부분은 포트를 미리 점유하고 있어야 한다. 그래야 데이터를 받을 수 있다.
			DatagramSocket socket = new DatagramSocket(5000);
			byte[] buf=null;
			DatagramPacket packet=null;
			//5000번 포트로 들어오는 데이터를 계속 받으면 된다.

			while(true) {
				//패킷 준비하고 socket으로 부터 데이터 받아오기
				System.out.println("데이터 수신 대기 중....");
				buf = new byte[512];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				//데이터를 받아왔으니 출력하자!
				System.out.println(packet.getAddress()+" : "+ new String(buf).trim());
				server.ip.add(packet.getAddress());
				sender.run();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}			
	//UDP 방식으로 데이터를 받는 프로그램
	//1. 데이터를 받기 위해 데이터가 들어오는 통로인 Datagram Socket 준비
	//2. DatagramSocket에는 port만 준비한다.
	//3. DatagramSocket를 통해서 들어오는 데이터를 받기위한 패킷을 준비
	//   DatagramPacket
	//4. 소켓을 통해서 들어오는 패킷 수신		
}
