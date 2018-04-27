package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		//InetAddress 클래스 사용해보기
		//IP주소를 저장하는 클래스
		
		//객체를 만들어 낼 때 factory method를 이용한다.
		//factory method: getInstance, getXX()의 형태로 객체를 반환하는 메서드
		InetAddress ia=null;
		InetAddress ia1=null;
		InetAddress ia2=null;
		
		
		try {
			//현재 컴퓨터의 ip주소를 가지고 있는 객체를 얻어오자!
			ia = InetAddress.getLocalHost();
			System.out.println("IP: "+ia.getHostAddress());
			System.out.println("호스트 이름: "+ia.getHostName()); //컴퓨터 이름
			
			//url을 이용해서 ip객체 얻어오기
			ia1 = InetAddress.getByName("www.naver.com");
			System.out.println("Naver IP: "+ ia1.getHostAddress());
			InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
			
			for(InetAddress i: ipArr) {
				System.out.println("IP: "+i.getHostAddress());
				System.out.println("호스트 이름: "+i.getHostName());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
