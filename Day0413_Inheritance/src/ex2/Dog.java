package ex2;

public class Dog extends Animal {
	
	public Dog() {
		name="멍멍이";
		numOfLegs=4;
	}
	public Dog(String name, int numOfLegs) {
		this.name = name;
		this.numOfLegs = numOfLegs;
	}
	
	public void sound() {
		System.out.println("멍멍");
	}
	
//	public void bark() {
//		System.out.println("멍멍");
//	}
	
	public String toString() {
		return String.format("이름 : %s%n다리개수 : %d", name, numOfLegs);
	}

}
