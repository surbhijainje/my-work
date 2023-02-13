package framework;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import pojo_classes_create_playlist.PlaylistWithPojo;

public class create_playlist_with_pojo_classes {
	String access_token="BQA4TEgAi43_lI0kUvlgbq2xC8y3F5yS4_LOirLaXkmlKxHqBrJPZIIhQfwduodkpk_N87lhQ6xrBsnoku3RCIoHKDH2EX52I-DfqfZVdGLdzXs2QoW_OjyYXFHDEfQB6mr4btkbOpk8SNg6gYK6_JZ1gTeB5yWsOK-8Xjub4PCFqR8Rv_GP9B9uFiTDuxy2ocpTpvO0rtEhXpQ4BLNDFDctBBB2jsnLQ5a88yrwrL0SI12FafqTB_zgGvRhkcdcw6cIsh-hzF_J7OwR";
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder rsb=new RequestSpecBuilder();
		rsb.setBaseUri("https://api.spotify.com")
		.addHeader("Authorization","Bearer"+" "+access_token) .setContentType("application/json;charset=utf-8")
		.log(LogDetail.ALL);
		requestSpecification=rsb.build();
		
 	ResponseSpecBuilder resb=new ResponseSpecBuilder();
		resb.expectStatusCode(200).build();
		
		}
	
  @Test(enabled=false)
  public void create_playlist_withpojo() {
	  PlaylistWithPojo withpojo=new PlaylistWithPojo();
	  withpojo.setName("beauty");
	  withpojo.setDescription("beauty songs");
	  withpojo.setPublic(false);
	  
	 PlaylistWithPojo responses = given().body(withpojo).
	  when().post("/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists")
	  .then().log().all().extract().response().as(PlaylistWithPojo.class);
	 
	 assertThat(responses.getName(),equalTo(withpojo.getName()));
	
  }
  
  @Test(enabled=true)
  public void get_playlist_withpojo() {
	  PlaylistWithPojo withpojo=new PlaylistWithPojo();
	 
	 PlaylistWithPojo responses = given().
	  when().get("/v1/playlists/66t7CObnlQ5yvh2ynuJSTG")
	  .then().log().all().extract().response().as(PlaylistWithPojo.class);
	 
	 //assertThat(responses.getName(),equalTo(withpojo.getName()));
  }
  
	
  @Test
  public void update_playlist_withpojo() {
	  PlaylistWithPojo withpojo=new PlaylistWithPojo();
	  withpojo.setName("Hippo");
	  withpojo.setDescription("Hippo songs");
	  withpojo.setPublic(false);
	  
		/* PlaylistWithPojo updatedresponse = */ given().body(withpojo).when()
	  .put("/v1/playlists/66t7CObnlQ5yvh2ynuJSTG").
	  then().log().all();//.extract().response().as(PlaylistWithPojo.class);

    //assertThat(updatedresponse.getName(), equalTo(withpojo.getName()));
	  
}
}
