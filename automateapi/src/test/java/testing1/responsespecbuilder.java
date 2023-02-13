package testing1;

import static io.restassured.RestAssured.*;                 //using responsespecbuilderclass

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class responsespecbuilder {
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder rsb=new RequestSpecBuilder();
		rsb.
		setBaseUri("https://api.getpostman.com").
		addHeader("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5").
		log(LogDetail.ALL);
		RestAssured.requestSpecification=rsb.build();
		
		ResponseSpecBuilder resb=new ResponseSpecBuilder();
		resb.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.expectResponseTime(Matchers.lessThan(3000L))
		.log(LogDetail.ALL);
		RestAssured.responseSpecification=resb.build();
	}
  @Test
  public void response1() {
	  get("/workspaces");
  }
}
