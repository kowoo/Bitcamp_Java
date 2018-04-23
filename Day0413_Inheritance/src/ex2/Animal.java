package ex2;

public class Animal {
	protected String name;
	protected int numOfLegs;

	public Animal() {
		name="";
		numOfLegs=0;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getnumOfLegs() {
		return numOfLegs;
	}
	public void setnumOfLegs(int numOfLegs) {
		this.numOfLegs = numOfLegs;
	}
	
	public void sound() {
		System.out.println("동물이 웁니다!");
	}

//	public void sound(int a) {
//		System.out.println("동물이 웁니다!");
//		int b = (int)(Math.random()*2+1);
//		if(a%2==0) {
//			if(b==1) {
//				System.out.println("멍멍");
//			} else if(b==2) {
//				System.out.println("으르렁");
//			}
//		} else {
//			if(b==1) {
//				System.out.println("야옹");
//			} else if(b==2) {
//				System.out.println("갸르릉");
//			}
//		}
//	}
}
