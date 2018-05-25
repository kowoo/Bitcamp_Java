package lastChat;

import java.io.Serializable;

public class Member implements Serializable{
	private String id;
	private String pw;
	private String nick;
	public Member() {}
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.nick = "이름없음";
	}
	public Member(String id, String pw, String nick) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String toString() {
		return id;
	}
}
