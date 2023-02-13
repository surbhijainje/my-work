package testing1;

import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automateapi.simplepojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class pojo_concept1 {
	

	@BeforeClass
	public void beforeclass() {	
		
			RequestSpecBuilder rsb=new RequestSpecBuilder();
			rsb.setBaseUri("https://36c15fbb-29c3-400e-a641-b909c45fabf8.mock.pstmn.io").setContentType("application/json; charset=utf-8");
			
			requestSpecification=rsb.build();
			
			ResponseSpecBuilder resb=new ResponseSpecBuilder();
			resb.expectStatusCode(200)
			 .expectContentType(ContentType.JSON)
			.expectResponseTime(Matchers.lessThan(4000l)).build();
	}
			
			
  @Test
  public void getters_setters() {
	 simplepojo sp=new simplepojo("value1","value2");
	  
	 // simplepojo sp1=new simplepojo();
	 // sp1.setKey1("value1");
	 // sp1.setKey2("value2");
	  given().body(sp).when().log().all().post("/post-pojo").
	  then().log().all().
	  assertThat().body("key1",Matchers.equalTo(sp.getKey1()));
  }
}