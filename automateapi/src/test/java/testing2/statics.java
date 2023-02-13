package testing2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class statics {
  @Test
  public void f() {
	 given().baseUri("https://api.getpostman.com").header("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5")
	 .when().get("/workspaces");
	// .then().log().all().assertThat().statusCode(200).body("workspaces[0].name", is(equalTo("My Workspace")));
	// ,equalTo(""));
	 //.then().assertThat().statusCode(200).body("workspaces[0].name",is(equalTo(null)));
	// .then().assertThat().statusCode(200).body("workspaces[0].name",is("my workspace"));
	 
  }
}
