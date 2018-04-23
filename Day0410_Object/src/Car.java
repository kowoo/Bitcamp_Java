
public class Car {
	/* 상태값
	 * 	색(문자열): color, 현재 속도(정수): speed, 주행 거리(정수): mileage
	 * 동작
	 * 	void speedUp(): 현재 속도를 5증가 시킨다.
	 * 	void speedDown(): 현재 속도를 5감소 시킨다.
	 * 	void printCar: 현재 상태값 출력
	 * 생성자
	 * 기본생성자
	 * 	: 색 = "빨강", 현재 속도 : 0, 주행거리 : 0 초기화
	 * 색, 현재 속도, 주행 거리를 매개변수로 전달 받아서 멤버변수로 초기화하는 생성자 ? 뭐지...
	 * 
	 * 
	 */

	private String color;
	private int speed;
	private int mileage;
	
	//color getter : color를 반환
	public String getColor() {
		return color;
	}
	
	//color setter : color의 값을 저장 (매개 변수로 색을 받아와서 color에 저장
	public void setColor(String c) {
		color = c;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int s) {
		//속도가 150을 넘어가면 150으로 고정하겠다
		if(s>150) {
			s=150;
		}
		speed = s;
	}
	
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int m) {
		//속도가 150을 넘어가면 150으로 고정하겠다
		if(mileage>150000) {
			m=150000;
		}
		mileage = m;
	}
	
	//생성자의 모양은 수식자 클래스이름 () {}
	public Car() {
		//매개변수가 없으면 기본생성자(default Constructor)
		color = "빨강";
		speed = 0;
		mileage = 0;
	}
	public Car(String c, int s, int m) {
		//색, 현재 속도, 주행 거리를 매개변수로 전달 받아서 멤버변수로 초기화하는 생성자
		color = c;
		speed = s;
		mileage = m;
	}
	

	public void speedUp() {
		speed+=5;
	}
	public void speedDown() {
		speed-=5;
	}
	public void printCar() {
		System.out.printf("색상 : %s%n", color);
		System.out.printf("현재 속도 : %d%n", speed);
		System.out.printf("주행 거리 : %d%n", mileage);
	}
	
	public String toString() {
		return "Color : " + color + " Speed : " + speed + " Mileage : " + mileage;
	}
}
