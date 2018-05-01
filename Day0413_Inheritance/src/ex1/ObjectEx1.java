package ex1;

public class ObjectEx1 {
	public static void main(String[] args) {
		//자식클래스의 객체를 부모클래스의 참조변수에 참조 시키기 / 형변환
		
		Car c1 = new SportsCar();
		Car c2 = new Bus();
		
		if(c2 instanceof Bus) {
			System.out.println("맞아요!");
			Bus bus = (Bus)c2;
			bus.switchGate();
		} else if(c2 instanceof SportsCar) {
			System.out.println("아니에요!");
			SportsCar sc = (SportsCar)c1;
			sc.turboOff();
			sc.turboOn();
		}
	}
}
