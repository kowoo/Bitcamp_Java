import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest2 {
	public static void main(String[] args) {
		//Set Collection 인터페이스
		//구현해놓은 클래스 중 하나가 HashSet (오름차순 자동정렬 해줌.)
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<6; i++) {
			set.add((int)(Math.random()*45)+1);
		}
		
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			int lotto = it.next();
			System.out.print(lotto+" ");
		}
		

	}
}
