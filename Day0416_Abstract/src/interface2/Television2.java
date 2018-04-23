package interface2;

public class Television2 extends Electronic implements RemoteController2 {
	public void turnOn() {
		System.out.println("켜져!");
	}
	public void turnOff() {
		System.out.println("꺼져?!");
	}
	public void work() {
		System.out.println("TV가 파업했어ㅠㅠ");
	}
}
