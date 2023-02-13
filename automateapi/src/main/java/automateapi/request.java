package automateapi;

import java.util.List;

public class request {
	private String url;
	private String method;
	private List<header> header;
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
	public List<header> getHeader() {
		return header;
	}
	public void setHeader(List<header> hEAD) {
		this.header = hEAD;
	}
	public body getBody() {
		return body;
	}
	public void setBody(automateapi.body bo) {
		this.body = bo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
