package d03;

public class Gundam extends Robot {
	String name;
	public Gundam(Attackable attack, Moveable move) {
		this.name = "건담";
		this.attack = attack; // 의존성 주입, 제어 역전이라고 한다.
		this.move = move;
		super.name = "담담"; //일반적으로 멤버 변수로 네임을 선언하면 부모클래스의 네임 변수에 접근을 못하게 된다. 하지만 super.을 이용한다면 부무클래스의 네임 변수에 접근 가능.
	}
//	public void attack() {
//		attack.attack();
//	}
//	public void move() {
//		move.move();
//	}
}
