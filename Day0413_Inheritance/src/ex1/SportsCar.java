package ex1;

public class SportsCar extends Car {
	// 상속해준 클래스를 부모클래스 혹은 슈퍼클래스라고 부름 (카)
	// 상속받은 클래스를 자식 클래스 혹은 서브클래스라고 부름 (스포츠카)
	boolean isTurbo;
	
	public SportsCar() {
		//부모클래스의 기본생성자 호출
		//super(1); //기본 생성자가 아닐 경우는 이렇게 super(조건)을 만족해야함.
		//부모클래스 생성자의 호출 명령어는 무조건 최상단이어야한다.
		System.out.println("자식 클래스 생성자 호출!!");
		//super(2); 이렇게 하면 sysout보다 아래라서 오류 발생
		
		//기본생성자의 경우 super();가 생략되어 있는셈. 입력안해도 된다
	}

	public void turboOn() {
		if(!isTurbo) {
			System.out.println("터보 온!!!");
			isTurbo = true;
			speedUp();
			speedUp();
			speedUp();
			speedUp();
			speedUp();
		} else {
			System.out.println("터보 상태입니다!!!");
		}
	}

	public void turboOff() {
		if(isTurbo) {
			System.out.println("터보를 끕니다");
			isTurbo = false;			
			setSpeed(getSpeed()-50);
		} else {
			System.out.println("이미 꺼져있습니다");
		}
	}
}
