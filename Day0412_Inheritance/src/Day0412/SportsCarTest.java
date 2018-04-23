package Day0412;

import Day0412_1.SportsCar;

public class SportsCarTest {
	public static void main(String[] args) {
		SportsCar myCar = new SportsCar();
		
		myCar.setColor("빨강");
		myCar.setSpeed(100);
		myCar.speedUp();
		System.out.println(myCar);
		
		myCar.turboOn();
		System.out.println(myCar.getSpeed());
	}
}
