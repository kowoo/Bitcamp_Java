package list2;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class LottoMaker {
	public static void main(String[] args) {
		Random ran = new Random();
		List<Integer> lotto = new ArrayList<Integer>();

		for(int i=0; i<6; i++) {
			lotto.add(i,ran.nextInt(45)+1);
			for(int j=0; j<i; j++) {
				if(lotto.get(i)==lotto.get(j)) {
					lotto.remove(i);
					i--;
					break;
				}
			}
		}

		int tmp=0;
		int tmp2=0;
		int save=0;
		for(int i=0; i<5; i++) {
			save = lotto.get(i);
			for(int j=i+1; j<6; j++) {
				if(save>lotto.get(j)) {
					save = lotto.get(j);
					tmp = j;
				}
			}
			tmp2 = lotto.get(i); //모수 위치
			lotto.remove(i); //모수 위치 제거
			lotto.add(i, save); //모수 위치에 작은 수 저장
			lotto.remove(tmp); //작은수 위치 제거
			lotto.add(tmp, tmp2); //작은 수 위치에 모수 저장
		}
		
		
		//Collection.sort(lotto);
		



		for(int lN: lotto) {
			System.out.print(lN+" ");
		}



	}
}
