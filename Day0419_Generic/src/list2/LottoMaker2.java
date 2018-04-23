package list2;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class LottoMaker2 {
	public static void main(String[] args) {
		Random ran = new Random();
		List<Integer> lotto = new ArrayList<Integer>();

		for(int i=0; i<6; i++) {
			lotto.add(i,ran.nextInt(7)+1);
			for(int j=0; j<i; j++) {
				if(lotto.get(i)==lotto.get(j)) {
					lotto.remove(i);
					i--;
					break;
				}
			}
		}

		int tmp=0;
		for(int i=0; i<5; i++) {
			for(int j=i; j<6; j++) {
				if(lotto.get(i)>lotto.get(j+1)) {
		
				}
			}
		}
		
		
		//Collection.sort(lotto);
		



		for(int lN: lotto) {
			System.out.print(lN+" ");
		}



	}
}
