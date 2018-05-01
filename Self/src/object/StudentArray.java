package object;

public class StudentArray {
	Student[] students;
	
	public StudentArray() {
		students = new Student[0];
	}
	
	public void add(String name, int age, int eng, int math) {
		Student[] tmp = new Student[students.length+1];
		for(int i=0; i<students.length; i++) {
			tmp[i] = students[i];
		}
		tmp[students.length] = new Student(name, age, eng, math);
		students = tmp;
	}

	public Student[] getStudent() {
		return students;
	}
	
	public void setStudent(int i, Student s) {
		students[i] = s;
	}
	
	public int size() {
		return students.length;
	}
	
	public void find(String name) {
		for(int i=0; i<students.length; i++) {
			if(name.equals(students[i].getName())) {
				System.out.println(students[i]);
			}
		}
	}
	
	public void dels(String name) {
		for(int i=0; i<students.length; i++) {
			if(name.equals(students[i].getName())) {
				Student[] tmp = new Student[students.length-1];
				for(int j=i; i<students.length; i++) {
					tmp[j] = students[j+1];
				}
				students = tmp;
				break;
			}
		}
	}
	
	public void printList() {
		for(Student s: students) {
			System.out.println(s);
		}
	}
	
	
}
