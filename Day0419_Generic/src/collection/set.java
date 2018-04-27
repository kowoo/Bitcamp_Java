package collection;

import java.util.HashSet;
import java.util.Set;

public class set {
	public static void main(String[] args) {
		Set<String> name = new HashSet<String>();
		name.add("자두");
		name.add("사과");
		name.add("수박");
		name.add("메론");
		name.add("딸기");
		name.add("감귤");
		name.add("바나나");
		
		System.out.println(name.contains("자두"));
		System.out.println(name.size());
		System.out.println(name.toString());
		
	}
}
