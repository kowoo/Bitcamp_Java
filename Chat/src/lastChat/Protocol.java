package lastChat;

import java.io.Serializable;
import java.util.Map;

public class Protocol implements Serializable {
	private static final long serialVersionUID = 9191031233437911517L;
	private Map<String, Object> data;
	private String type;
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
