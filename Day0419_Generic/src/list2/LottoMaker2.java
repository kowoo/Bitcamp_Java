package list2;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

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

		for(int lN: lotto) {
			System.out.print(lN+" ");
		}



	}
}
