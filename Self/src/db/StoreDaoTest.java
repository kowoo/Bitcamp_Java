package db;

public class StoreDaoTest {
	public static void main(String[] args) {
		StoreDao dao = new StoreDao();
		Store store = new Store();
		store.setName("모스버거");
		store.setType("패스트푸드");
		store.setTeleNumber("02-522-0799");
		store.setOpenClosed("08:00~22:00");
		store.setPrice("5000");
		store.setScore("3");
		dao.insertStudent(store);
		
		System.out.println("저장완료");
		
		System.out.println(dao.selectAll());
		
	}
}
