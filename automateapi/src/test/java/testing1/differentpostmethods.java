package testing1;

import java.io.File;
import java.util.HashMap;

import  org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class differentpostmethods {
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
			.expectResponseTime(Matchers.lessThan(4000l))
			.log(LogDetail.ALL);}
			
  @Test(enabled=false)
  public void file() {
	  File file=new File("src/main/resources/createworkspace.json");
	  RestAssured.given().body(file).when().post("/workspaces").then().log().all();
	 Response response = RestAssured.with().body(file).post("/workspaces");
	
  }
  
  @Test
  public void Map() {
	 HashMap<String,String> object1 =new HashMap<>();                        //add jackson databind jar files to project to use hashmap
	  HashMap<String,Object> mainobject =new HashMap<>();
	  object1.put("name","ashuworkspace");
	  object1.put("type","personal");
	  object1.put("description","this is my workspace");
	  mainobject.put("workspace", object1);
	  
	  RestAssured.given().body(mainobject).when().post("/workspaces").then().log().all();
  }
}
