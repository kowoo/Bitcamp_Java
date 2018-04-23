package map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest3 {
	@SuppressWarnings("unchecked") //노란 줄 없애기
	public static void main(String[] args) {
		// 데이터를 전달할 때 많이 사용하는 방법
		// 데이터의 종류가 매우 다양하기 때문에 모든 데이터를 한꺼번에 담아서 처리해야한다.
		// 이때 자료구조가 필요한데 Map를 사용함.
		Map<String, Object> map
		= new HashMap<String, Object>(); //사용 빈도 매우 높음
		
		List<Student> studentList
		= new ArrayList<Student>();
		
		studentList.add(new Student());
		studentList.add(new Student());
		studentList.add(new Student());
		studentList.add(new Student());
		studentList.add(new Student());
		
		map.put("student", new Student());
		map.put("phone", "010-9747-9112");
		map.put("member_number", 5);
		map.put("studentList", studentList);
		
		
		/*******************전송*******************/
		
		//map에서 데이터를 꺼내서 사용한다.
		//이미 어떤 key값이 어떤 종류의 데이터를 사용하는지 약속이 되어있는 상태로
		//데이터를 주고 받기 떄문에 해당하는 key가 가지는 데이터를 약속된 데이터로 사용한다.
		
		
		//Map에 있는 데이터 꺼내와서 해당하는 데이터 변수에 넣기
		//Map의 Value를 Object로 선언했기 때문에 가져올 때, 형 변환을 해야한다.
		Student s = (Student)map.get("student");
		String phone = (String)map.get("phone");
		int number = (int)map.get("member_number");
		
		//Map의 요소로 List도 넣을 수 있다. 가져올 때는 마찬가지로 형 변환을 해야 함.
		List<Student> sList = (List<Student>)map.get("studentList"); 
		
		//List를 가져와서 for each로 하나씩 출력하기.
		for(Student s1: sList) {
			System.out.println(s1);
		}
		//위와 같은 출력이지만 for문에서 바로 사용하는 방식. 
		for(Student s1 : (List<Student>)map.get("studentList")) {
			System.out.println(s1);
		}
		
		//Map과 같은 형태로 List에도 역시 Object나 다른 컬렉션 객체를 요소로 가질 수 있다.
		//밑은 List가 요소로 List를 가지는 이차원 배열인셈
		List<List<String>> strList
		= new ArrayList<List<String>>();
		/******************/
		List<String> list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		/******************/
		strList.add(list1);
		
		String str = strList.get(0).get(0);
		System.out.println(str);
		
	}
}
