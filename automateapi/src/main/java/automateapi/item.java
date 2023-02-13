package automateapi;

import java.util.List;

public class item {
private String name;
private request request;
private List<item> item1;

public List<item> getItem() {
	return item1;
}
public void setItem(List<item> item1) {
	this.item1 = item1;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



public automateapi.request getRequest() {
	return request;
}
public void setRequest(request req) {
	this.request = req;
}

}
