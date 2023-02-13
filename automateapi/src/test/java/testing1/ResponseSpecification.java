package testing1;

import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.responseSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;


public class ResponseSpecification {
	
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder rsb=new RequestSpecBuilder();
		rsb.setBaseUri("https://api.getpostman.com");
		rsb.addHeader("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5");
		rsb.log(LogDetail.ALL);
		RestAssured.requestSpecification=rsb.build();
		responseSpecification=expect().statusCode(200).contentType(ContentType.JSON);
	
	}
	
  @Test
  public void response() {
	 get("/workspaces").
	 then().
	 spec(responseSpecification).
	 log().all().
	 extract().response();
  }
  
 
}
