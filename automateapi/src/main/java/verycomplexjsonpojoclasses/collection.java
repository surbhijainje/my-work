package verycomplexjsonpojoclasses;

import java.util.List;

public class collection {
private infopojo info;
private List<Object> item;

public collection(infopojo info, List<Object> item) {
	super();
	this.info = info;
	this.item = item;
}
public collection() {
	// TODO Auto-generated constructor stub
}
public infopojo getInfo() {
	return info;
}
public void setInfo(infopojo info) {
	this.info = info;
}
public List<Object> getItem() {
	return item;
}
public void setItem(List<Object> item) {
	this.item = item;
}

}
