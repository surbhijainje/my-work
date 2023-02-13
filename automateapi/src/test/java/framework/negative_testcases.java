package framework;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import pojo_classes_create_playlist.PlaylistWithPojo;
import pojoclasseswithexptoken.Root_error;
import pojoclasseswithexptoken.inner_error;

public class negative_testcases {
	String access_token="BQAxpwEaoHK0FdXTtDk6LfamU6bc7j_i49C7nKYxMEfL30Ig9b68YVtjpq2pDWkWhpDdBwlhZLDNjEiWxD6NAYN9PPO42OHgnwjJVfUgRRF7iGwirV52lBctvFiSu85IBq5NeKV2DTuUKluJ3sZ945lTYaak2g3AfFeFiQGnSCjJCcT4UC-By71vdoFRgBoJs1HAJqqqD2u_0nZdwKxfjP9eZti4wcMbMHEo1jxDMxq2v6YmDp58C3WbaVfl3T2Q3eYV7QubBTDQdiiQ";
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder rsb=new RequestSpecBuilder();
		rsb.setBaseUri("https://api.spotify.com")
		.addHeader("Authorization","Bearer"+" "+access_token) .setContentType("application/json;charset=utf-8")
		.log(LogDetail.ALL);
		requestSpecification=rsb.build();
		
 	ResponseSpecBuilder resb=new ResponseSpecBuilder();
		resb//expectStatusCode(200)
		//.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL);
		responseSpecification =resb.build();}
	
	
  @Test
  public void withexptoken() {
	  PlaylistWithPojo withpojo=new PlaylistWithPojo();
	  withpojo.setName("Hippo");
	  withpojo.setDescription("Hippo songs");
	  withpojo.setPublic(false);
	  inner_error error=new inner_error();
	  Root_error error1=new Root_error();
	  error.setStatus(401);
	  error.setMessage("The access token expired");
	  error1.setError(error);
	  
	Root_error withexptokenresponse = given().body(withpojo).baseUri("https://api.spotify.com")
	  .header("Authorization","Bearer"+" "+"12345").contentType(ContentType.JSON)
	  .when().post("/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists")
	  
	  .then().log().all().extract().response().as(Root_error.class);  //deserialization
	
	//assertThat(withexptokenresponse.getError().getStatus(),equalTo(401));
	assertThat(withexptokenresponse.getError().getStatus(),equalTo(error1.getError().getStatus()));
	assertThat(withexptokenresponse.getError().getMessage(),equalTo(error1.getError().getMessage()));
			
	  
  }
  @Test(enabled=true)
  public void withemptyplaylistname() {
	  PlaylistWithPojo withpojo=new PlaylistWithPojo();
	  withpojo.setName("");
	  withpojo.setDescription("Hippo2 songs");
	  withpojo.setPublic(false);
	  Root_error error1=new Root_error();
	  inner_error error=new inner_error();
	  error.setStatus(400);
	  error.setMessage("Missing required field: name");
	  error1.setError(error);
	  
	Root_error withoutnameresponse = given().body(withpojo)
	  
	  .when().post("/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists")
	  .then().log().all().extract().response().as(Root_error.class);
	
	assertThat(withoutnameresponse.getError().getStatus(),equalTo(error1.getError().getStatus()));
	assertThat(withoutnameresponse.getError().getMessage(),equalTo(error1.getError().getMessage()));
}
}
