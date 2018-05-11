package commons;

public enum Member {
	//열거형: 값들의 나열
	NUM("num"), ID("id"), NAME("name"), EMAIL("email"), PW("pw"), REG_DATE("regdate");
	
	private String col;
	
	
//	public Member() {
//		//얘가 안됨
//	}
	
	public String getCol() {
		return col;
	}

	private Member(String col) {
		this.col = col;
	}
}