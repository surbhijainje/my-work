package framework;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class spotify_api {
	String access_token="BQAYp-sDRQwkXZ5TUi6j6WoCk11e86upYKxccTfNduwF6B_rAomZiOsv5oMR0bGTK09g-qa0JMnJSgt9lA5t9YiZ7uAKNOktXpbarfez23TKPYQKmjxf_O83QH2p0ineAmyMFgIQT8DELkObiZ-ML2feCncqpwxlEGZZMiPSK-Jwjde1GIYirBtXaEWh8nKUVa2Q88R3i6oimCOwGdARjyEMD-W9v-pcPuZb8m_WyxE_7yKtGisFC1bWkyREDLGqnAtu68Ii15aEMbeJ";
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
		
  @Test(enabled=false)
  public void create_playlist() {
	  String payload= "{\n"
	  		+ "  \"name\": \"Hippo1 Playlist\",\n"
	  		+ "  \"description\": \"Hippo1 playlist description\",\n"
	  		+ "  \"public\": false\n"
	  		+ "}";
	  given().body(payload).when()
	  .post("/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists").then().log().all();
	  
  }
  
  @Test
  public void get_playlist() {
	  given().when().get("/v1/playlists/66t7CObnlQ5yvh2ynuJSTG")
	  .then().log().all();
  }
  
  @Test(enabled=false)
  public void update_playlist() {
	  String payload="{\n"
	  		+ " \"name\": \"Updated Playlist Name\",\n"
	  		+ "  \"description\": \"Updated playlist description\",\n"
	  		+ "  \"public\": false\n"
	  		+ "}";
	  given().body(payload).when()
	  .put("/v1/playlists/66t7CObnlQ5yvh2ynuJSTG").then().log().all();
	  
  }
  
  @Test(enabled=false)
  public void create_playlist_without_name() {
	  String payload="{\n"
	  		+ "  \"name\": \"\",\n"
	  		+ "  \"description\": \"New playlist description\",\n"
	  		+ "  \"public\": false\n"
	  		+ "}";
	  given().body(payload).when()
	  .post("/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists").then().log().all();
}
}
