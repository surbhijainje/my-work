package testing1;

import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import groovyjarjarantlr.collections.List;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class AutomateJsonArray {
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder rsb=new RequestSpecBuilder();
		rsb.setBaseUri("https://36c15fbb-29c3-400e-a641-b909c45fabf8.mock.pstmn.io")
		.addHeader("x-mock-match-request-body", "true") .setContentType("application/json;charset=utf-8")
		.log(LogDetail.ALL);
		RestAssured.requestSpecification=rsb.build();
		
 	ResponseSpecBuilder resb=new ResponseSpecBuilder();
		resb.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.expectResponseTime(lessThan(4000l))
		.log(LogDetail.ALL);
		RestAssured.responseSpecification =resb.build();
		
	}
	
  @Test
  public void jsonarray() {
	  HashMap<String,String>obj1=new  HashMap<String,String>();
	  obj1.put("id", "3000");
	  obj1.put("name", "Ram");
	  
	  HashMap<String,String>obj2=new  HashMap<String,String>();
	  obj2.put("id", "3001");
	  obj2.put("name", "Sita");
	  
	  List<HashMap<String,String>> jsonarray=new ArrayList<HashMap<String,String>>();
	  jsonarray.add(obj1);
	  jsonarray.add(obj2);
	  
	  
	  RestAssured.given().body(jsonarray)
	  .when().post("/post").then()
	  .assertThat().body("msg",Matchers.equalTo("successfully created data"));
	  
  }
}
