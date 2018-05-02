package employeeDao;

import java.util.List;

public class EmployeeDaoTest {
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		Employee e = new Employee();
//		e.setNum(2);
//		e.setEname("쏘가리");
//		e.setDeptno(2);
//		e.setSalary(3000);
//		dao.insertEmployee(e); //작동 확인
		// dao.deleteEmployee(1); //작동 확인
		// dao.updateEmployee(e); //작동 확인
		//System.out.println(dao.selectOne(1));
		List<Employee> eList = dao.selectAll();
		for(Employee ee: eList) {
			System.out.println(ee);
		}
		
	}
	

}
