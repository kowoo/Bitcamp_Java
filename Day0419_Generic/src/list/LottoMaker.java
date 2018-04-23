package list;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {
	//배열을 리스트로 교환
	//int[] lotto = new int[6];
	public static final int LENTH_OF_LOTTO = 6;
	List<Integer> lotto;
	
	public LottoMaker() {
		//List : 인터페이스 이기 때문에 객체 생성 X
		//인터페이스를 구현한 구현클래스를 이용해서 객체를 만들어야 한다.
		//길이 0인 리스트를 생성
		lotto = new ArrayList<Integer>();
	}
	
	public void makeNumber() {
		//난수를 만들어 내고 출력
		int count=0;
//		for(int i=0;i<LENTH_OF_LOTTO;i++) {
//			//이미 들어갈 자리가 있으니까...미리 넣고 나서 비교
//			int tmp =((int)(Math.random()*6))+1;
//			lotto.add(tmp);
//			count++;
//			for(int j=0;j<i;j++) {
//				if(tmp == lotto.get(j)) {
//					lotto.remove(i);
//					i--;
//					break;
//				}
//			}
//		}
		
		for(int i=0;i<LENTH_OF_LOTTO;i++) {
			//이미 들어갈 자리가 있으니까...미리 넣고 나서 비교
			int tmp =((int)(Math.random()*6))+1;
			boolean isDup=false;  //중복되면 true
			count++;
			for(int j=0;j<i;j++) {
				if(tmp == lotto.get(j)) {
					isDup = true;
					i--;
					break;
				}
			}
			if(!isDup) {
				//중복이 일어나면 아무작업하지 않음
				//>>중복이 일어나지 않았다면 생성한 숫자를 추가
				lotto.add(tmp);
			}
		}
		
		
		//출력
		for(int number:lotto) {
			System.out.print(number + " ");
		}
		System.out.println();
		//System.out.println(count);
	}
}
