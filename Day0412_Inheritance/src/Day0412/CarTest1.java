package Day0412;

public class CarTest1 {
	public static void main(String[] args) {
		Car myCar = new Car();
		Car yourCar = new Car();
		
		myCar.setColor("빨강");
		yourCar.setColor("파랑");
		
		//static 변수는 객체당 만들어지는 변수가 아님(1개의 변수로 돌려쓰는거)
		//그러므로 객체 이름으로 접근하는 방식을 권장하지 않는다.
		//그래서 The static field Car.MODEL should be accessed in a static way라는 메시지가 나옴
//		System.out.println(myCar.MODEL);
//		System.out.println(yourCar.MODEL);
		
		System.out.println(Car.MODEL); //이런 접근 방식을 권장한다.
		System.out.println(Car.numOfCars);
		
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		yourCar.speedUp();
		
		Car.printNumOfCars();
		myCar.speed = 100;
		
		//double a = Math.random();
	}
}
