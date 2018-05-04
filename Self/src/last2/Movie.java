package last2;

import java.io.Serializable;

public class Movie implements Serializable {
	private String name;

	public Movie() {}
	public Movie(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return name;
	}
	
	
	
}
