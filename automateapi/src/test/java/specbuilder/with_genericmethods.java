package specbuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import pojo_classes_create_playlist.PlaylistWithPojo;
import pojoclasseswithexptoken.Root_error;
import pojoclasseswithexptoken.inner_error;
import static specbuilder.generic_methods.*;

public class with_genericmethods extends generic_methods {
 
	static  String access_token="BQBT1XSSEugdhiBZvVxt4SDluUaZPMj5Pkem8ds1HX76yPcndYaRH2DJdATI_0VrCg70H8P4OfMaWhltzBOYINkd_ICFSnThJvB2esaArpCNlfuQFn87PpnzsxB_Thc49AUuIq611OfK3J7CyF8Zd-GCDXqLbOhnuPyU940idHsNc6jJPEk9voqZvmbgze430osPO8HX_yn2QGN-MDOAmjPe2yonc8Y64wgqkpvKsQsDS8sDoSLfuyRtV8r4sxRd_Q0HjylHYj0yXTgo";
		 @Test
		  public  void  create_playlist_withpojo() {
			  PlaylistWithPojo withpojo=new PlaylistWithPojo();
			  withpojo.setName("surbhi").
			  setDescription("beauty songs").
			  setPublic(false);
			  
			  PlaylistWithPojo	responses=post(withpojo,"/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists", access_token).as(PlaylistWithPojo.class);
			  assertThat(responses.getName(),equalTo(withpojo.getName()));
		 }
			  
			  @Test
				  public  void update_playlist_withpojo()
			  { PlaylistWithPojo withpojo=new
				  PlaylistWithPojo(); 
				  withpojo.setName("Hippo1")
				 .setDescription("Hippo1 songs")
				 .setPublic(false);
		PlaylistWithPojo responses=  update(withpojo,"/v1/playlists/66t7CObnlQ5yvh2ynuJSTG",access_token).as(PlaylistWithPojo.class);
		//assertThat(responses.getName(),equalTo(withpojo.getName()));
		}
			  
			  @Test
			  public void get_playlist() {
				  PlaylistWithPojo withpojo=new PlaylistWithPojo();
				  withpojo.setName("Hippo1");
PlaylistWithPojo responses=get("/v1/playlists/66t7CObnlQ5yvh2ynuJSTG",access_token ).as(PlaylistWithPojo.class);
				
				  
				  assertThat(responses.getName(),equalTo(withpojo.getName()));
				  
			  }
			  
			  @Test
			 public void createplaylist_withinvalidtoken() {
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
				  Root_error  with_invalidtoken_response = post(withpojo,"/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists",token ).as(Root_error.class);
				  assertThat(with_invalidtoken_response.getError().getStatus(),equalTo(error1.getError().getStatus()));
					assertThat(with_invalidtoken_response.getError().getMessage(),equalTo(error1.getError().getMessage()));
						
			  }
}


		
			
		


