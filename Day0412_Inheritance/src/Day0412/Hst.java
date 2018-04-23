package Day0412;

import School.Score;

public class Hst extends St { //extends 클래스명 : 해당 클래스의 기능을 상속받는다.
	private int age;
	
	public Hst() {
		super();
		score = new Sc();
		age=17;
	}
	
//	public Hst(String name, int grade, int age, int kor, int eng) {
//		this.age = age;
//	}
	
	public Hst(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Hst\nname: " + getName() + ", grade: " + grade +", age: "+ age + ", score: " + score;
		// 네임을 겟네임으로 한 이유는 St클래스의 네임이 프라이빗이기 때문.
	}
	

}
