package map;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
	public static void main(String[] args) {
		Map<String, Student> map
		= new HashMap<String, Student>();
		
		Student s1 = new Student("홍길동", 3, 100, 100, 100);
		Student s2 = new Student("신사임당", 2, 100, 100, 100);
		Student s3 = new Student("이순신", 1, 100, 100, 100);
		Student s4 = new Student("김장금", 3, 100, 100, 100);
		
		map.put("hong", s1);
		map.put("sin", s2);
		map.put("lee", s3);
		map.put("kim", s4);
		
		Student s = map.get("hong");
		System.out.println("찾은 학생 이름: "+s.getName()); // 값이 없으면 null 있으면 출력
		System.out.println("찾은 학생 학년: "+s.getGrade());
		System.out.println("찾은 학생 평균: "+s.getAverage()+"점");
		
		System.out.println("찾은 학생 이름: "+map.get("lee").getName());
		System.out.println("찾은 학생 학년: "+map.get("lee").getGrade());
		System.out.println("찾은 학생 평균: "+map.get("lee").getAverage()+"점");
		
		//Key, Sey 가져오기
		Set<String> keySet = map.keySet();
		for(String key: keySet) {
			Student student = map.get(key);
			System.out.println("이름: "+student.getName());
			System.out.println("학년: "+student.getGrade());
			System.out.println("평균: "+student.getAverage());
		}
		
	}
}
