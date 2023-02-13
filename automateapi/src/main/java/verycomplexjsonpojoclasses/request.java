package verycomplexjsonpojoclasses;

import java.util.List;

public class request {
private String url;
private String method;
private List<Object> header;
private body body;


private String description;



public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getMethod() {
	return method;
}
public void setMethod(String method) {
	this.method = method;
}
public List<Object> getHeader() {
	return header;
}
public void setHeader(List<Object> header) {
	this.header = header;
}

public body getBody() {
	return body;
}
public void setBody(body body) {
	this.body = body;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public request(String url, String method, List<Object> header, verycomplexjsonpojoclasses.body body,
		String description) {
	super();
	this.url = url;
	this.method = method;
	this.header = header;
	this.body = body;
	this.description = description;
}


}
