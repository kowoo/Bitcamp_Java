package list;

public class List {
	Student[] s;
	
	public List() {
		s = new Student[3];
		s[0] = new Student("홍길동", 2, 100, 89);
		s[1] = new Student("강아지", 2, 90, 100);
		s[2] = new Student("다람쥐", 2, 100, 88);
	}
	
	public void add(Student st) {
		
		Student[] tmp = new Student[s.length+1];
		for(int i=0; i<s.length; i++) {
			tmp[i] = s[i];
		}
		tmp[s.length] = st;
		s = tmp;
	}

	public Student[] getS() {
		return s;
	}

	public void setS(Student[] s) {
		this.s = s;
	}
	
	public void del(String name) {
		int save=0;
		for(int i=0; i<s.length; i++) {
			if(name.equals(s[i].getName())) {
				save = i;
			}
		}
		for(int i=save; i<s.length-1; i++) {
			s[i] = s[i+1];
		}
		Student[] tmp = new Student[s.length-1];
		for(int i=0; i<s.length-1; i++) {
			tmp[i] = s[i];
		}
		s = tmp;
	}
	
	
}
