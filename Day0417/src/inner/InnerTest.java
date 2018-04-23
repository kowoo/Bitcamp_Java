package inner;

public class InnerTest {
	public static void main(String[] args) {
		//실습목적: 내부클래스의 사용방법
//		OuterClass outter = new OuterClass();
		//outter.showInner();
		
		//?? 외부에서 inner 클래스의 객체생성해보기  
		//InnerClass는 OutterClass 내부에 있기 때문에
		//어떤 클래스의 내부 클래스 인지 명확히 알려주어야 한다. 
		
		//내부 클래스가 instance 클래스 일때
//		OuterClass.InnerClass inner 
//		 = OuterClass.new InnerClass();
//		inner.showSecret();
		
		
		//내부 클래스가 static으로 선언된 경우
		//static으로 선언된 경우 outer클래스에 접근할 수 없다
		OuterClass.InnerClass inner
		= new OuterClass.InnerClass();
		
		inner.showSecret();
	}
}
