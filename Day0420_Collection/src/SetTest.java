import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		//Set Collection 인터페이스
		//구현해놓은 클래스 중 하나가 HashSet (오름차순 자동정렬 해줌.)
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		
		set1.add("A");
		set1.add("D");
		set1.add("C");
		set1.add("Z");
		set1.add("B");
		
		//B는 중복되므로 false!, 만약 없던 수라면 넣고나서 true반환
		System.out.println(set1.add("B"));
		
		//순서가 없기 때문에 요소에 접근이 안된다. get(i)안됨..
		System.out.println(set1.contains("A"));
		System.out.println(set1.contains("T"));
		
		//내용을 확인해야 할 일이 있다! >> Iterator를 이용
		//Iterator : 하나씩, 모든 요소에 대해서 반복하면서 요소를 가져다준다.
		Iterator<String> it = set1.iterator();
		
		//hasNext(): 다음 수가 있다면 트루!
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str); //ADCB로 입력했지만 ABCD로 출력된다.
		}
		
		//집합(합집합, 차집합, 교집합) 구하기
		set2.add("D");
		set2.add("F");
		set2.add("A");
		set2.add("G");
		
		HashSet<String> union;
		HashSet<String> difference;
		HashSet<String> intersection;
		
		union = new HashSet<String>(set1);
		difference = new HashSet<String>(set1);
		intersection = new HashSet<String>(set1);
		
		//합집합
		union.addAll(set2);
		System.out.println(union);
		
		//차집합
		difference.removeAll(set2);
		System.out.println(difference);
		
		//교집합
		intersection.retainAll(set2);
		System.out.println(intersection);
		
	}
}
