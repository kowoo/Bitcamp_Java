package d03;

public class Transformer extends Robot {
	
	public Transformer(Attackable attack, Moveable move) {
		this.name = "트랜스포머";
		this.attack = attack; // 의존성 주입, 제어 역전이라고 한다.
		this.move = move;
	}
//	public void attack() {
//		attack.attack();
//	}
//	public void move() {
//		move.move();
//	}
}
