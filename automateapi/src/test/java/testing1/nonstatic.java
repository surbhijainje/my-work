package testing1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class nonstatic {
  @Test
  public void simpletest() {
	  RestAssured.
	  given().baseUri("https://api.getpostman.com").header("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5").
	  when()
	 .get("/workspaces")
	 .then().log().all()
	 .assertThat().statusCode(200).body("workspaces[1].name",Matchers.is(Matchers.equalTo("Test Workspace")),("workspaces[2].type"),Matchers.equalTo("personal"));
  
}
}


