package ex2;

public class AnimalTest {
	public static void main(String[] args) {
		Animal[] pet = new Animal[5];

		for(int i=0; i<pet.length; i++) {
			int a = (int)(Math.random()*2)+1;
			if(a==1) {
				pet[i] = new Dog();
				pet[i].sound();
				//((Dog)pet[i]).bark();
			} else {
				pet[i] = new Cat();
				pet[i].sound();
				//((Cat)pet[i]).meow();
			}
			
		}
		
	}
}
//부모클래스의 참조변수를 통해서는 자식 클래스의 기능, 변수를 사용할 수 없다.
//굳이 사용하고 싶다면 형변환을 통해서 사용해야 한다.
//((SportsCar)c1).turboOn(); 이렇게 사용하거나
//SportsCar c2 = (SportsCar)c1;
//c2.turboOn(); 				이렇게 사용할 수 있다
