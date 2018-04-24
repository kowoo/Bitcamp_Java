package list;

public class ListTest {
	public static void main(String[] args) {
		//List : interface,
		//ArrayList, LinkedList  
		//둘 다 List 인터페이스를 구현한 List구현 클래스
		
		//리스트가 어떤 메서드를 구현해야 하는지 확인 : 엄청많음!
		//너무 많으니까 간단하게 몇가지 메서드만 구현 : 제네릭을 이용
		//StudentList의 업그레이드 버전
		//MyList는 임의의 데이터 타입을 넣을 수 있도록 작성 : 제네릭으로!
		
		MyList<String> sList = new MyList<String>();
		//기본 생성자 호출하면 크기 0인 리스트 생성
		System.out.println(sList.size());
		sList.add("1번");
		sList.add("2번");
		sList.add("3번");
		sList.add("4번");
		sList.add("5번");
		sList.add("6번");
		sList.add("7번");
		System.out.println();
		
		for(int i=0; i<sList.size(); i++) {
			System.out.println(sList.get(i));
		}
		System.out.println(sList.size());
		System.out.println();
		
		sList.remove(1);
		for(int i=0; i<sList.size(); i++) {
			System.out.println(sList.get(i));
		}
		System.out.println(sList.size());
		System.out.println();

		sList.set2(5, "n번");
		for(int i=0; i<sList.size(); i++) {
			System.out.println(sList.get(i));
		}
		System.out.println(sList.size());
		System.out.println();
		
		
		
		
		
		
		
		
	}
}
