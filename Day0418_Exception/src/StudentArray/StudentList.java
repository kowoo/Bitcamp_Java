package StudentArray;

public class StudentList {
	Student[] students;

	public StudentList() {
		students = new Student[4];
		students[0] = new Student("홍길동", 3, 100, 0, 50);
		students[1] = new Student("이순신", 2, 50, 100, 50);
		students[2] = new Student("신사임당", 1, 80, 100, 100);
		students[3] = new Student("김장금", 2, 70, 80, 100);
	}
	
	public void add(Student student) { 
		 Student[] tmpArr = new Student[students.length+1];
		 for(int i =0;i<students.length;i++) {
			 tmpArr[i] = students[i];
		 }
		 tmpArr[students.length] = student;
		 students = tmpArr;
	}
	
	public Student[] getStudents() {
		return students;
	}

	public void delete(String name) {
		boolean isDeleted = false; 
		//삭제할 학생을 찾아서, 복사를 하지 않았으면 true, 못찾았으면 false 
		Student[] tmpArr = new Student[students.length-1];
		int j=0;
		for(int i=0;i<students.length;i++) {
			//학생 이름이랑, 입력받은 이름이랑 같으면
			if(students[i].getName().equals(name)&&!isDeleted) {
				//삭제 하기 : 입력하기 반대
				//현재 배열보다 크기 1 작은 배열 생성
				//이름이 같은 첫번째 요소를 제외한 나머지 요소 모두 복사
				isDeleted = true;
			}else {
				//이름이 같지 않거나, 같더라도 이름이 같은  첫번째 요소가 아닐때 
				//새로운 배열에 원래 요소를 복사
				/*
				 * [ ][ ][v][ ][ ][ ]
				 * [ ][ ][ ][ ][ ]
				 * 찾기 전이랑, 찾고 나서 인덱스가 다름
				 * */
				tmpArr[j] = students[i];
				j++;
			}
		}
		students = tmpArr;
	}
	


}
