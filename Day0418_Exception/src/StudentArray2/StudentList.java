package StudentArray2;

public class StudentList {
	private Student[] students;
	
	public StudentList() {
		students = new Student[0];
		setDefaultData();
	}
	
	public Student[] getStudents() {
		return students;
	}
	
	public void setStudents (Student[] students) {
		this.students = students;
	}
	
	//add() : 학생정보하나를 전달받아서 배열에 추가, 
	//현재 배열보다 크기 1큰 배열 만들어서 기존배열 복사하고,학생추가
	public void add(Student s) {
		 Student[] tmpArr
		   = new Student[students.length+1];
		 for(int i =0;i<students.length;i++) {
			 tmpArr[i] = students[i];
		 }
		 tmpArr[students.length] = s;
		 
		 //관리할 배열 바꿔주기
		 students = tmpArr;
	}
	
	//delete(): 삭제할 학생의 이름을 전달 받아서 목록에서 삭제
	//		  : 학생 배열에서 입력받은 학생을 삭제하기 위해
	//			크기가 1이 작은 배열을 생성해서,
	//			해당하는 이름의 학생 객체만 제외하고 기존 배열에서 복사
	
	public void delete(String name) {
		boolean isDeleted = false; 
		//삭제할 학생을 찾아서, 복사를 하지 않았으면 true, 못찾았으면 false 
		Student[] tmpArr = new Student[students.length-1];
		int j=0;
		for(int i=0;i<students.length;i++) {
			//학생 이름이랑, 입력받은 이름이랑 같으면
			if(students[i].getName().equals(name)&&!isDeleted) {
				isDeleted = true;
			}else {
				tmpArr[j] = students[i];
				j++;
			}
		}
		students = tmpArr;
	}
	
	//size(): 학생 배열의 길이를 반환 하는 메서드
	public int size() {
		return students.length;
	}
	
	// 임의의 학생정보를 배열에 넣어주는 임시메서드
		public void setDefaultData() {
			// 학생배열에 3~4명정도 학생정보 넣기
			students = new Student[4];
			students[0] = new Student("홍길동", 3, 100, 0, 50);
			students[1] = new Student("이순신", 2, 50, 100, 50);
			students[2] = new Student("신사임당", 1, 80, 100, 100);
			students[3] = new Student("김장금", 2, 70, 80, 100);
		}
	
	
}
