package collection;

import java.util.HashMap;
import java.util.Map;

public class key {
	public static void main(String[] args) {
		Map<Character,Integer> c = new HashMap<Character,Integer>();
		
		c.put('A', 1);
		c.put('B', 2);
		c.put('C', 3);
		c.put('D', 4);
		
		System.out.println(c.get('B'));
		System.out.println(c.containsKey('B'));
		System.out.println(c.containsValue(3));
	}
}
