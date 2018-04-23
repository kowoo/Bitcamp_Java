package generic2;

public class StoreTest2 {
	public static void main(String[] args) {
		Store2<String, Integer> store = new Store2<String, Integer>();
		
		store.setData1("hello");
		store.setData2(10);
		System.out.println(store.getData1() + store.getData2());
	}
}
