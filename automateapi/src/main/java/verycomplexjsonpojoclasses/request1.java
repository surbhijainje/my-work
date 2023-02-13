package verycomplexjsonpojoclasses;

public class request1 {
	private String url;
	private String method;
	private String description;
	
	public request1(String url, String method, String description) {
		super();
		this.url = url;
		this.method = method;
		this.description = description;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
