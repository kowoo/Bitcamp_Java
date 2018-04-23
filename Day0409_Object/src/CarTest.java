
public class CarTest {
	public static void main(String[] args) {
		//색(문자열), 현재 속도(정수), 주행 거리(정수)의 상태값을 가지고
		//출발, 정지, 상태 출력이 가능한 객체 만들기.
		//car객체를 만들어서 객체가 가지고 있는 출발, 정지, 상태출력 기능을 호출

		//객체를 만들기 위해 클래스를 생성하자. (Car)
		//만들어 놓은 클래스를 활용하기 위해서는 객체가 필요하다.
		//객체를 만들기 위해 new 키워드를 사용 (new == 객체를 만들어주는 메서드)
		//new 클래스이름();
		//자바에서 프로그래밍 할 때 값을 꺼내서 사용하려면 변수가 필요하다.
		//객체 == 상태값과 동작을 실제로 가지고 있음
		//인스턴스 == 객체가 참조되어 있는 변수
		Car myCar; //객체를 참조할 참조변수 선언
		myCar = new Car(); //객체 생성 및 참조 변수에 객체 참조
		
		Car yourCar = new Car();
		yourCar.color = "검정";
		yourCar.speed = 150;
		yourCar.mileage = 250000;
		
		myCar.color = "빨강";
		myCar.speed = 180;
		myCar.mileage = 2000;
		
		myCar.printCar();
		yourCar.printCar();
		
//		myCar.start(); //객체 기능 실행(메서드 호출)
//		myCar.stop();
//		myCar.printCar();
	}
}

class Car{
	String color;	// 색을 저장할 변수                                멤버 변수
	int speed; 		// 현재 속도를 저장할 변수
	int mileage;	//주행 거리를 저장할 변수                         여기까지 멤버 변수(==필드)
	//동작 표현을 위해 메소드가 필요하다.
	public void start() {                          //멤버 메서드
		System.out.println("시동을 걸고 출발합니다.");
	}
	public void stop() {
		System.out.println("멈추고 시동을 끕니다.");
	}
	public void printCar() {
		System.out.println("색상 : "+color);
		System.out.println("현재 속도 : "+speed+"km/h");
		System.out.println("주행 거리 : "+mileage+"km"); //여기까지 멤버 메서드(==멤버 함수)
	}
}