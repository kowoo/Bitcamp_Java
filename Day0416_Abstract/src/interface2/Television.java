package interface2;

public class Television extends Electronic {
	//interface를 상속받았기 때문에
	//abstract 메소드를 포함하고 있는 것과 같다.
	//미완성인 메서드를 포함하고 있으면 클래스를 완성할 수 없다. 
	//클래스 완성을 위해서는 2가지 방법이 있다. 
	//abstract를 구현하거나, 자기 자신도 abstract가 되거나...
	public void turnOn() {
		System.out.println("텔레비전을 켭니다.");
	}
	public void turnOff() {
		System.out.println("텔레비전을 끕니다.");
	}
	public void work() {
		System.out.println("아무것도 안나와요");
	}
}
