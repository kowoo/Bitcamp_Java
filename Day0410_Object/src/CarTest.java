
public class CarTest {
 public static void main(String[] args) {
	 // Car 클래스의 외부영역
	 // 클래스 내부와 외부에서의 메서드 호출 방법은 다르다
	 // 내부에서는 멤버메서드의 이름만 호출하면 된다
	 
	 // 외부에서는 객체 먼저 만들고 객체를 통해서 호출
	 Car c = new Car();
	 c.printCar();
	 c.speedDown();
	 
	 // 클래스들은 다양한 종류의 메서드를 가지고 있음
	 // 특정 목적을 가지는 메서드도 있다
	 // getter(접근자), setter(설정자)
	 //: 멤버 변수의 값을 가져오거나, 멤버 변수의 값을 할당할 때 사용하는 메서드
	 
	 //c 객체의 멤버 변수 값 바꾸기
	 //객체안의 변수를 함부로 바꿀 수 없게 만들자 == 캡슐화
	 //color를 볼 수 있게 하자 == getter 사용. (값 수정은 못하지만 사용은 가능)
	 System.out.println(c.getColor());
	 //color를 변경할 수 있게 하자 == setter 사용.
	 c.setColor("파랑");
	 System.out.println(c.getColor());
	 
	 c.setSpeed(200);
	 System.out.println(c.getSpeed());
	 
	 System.out.println(c);
	 	 
 }
}
