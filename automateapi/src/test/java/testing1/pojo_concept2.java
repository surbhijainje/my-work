package testing1;

import static io.restassured.RestAssured.requestSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automateapi.mainworkspace;
import automateapi.workspace;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class pojo_concept2 {

 @BeforeClass
  public void beforemethodTest() {
	  RequestSpecBuilder rsb=new RequestSpecBuilder();
		rsb.setBaseUri("https://api.getpostman.com")
		.addHeader("x-api-key","PMAK-637489763da6e837adc433d6-2438ef243e78b152b22885e3bd36811209")
		.setContentType(ContentType.JSON);
		
		requestSpecification=rsb.build();
		
		ResponseSpecBuilder resb=new ResponseSpecBuilder();
		resb.build();
		//resb.expectStatusCode(201)
		//resb .expectContentType(ContentType.JSON)
		//.expectResponseTime(Matchers.lessThan(4000l)).build();
}
  

  @Test(dataProvider ="test")
  public void getters_settersTest(String name,String type,String description) {
	  workspace nws=new workspace(name,type,description);
	  mainworkspace mws=new mainworkspace(nws);
	   RestAssured.given().body(mws).log().all()
	  .when()
	  .post("/workspaces")
	  .then().log().all();//.extract().response().as(mainworkspace.class);
			 }
  
  @DataProvider(name="test")
  public  Object[][]testdata(){
	
	return new Object[][]{
			{"youngerWorkspace","personal","This is a my personal workspace"},
			{"olderWorkspace","personal","This is a test personal workspace"}
	};
	  
  }
}
