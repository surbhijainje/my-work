package specbuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import pojo_classes_create_playlist.PlaylistWithPojo;
import testing1.responsespecbuilder;

public class playlist_with_generic_methods extends config_loader {
	 
		
  
@Test(description="getting the playlist")
@Description("should get status code 200")
@Link("https://example.org")
@Link(name = "allure", type = "mylink")
@Issue("123")
@TmsLink("12")
public void get_playlist_withpojo() throws Exception {
	  PlaylistWithPojo withpojo=new PlaylistWithPojo();
	 // withpojo = body("surbhi2", "beauty1 songs", false);
	 
	  PlaylistWithPojo	responses=Baseclass2.get("66t7CObnlQ5yvh2ynuJSTG" ).as(PlaylistWithPojo.class);
	
	  
	 // assertThat(responses.getName(),equalTo(withpojo.getName()));
	  
  }
  

@Test
public void update_playlist_withpojo() throws Exception {
	 PlaylistWithPojo withpojo = body("surbhi2", "beauty1 songs", false);
	   Baseclass2.update(withpojo,"66t7CObnlQ5yvh2ynuJSTG");
	
	}
	  
	@Test
	  public  void  create_playlist_withpojo() throws Exception {
		
		 PlaylistWithPojo withpojo = body("surbhi", "beauty songs", false);
		  
		  Response	responses= Baseclass2.post(withpojo );
		 // assertThat(responses.getName(),equalTo(withpojo.getName()));
		  status_code(responses.statusCode(), 201);
	 }
	
	
	
	public PlaylistWithPojo body(String name,String Description,boolean _public) {
		return new PlaylistWithPojo().setName(name)
				.setDescription(Description)
				.setPublic(_public);
	}
	
	public void status_code( int actualstatuscode, int expstatuscode) {
	
		assertThat(actualstatuscode,equalTo(expstatuscode));
		
		
	}
	
 
}

	 

