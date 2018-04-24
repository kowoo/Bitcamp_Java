package week_05;

import java.util.List;
import java.util.ArrayList;

public class List_Student {
	public static void main(String[] args) {
		String name = "싫어";
		List<String> stuArr = new ArrayList<String>();
		
		for(int i=0; i<10; i++) {
			stuArr.add(name+i);
		}
		
		System.out.println(stuArr);
		
		
		
	}
	
}
