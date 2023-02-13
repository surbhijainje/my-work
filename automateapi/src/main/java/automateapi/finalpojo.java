package automateapi;

import java.util.List;

public class finalpojo {
	private String  info;
	private String  name;
	private String  request;
	private String  collection;
	List<item> ITEM;
    List<header>HEADER;
    List<item> item;
    
    
	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	
	
	
      public List<header> getHEADER() {
		return HEADER;
	}

	public void setHEADER(List<header> hEADER) {
		HEADER = hEADER;
	}

	public List<item> getItem() {
		return item;
	}

	public void setItem(List<item> item) {
		this.item = item;
	}

	
 List<item> getITEM() {
		return ITEM;
	}

	public void setITEM(List<item> iTEM) {
		ITEM = iTEM;
	}
}
