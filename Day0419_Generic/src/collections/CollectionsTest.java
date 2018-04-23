package collections;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionsTest {
	public static void main(String[] args) {
		//List를 구현해놓은 클래스는 ArrayList, LinkedList
		//문자열을 여러개 저장하는 list
		//String[] List = new String[숫자];
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		list.add("!!");
		
		//List의 경우에는 size() 메서드를 이용해서 크기를 가져온다.
		for(int i=0; i<list.size(); i++) {
			//배열은 list[i] 형태로 각각 요소에 접근 가능
			//List는 list.get(i)로 접근해야 한다
			String str = list.get(i);
			System.out.print(str+" ");
		}
		System.out.print('\n');
		
		
		for(String s: list) {
			System.out.println(s);
		}
		
		//ArrayList와 LinkedList를 구분없이 사용이 가능하다.
		//둘다 List를 상속받았기 때문이다(같은 메서드를 가지고 있음)
		//그럼에도 왜 둘을 구분하냐면
		//배열목록은 데이터의 변경이 적고, 조회할 일이 많을 때 사용 (새로 입력받을 때 마다 배열을 새로 만들기 때문에 변경 효율이 낮음, 조회는 배열의 n번째를 보여주므로 효율이 높음)
		//연결목록은 데이터의 변경이 많고, 조회할 일이 적을 때 사용하기 때문이다. (새로 입력받으면 객체를 하나 만들고 기존 객체에다가 그 주소를 이어주는 방식이기 때문에 변경 효율이 높음, 조회는 객체를 순서대로 하나하나 조회하기 때문에 효율이 낮음)
		List<String> list2 = new LinkedList<String>();
	}
}
