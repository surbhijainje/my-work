package specbuilder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static  specbuilder.specbuilder1.*;

import org.testng.annotations.Test;

import pojo_classes_create_playlist.PlaylistWithPojo;

public class playlistrcreationwithspecbuilder {                                //without before class,using specbuilder1 class
  @Test
  public void create_playlist() {
	  PlaylistWithPojo withpojo=new PlaylistWithPojo();
	  withpojo.setName("beauty");
	  withpojo.setDescription("beauty songs");
	  withpojo.setPublic(false);
	  
	PlaylistWithPojo responses=given(getrequestspec()).body(withpojo).
	  when().post("/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists")
	  .then()
	  .spec(getresponsespec())
	 .log().all().extract()
	 .response().as(PlaylistWithPojo.class);
	 
	assertThat(responses.getName(),equalTo(withpojo.getName()));
	
  }
}
