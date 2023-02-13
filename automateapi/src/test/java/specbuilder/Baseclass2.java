package specbuilder;

import org.testng.annotations.Test;
//import static specbuilder.token_manager.*;

import io.restassured.response.Response;
import pojo_classes_create_playlist.PlaylistWithPojo;
public class Baseclass2  {
	

  @Test
  public static Response post(PlaylistWithPojo withpojo ) throws Exception {
		return generic_methods.post(withpojo, "/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists",token_manager.Get_token());
	}
  
	@Test
	public static Response post(PlaylistWithPojo withpojo,String token,String path ) {
		return generic_methods.post(withpojo,"/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists","12345");
	}
	
	@Test
	public static Response get(String path) throws Exception {
		return generic_methods.get("/v1/playlists/66t7CObnlQ5yvh2ynuJSTG",token_manager.Get_token());
	}
	
	@Test
	public static Response update(PlaylistWithPojo withpojo,String path) throws Exception {
		
		return generic_methods.update(withpojo, "/v1/playlists/66t7CObnlQ5yvh2ynuJSTG",token_manager.Get_token());

}

}
