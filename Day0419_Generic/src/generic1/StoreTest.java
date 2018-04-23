package generic1;

public class StoreTest {
	public static void main(String[] args) {
		Store s1=new Store();
		s1.setData(10);
		System.out.println("s1 : "+s1.getData());
		Store s2=new Store();
		s2.setData("Hello!!");
		System.out.println("s2 : "+s2.getData());
		
		//Store.getData()는 Object를 반환한다.
		//자식 클래스의 변수에 참조될 수 없다. (자동 변환(캐스팅)이 안됨)
		//int a = s1.getData();

		//자식 클래스로 형변환 해주면 사용가능
		String str = (String)s2.getData();
		System.out.println("str : "+str);
		
		//부모클래스의 참조변수에 참조된 객체가 어떤 객체인지
		//정확히 모르기 때문에 예외 발생 가능성이 높으며, 형변환을 해줘야하는 불편함도 있다.
		String str2 = (String)s2.getData();
		
		
		
		if(s1.getData() instanceof String) {
			String str3 = (String)s1.getData();
		}else {
			System.out.println("문자열이 아니라 바꿀 수 없음");
		}
	}
}
