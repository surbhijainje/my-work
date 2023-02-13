package testing1;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.config.LogConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class diferentmethods {
 @Test(enabled=false)
  public void Extractresponse() {
	 Response res = 
	  given().baseUri("https://api.getpostman.com").header("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5").
	  when()
	 .get("/workspaces")
	 .then().extract().response();
	 System.out.println("workspaces names are:"+" "+res.asString());
	 
	 
  }
 
 @Test(enabled=false)
 public void extract_from_particularlocation() {
	 Response res = 
			  given().baseUri("https://api.getpostman.com").header("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5").
			  when()
			 .get("/workspaces")
			 .then().extract().response();
			//System.out.println("name of workspace is:"+ res.path("workspaces[0].name"));
	 JsonPath json=new JsonPath(res.asString());
	System.out.println( json.getString("workspaces[0].name"));
 }
			 
	 
 
 
 @Test(enabled=true)
 public void validatetime() {
	 given().baseUri("https://api.getpostman.com").header("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5").
	  when()
	 .get("/workspaces")
	 .then().log().all()
	// .assertThat().time(Matchers.is(Matchers.greaterThanOrEqualTo(3000l)).body("workspaces[1].name",Matchers.is(Matchers.equalTo("My Workspace"))));
	 //.assertThat().time(is(greaterThanOrEqualTo(2000l))).body("workspaces[0].name",is(equalTo("My Workspace")));	
	 .assertThat().time(greaterThanOrEqualTo(2000l)).body("workspaces[0].name", equalTo("My Workspace"));
 }
 
 @Test(enabled=false)
 public void headers() {
	 
			  given().baseUri("https://api.getpostman.com").header("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5").
			  when()
			 .get("/workspaces")
			 .then().log().headers();

  
}
 
 @Test(enabled=false)
 public void blacklistheader() {
	 
			  given().baseUri("https://api.getpostman.com").header("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5")
			 .config(config.logConfig(LogConfig.logConfig().blacklistHeader("x-api-key"))).log().all().when().get("/workspaces");
			  
}
 
 @Test(enabled=true)
 public void blacklistheaders() {
	 Set<String>value=new HashSet<String>();
	 value.add("x-api-key");
	 value.add("Accept");
	 
			  given().baseUri("https://api.getpostman.com").header("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5")
			 .config(config.logConfig(LogConfig.logConfig().blacklistHeaders(value))).log().all().when().get("/workspaces");
			  
}
}
