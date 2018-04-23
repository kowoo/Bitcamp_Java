package interface2;

public class Airconditioner extends Electronic {
	public void turnOn() {
		System.out.println("에어컨을 켭니다.");
	}
	public void turnOff() {
		System.out.println("에어컨을 끕니다.");
	}
	public void work() {
		System.out.println("고장이 났는지 바람이 안부네요");
	}
}
