package testing1;

import static org.hamcrest.Matchers.*;

import org.hamcrest.core.Is;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class automateputmethod {
	@BeforeClass
	public void beforeclass(){
			RequestSpecBuilder rsb=new RequestSpecBuilder();
			rsb.setBaseUri("https://api.getpostman.com")
			.addHeader("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5")
			.log(LogDetail.ALL);
			RestAssured.requestSpecification=rsb.build();
			
			ResponseSpecBuilder resb=new ResponseSpecBuilder();
			resb.expectStatusCode(200)
			.expectContentType(ContentType.JSON)
			.expectResponseTime(lessThan(4000l))
			.log(LogDetail.ALL);
		
	}
  @Test(enabled=false)
  public void putmethodBDDstyle1() {
	  String payload=" {\n"
	  		+ " \"workspace\": {\n"
	  		+ "       \"name\": \"Testtype Workspace\",\n"
	  		+ "        \"type\": \"personal\",\n"
	  		+ "        \"description\": \"This is a testtype personal workspace.\"\n"
	  		+ "    }\n"
	  		+ "}";
	  String workspaceid="914a35f8-412f-488c-92a6-22d48d8a2572";
	  RestAssured.given().body(payload).
	  when()
	  .put("/workspaces/"+workspaceid).then().log().all();}
	  
	  @Test(enabled=true)
	  public void putmethodBDDstyle2() {
		  String payload=" {\n"
		  		+ " \"workspace\": {\n"
		  		+ "       \"name\": \"Testtypenew Workspace\",\n"
		  		+ "        \"type\": \"personal\",\n"
		  		+ "        \"description\": \"This is a testtypenew personal workspace.\"\n"
		  		+ "    }\n"
		  		+ "}";
		  String workspaceid="77cb878a-8f3d-4d25-8813-c4b720d315f1";
		  RestAssured.given().body(payload).pathParam("workspaceid", workspaceid).
		  when()
		  .put("/workspaces/{workspaceid}").then().assertThat().body("workspace.name", is("My Workspace"));
  }
	  
	  @Test(enabled=false)
	  public void deletemethodBDDstyle() {
		  String workspaceid="914a35f8-412f-488c-92a6-22d48d8a2572";
		  RestAssured.given().pathParam("workspaceid", workspaceid).when().delete("/workspaces/{workspaceid}").then().assertThat().statusCode(200).log().all();
		  
	  } 
}
