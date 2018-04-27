package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Server {
	//쓰레드로 만들 필요는 없다
	//얘가 하는 역할은 동시에 작업할 일이 없기 때문이다.
	//받고 나서 보내는게 역할임.
	public static void main(String[] args) {
		//메시지를 주고 받기 위한 소켓
		//메시지를 전달하기 위해서 IP주소의 모음이 필요하다.
		
		Set<InetAddress> ipSet = new HashSet<InetAddress>();
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(5500);
			byte[] buf = null;
			DatagramPacket packet = null;

			while(true) {
				buf = new byte[512];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				//데이터를 받고 나면, 데이터를 다른 클라이언트들에게 전송한다.
				//전송을 위해서는 ip주소를 알아야한다!
				//메시지를 받을 때, 해당 ip주소를 저장하면 된다.
				//하지만 중복검사가 없으면 중복이 발생하므로 set을 이용해서 중복을 차단하는게 좋다!
				ipSet.add(packet.getAddress());
				//ipSet에 들어있는 ip목록에다가 받은 메시지를 하나씩 전달하면 된다.
				//Set안에 있는 요소를 조회하기 위해서는 Iterator이 필요하다.
				Iterator<InetAddress> it = ipSet.iterator();

				while(it.hasNext()) {
					//Set 요소를 하나씩 가져온다.
					InetAddress ip = it.next();
					DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, ip, 5500);
					socket.send(sendPacket);
				}
			}	
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(socket!=null) {
				socket.close();
			}
		}




	}




}