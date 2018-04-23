package inner;

public class OuterClass {
	//내부에 클래스를 포함하고 있는 클래스
	//멤버변수 하나 선언하고, 내부클래스선언한 다음, 
	//내부클래스에서 외부클래스 멤버변수 사용해보기
	private String secret = "time is gold";
	private InnerClass inner;
	
	public OuterClass() {
		System.out.println("외부클래스 생성자 호출");
		inner = new InnerClass();
	}
	public void showInner() {
		inner.showSecret();
	}
	
	//내부클래스
	public static class InnerClass{
		//내부클래스의 생성자
		public InnerClass() {
			System.out.println("내부클래스 생성자 호출");
		}
		public void showSecret() {
//			System.out.println("비밀 : " + secret);
		}
	}
}