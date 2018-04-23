package interface2;

public class HomeNetworks {
	public static void main(String[] args) {
		//무선으로 조종할 수 있는 기능을 가진 가전 제품을 조종
		//무선으로 켜고, 끄기 : 무선으로 조작가능한 객체여야 한다.
		//turnOn(), turnOff()

		//RemoteController t = new Television();
		//Aircondition a = new Aircondition();		
		//t.turnOn();
		//a.turnOn();
		//이렇게 하지말고 하나에다가 ㄱㄱ

		Electronic[] r=new Electronic[2];
		r[0] = new Television();
		r[1] = new Airconditioner();

		for(Electronic remote:r) {
			remote.turnOn();
			remote.work();
//			
//			if(remote instanceof Television) {
//				((Electronic)remote).work();
//			}else if(remote instanceof Airconditioner){
//				((Airconditioner)remote).work();
//			}
//			
		}
	}
}
