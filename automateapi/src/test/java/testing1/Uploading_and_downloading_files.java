package testing1;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class Uploading_and_downloading_files {
	
	@BeforeClass
	public void beforeclass() {
	RequestSpecBuilder rsb=new RequestSpecBuilder();
	rsb.setBaseUri("https://postman-echo.com");
	
	requestSpecification=rsb.build();
	
	ResponseSpecBuilder resb=new ResponseSpecBuilder();
	resb.expectStatusCode(200)
	.expectContentType(ContentType.JSON)
	.expectResponseTime(Matchers.lessThan(4000l));
	
	}
	
  @Test
  public void upload_files() {
	given().multiPart("fileuploaded",new File("json format.txt")).log().all()
	.when().post("/post").then().assertThat().statusCode(200);
  }
}
