package specbuilder;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import pojo_classes_create_playlist.PlaylistWithPojo;
import pojoclasseswithexptoken.Root_error;
import pojoclasseswithexptoken.inner_error;

public class withspecbuilder extends config_loader {
 
			
		 @Test
		  public  void  create_playlist_withpojo() throws Exception {
			  PlaylistWithPojo withpojo=new PlaylistWithPojo();
			  withpojo.setName("surbhi").
			  setDescription("beauty songs").
			  setPublic(false);
			  
			  PlaylistWithPojo	responses=Baseclass2.post(withpojo ).as(PlaylistWithPojo.class);
			  assertThat(responses.getName(),equalTo(withpojo.getName()));
		 }
			  
			  @Test
				  public  void update_playlist_withpojo() throws Exception
			  { PlaylistWithPojo withpojo=new
				  PlaylistWithPojo(); 
				  withpojo.setName("Hippo1")
				 .setDescription("Hippo1 songs")
				 .setPublic(false);
					 PlaylistWithPojo responses=  Baseclass2.update(withpojo,"66t7CObnlQ5yvh2ynuJSTG").as(PlaylistWithPojo.class);
		
		}
			  
			  @Test
			  public void get_playlist() throws Exception {
				  PlaylistWithPojo withpojo=new PlaylistWithPojo();
				  withpojo.setName("surbhi2");
				  PlaylistWithPojo	responses=Baseclass2.get("66t7CObnlQ5yvh2ynuJSTG" ).as(PlaylistWithPojo.class);
				
				  
				  assertThat(responses.getName(),equalTo(withpojo.getName()));
				  
			  }
			  
			//  @Test
			/* public void createplaylist_withinvalidtoken() {
				  String token = "12345";
				  PlaylistWithPojo withpojo=new
						  PlaylistWithPojo(); 
						  withpojo.setName("Hippo1")
						 .setDescription("Hippo1 songs")
						 .setPublic(false);
						  inner_error error=new inner_error();
						  Root_error error1=new Root_error();
						  error.setStatus(401);
						  error.setMessage("Invalid access token");
						  error1.setError(error);
				  Root_error  with_invalidtoken_response = Baseclass.post(withpojo,token ).as(Root_error.class);
				  assertThat(with_invalidtoken_response.getError().getStatus(),equalTo(error1.getError().getStatus()));
					assertThat(with_invalidtoken_response.getError().getMessage(),equalTo(error1.getError().getMessage()));
						
			  }*/
}


		
			
		


