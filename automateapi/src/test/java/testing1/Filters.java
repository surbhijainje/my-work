package testing1;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class Filters {
	@BeforeClass
	public void beforeclass() {
	RequestSpecBuilder rsb=new RequestSpecBuilder();
	rsb.setBaseUri("https://postman-echo.com")
	.addFilter(new RequestLoggingFilter(LogDetail.URI))
	.addFilter(new ResponseLoggingFilter(LogDetail.BODY));
	
	requestSpecification=rsb.build();
	
	ResponseSpecBuilder resb=new ResponseSpecBuilder();
	resb.expectStatusCode(200)
	.expectContentType(ContentType.JSON)
	.expectResponseTime(Matchers.lessThan(4000l)).build();
	
	}

	
  @Test(enabled=false)
  public void filter() {
	 when().get("/get").then();
  }
  
  @Test
  public void specific_filter() {
	 when().get("/get");
}
  @Test(enabled=false)
  public void file_filter() throws FileNotFoundException {
	  PrintStream fos=new PrintStream(new File("loginfo.log"));
	 // given().filter(new RequestLoggingFilter(fos));
	  //given(). filter(new ResponseLoggingFilter(fos)).when().get("/get");
	  given().filter(new ResponseLoggingFilter(LogDetail.BODY,fos)).when().get("/get");
}
}
