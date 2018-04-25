package map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class MapTest {
	public static void main(String[] args) {
		/* key-value로 이루어진 자료구조
		 * key	: 중복 안되는 유일한 값
		 * value: 중복 가능. key와 쌍을 이루는 데이터
		 */

		/* Map : 인터페이스, 구현 클래스(HashMap)
		 */
		
		// key: int, value: String인 map 작성
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1,"Apple");
		map.put(3,"Grape");
		map.put(5,"Tomato");
		map.put(7,"Pineapple");
		//가져올 때는 key를 이용해서 value를 가져올 수 있음
		String val1 = map.get(5);
		System.out.println(val1);
		
		//나중에 넣은 값으로 덮어씌우기
		map.put(5,"Watermellon");
		val1 = map.get(5);
		System.out.println(val1);
		System.out.println();
		
		//map도 set처럼 순서가 없음, 항상 key로 접근해야함
		//그렇다면 key를 모를때는? key가 있는지 없는지 검사
		System.out.println(map.containsKey(15)); //해당 키가 있으면 true 없으면 false
		System.out.println();
		
		//모든 요소를 다 보고 싶다면? map이 가지고 있는 entrySet()을 이용
		for(Map.Entry<Integer, String> e: map.entrySet()) { //map.entrySet() == 맵의 요소를 set로 만들어냄. set반환
			// 엔트리셋을 통해 맵의 엔트리를 만들 수 있다(Map.Entry<Integer, String>)
			int num = e.getKey();
			String str = e.getValue();
			System.out.print("key: "+num+", value: "+str+'\n');
		}
		System.out.println();
		
		//keyset을 얻어올 수 있다.
		Set<Integer> keySet = map.keySet();
		for(int num: keySet) {
			String str = map.get(num);
			System.out.print(num+":"+str+" ");
		}
		System.out.println();
		System.out.println();
		
		//KeySet에 있는 Iterator 이용해도 된다.
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()) {
			int key = it.next();
			String str = map.get(key);
			System.out.println(key+":"+str);
		}
		
	}
}
