package testing1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;                            //using request spec builder class

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;

public class Requestspecification {
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder RSB=new RequestSpecBuilder();
		RSB.setBaseUri("https://api.getpostman.com");
		RSB.addHeader("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5");
		RSB.log(LogDetail.ALL);
	RestAssured.requestSpecification = RSB.build();      //make requestspecification interface as static so its constant value canbe used in other testcases
		                                                  // by calling with class name
	}
	
	
	
  @Test
  public void validatestatuscode() {
	  String workspaceid="c5619e3d-d8c4-48c7-8c3a-fd6af3086cf5";
	get("/workspaces/"+workspaceid).then().log().all(); 
  }
}
