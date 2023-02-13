package automateapi;

public class workspace {
	
	private String name;
	private String Type;
	private String description;
	
	
public workspace(String name, String type, String description) {
		
		this.name = name;
	    this.Type = type;
		this.description = description;
	}


public String getName() {
	return name;
}


public String getType() {
	return Type;
}

public String getDescription() {
	return description;
}

	
public void setName(String name) {
	this.name = name;
}

public void setType(String type) {
	Type = type;
}

public void setDescription(String description) {
	this.description = description;
}


}
