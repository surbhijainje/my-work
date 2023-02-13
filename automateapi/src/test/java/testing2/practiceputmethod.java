package testing2;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class practiceputmethod {
  @Test
  public void beforeclass() {
	  RequestSpecBuilder r1=new RequestSpecBuilder();
	  r1.setBaseUri("https://api.getpostman.com");
	  r1.addHeader("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5");
	  r1.log(LogDetail.ALL);
	 requestSpecification=r1.build();
	  
	  
	  ResponseSpecBuilder r2=new ResponseSpecBuilder();
	  r2.expectContentType(ContentType.JSON)
	  .expectStatusCode(200).expectResponseTime(equalTo(2000l))
	  .log(LogDetail.ALL).build();
	  
	  
  }
  @Test(enabled=false)
  public void post1() {
	  String payload=" {\n"
	  		+ " \"workspace\": {\n"
	  		+ "       \"name\": \"our Workspace\",\n"
	  		+ "        \"type\": \"personal\",\n"
	  		+ "        \"description\": \"This is a test personal workspace.\"\n"
	  		+ "    }\n"
	  		+ "}";
	 // RestAssured.with().body(payload).post("/workspaces");
	given().body(payload)
	  .when()
	  .post("/workspaces")
	  .then().log().all();
	  
  }
  @Test(enabled=true)
  public void post2() {
	 
	HashMap<String,String>obj=new HashMap<>();
	HashMap<String,Object>mainobj=new HashMap<>();
	obj.put("name","only workspace");
	obj.put("type","personal");
	mainobj.put("workspace", obj);
	given().body(mainobj).when().post("/workspaces").then().log().all();
  }
  
  @Test(enabled=true)
  public void put() {
	  String workspaceid="c5619e3d-d8c4-48c7-8c3a-fd6af3086cf5";
	  String payload=" {\n"
		  		+ " \"workspace\": {\n"
		  		+ "       \"name\": \"toto Workspace\",\n"
		  		+ "        \"type\": \"personal\",\n"
		  		+ "        \"description\": \"This is a test personal workspace.\"\n"
		  		+ "    }\n"
		  		+ "}";
  
  given().body(payload).pathParam("workspaceid",workspaceid).when().put("/workspaces/{workspaceid}").then().log().all()
  .assertThat().body("workspace.name", equalTo("toto Workspace"));
		 
}
  
 

@Test(enabled=true)
  public void get() {
	when().get("/workspaces").then().log().all();
  }
  
  @Test
  public void delete() {
	  String workspaceid="7bdee569-a672-4d6a-886f-5ba08099e670";
	 // RestAssured.when().delete("/workspaces/"+workspaceid).then().log().all();
	 given().pathParam("workspaceid", workspaceid).when().delete("/workspaces/{workspaceid}").then().log().all();
  }
}
