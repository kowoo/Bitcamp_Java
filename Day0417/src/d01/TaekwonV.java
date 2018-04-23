package d01;

public class TaekwonV {
	String name;
	public TaekwonV() {
		this.name = "태권브이";
	}
	public void fight() {
		System.out.println(name+" 전투 시작");
		punchAttack();
		flyMove();
		punchAttack();
		System.out.println(name+"전투를 종료합니다.");
	}
	public void punchAttack() {
		System.out.println("주먹으로 공격!!:"); //5만줄
	}
	public void flyMove() {
		System.out.println("날아서 이동!!"); //10만줄
	}
}
