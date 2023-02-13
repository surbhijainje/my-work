package testing1;

import static org.hamcrest.Matchers.lessThan;

import  static org.hamcrest.Matchers.*;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;


public class automatepostmethod {
	@BeforeClass()
	public void beforeclass() {
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
  public void postnonbdd() {
	  String payload = " {\n"
	  		+ " \"workspace\": {\n"
	  		+ "       \"name\": \"Testnew10 Workspace\",\n"
	  		+ "        \"type\": \"personal\",\n"
	  		+ "        \"description\": \"This is a Testnew personal workspace.\"\n"
	  		+ "    }\n"
	  		+ "}";
	 Response response = RestAssured.with().body(payload).post("/workspaces");
	//assertThat(response.<String>path("workspaces.name"),equalTo("Testnew1 workspace"));
	assertThat(response.<String>path("workspace.name"), equalTo("Testnew10 Workspace"));
	 
  }

 @Test
 public void postbdd() {
	 String payload = " {\n"
		  		+ " \"workspace\": {\n"
		  		+ "       \"name\": \"surbhi jain Workspace\",\n"
		  		+ "        \"type\": \"personal\",\n"
		  		+ "        \"description\": \"This is a surbhi personal workspace.\"\n"
		  		+ "    }\n"
		  		+ "}";
RestAssured.given().body(payload).when().post("/workspaces").then().body("workspace.name", equalTo("surbhi jain Workspace")).log().all();
	 
	 
}
}
			
