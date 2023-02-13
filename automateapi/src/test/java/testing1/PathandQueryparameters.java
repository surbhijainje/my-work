package testing1;

import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class PathandQueryparameters {
	@BeforeClass()
	public void beforeclass() {
		RequestSpecBuilder rsb=new RequestSpecBuilder();
		//rsb.setBaseUri("https://postman-echo.com")
		rsb.setBaseUri("https://reqres.in/api")
		//.addHeader("x-api-key","PMAK-631b1eb94f93c91a5892cb3b-b163ced2d8bf933636270f8bbc097516f5")
		.log(LogDetail.ALL);
		RestAssured.requestSpecification=rsb.build();
		
		ResponseSpecBuilder resb=new ResponseSpecBuilder();
		resb.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.expectResponseTime(lessThan(4000l))
		.log(LogDetail.ALL);
	}
  @Test(enabled=false)
  public void queryparameter() {
	 // RestAssured.given().param("foo","bar").           generic way of giving query param
	  RestAssured.given().queryParam("foo","bar"). //specific way of giving query param
	  
	  when().get("/get").then();
  }
  
  @Test(enabled=false)
  public void multiple_query_param() {
		/*
		 * HashMap<String,String>query=new HashMap<String,String>(); query.put("foo",             //giving multiple query params
		 * "bar"); query.put("foo1", "bar1"); query.put("foo2", "bar2");
		 * 
		 * 
		 * RestAssured.given().queryParams(query).when().get("/get").then();
		 */

	  RestAssured.given().queryParam("foo", "bar1","bar2","bar3").when().get("/get").then();//giving different values with single query param
  }
  
  @Test
  public void path_parameter() {
	  RestAssured.given().pathParam("users", "2").when().get("/users/{users}").then();
  }
}
