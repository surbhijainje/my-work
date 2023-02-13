package verycomplexjsonpojoclasses;

public class infopojo {
private String	name;
private String  schema;
private String  description;



public infopojo(String name, String schema, String description) {
	super();
	this.name = name;
	this.schema = schema;
	this.description = description;
}
public String getName()
{
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getSchema() {
	return schema;
}
public void setSchema(String schema) {
	this.schema = schema;
}


}
