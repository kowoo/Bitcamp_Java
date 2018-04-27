package collection;

import java.util.ArrayList;
import java.util.List;

public class list {
	public static void main(String[] args) {
		List<Byte> bytes = new ArrayList<Byte>();
		
		
		for(int i=-128; i<128; i++) {
			bytes.add((byte)i);
		}
		
		for(byte n: bytes) {
			System.out.print(n+" ");
			if(n%10==0) {
				System.out.println();
			}
		}
		
		
	}
}
