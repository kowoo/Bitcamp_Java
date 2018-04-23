package list;

public class MyListTest {
	public static void main(String[] args) {
		MyList<String> strList = new MyList<String>();
		
		//임의 5개 문자열 넣기
		strList.add("A");
		strList.add("B");
		strList.add("C");
		strList.add("B");
		strList.add("A");
		
		for(int i=0; i<strList.size(); i++) {
			System.out.print(strList.get(i)+" ");
		}
		System.out.println();
		
		strList.set(0, "B");
		for(int i=0; i<strList.size(); i++) {
			System.out.print(strList.get(i)+" ");
		}
		System.out.println();
		
		strList.set2(0, "B");
		for(int i=0; i<strList.size(); i++) {
			System.out.print(strList.get(i)+" ");
		}
		
		//for-each 구문은 데이터가 여러개면 다 되는게 아님
		//Iterable을 구현한 클래스나 배열만 사용가능하다.	
	}
}
