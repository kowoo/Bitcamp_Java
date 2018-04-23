

public class Car {
	protected int speed;
	public int mileage;
	private String color;
	
	
	//공통 데이터
	static final String MODEL = "쏘나타";
	//바뀌지 않는 값이기 때문에 대문자 변수명
	
	//현재 만들어진 객체가 몇개인지 체크하는 변수
	static int numOfCars;
	
	public Car() {
		System.out.println("부모 클래스 생성자 호출!!");
		numOfCars++;
		speed = 100;
	}
	
	public static void printNumOfCars() {
		System.out.println(numOfCars);
		// System.out.println(color);
		// Cannot make a static reference to the non-static field color라는 오류메시지가 나옴.
		// color는 static변수가 아니므로 사용이 안됨. (어느 color를 지칭하는지 알 수가 없기 때문이라던가 기타 이유때문에 non-static은 사용할 수 없다)
	}
	
	public void speedUp() {
		if (speed>=150) {
			System.out.println("최대 속도 입니다!");
		} else {
			speed+=10;
			System.out.println("속도가 증가합니다.");
		}
		
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [speed=" + speed + ", mileage=" + mileage + ", color=" + color + "]";
	}
	
}