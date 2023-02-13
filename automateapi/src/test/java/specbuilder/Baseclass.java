package specbuilder;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import pojo_classes_create_playlist.PlaylistWithPojo;
import static  specbuilder.specbuilder1.*;

public class Baseclass  {
	static String access_token="BQC-X9MY-sM839LAfz6YgKIkZuQQkn9pMC7tyO24s6-H2z20cEzLJKxiD4XAEYDsibmPqitRkCHBg5dYLj3xarKYjc6RTeoZP4BdGWZXKhKVmkRs-wYLQS3bRI9DFgw0SwWQ8ZGF7iFzhXmWI8Em36cRewYuCA-klJ-X3v4UT_Bw2by2uG8q9qDI14Lzj6Y966hMmhI_mdDyKgTPQ4wS79szqsBCQzVsSmNpFeMvR67Ik0AeMgAfXiz08P000hw-MCp8jrMUxyTNhIDT";

	public static Response post(PlaylistWithPojo withpojo ) {
		return given(getrequestspec())
				  .body(withpojo).header("Authorization","Bearer"+" "+access_token).
				  when().post("/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists")
				  .then().spec(specbuilder1.getresponsespec()).extract().response();
	}
	
	public static Response post(PlaylistWithPojo withpojo,String token ) {
		return given(getrequestspec())
				  .body(withpojo).header("Authorization","Bearer"+" "+token).
				  when().post("/v1/users/31v2gus2luj4tbr7y6gnzc2xrtai/playlists")
				  .then().spec(specbuilder1.getresponsespec()).extract().response();
	}
	
	public static Response get(String playlistid) {
		return given(getrequestspec()).header("Authorization","Bearer"+" "+access_token) .                            //66t7CObnlQ5yvh2ynuJSTG
				  when().get("/v1/playlists/"+ playlistid)
				  .then().spec(specbuilder1.getresponsespec()).extract().response();
	}
	
	
	public static Response update(PlaylistWithPojo withpojo,String playlistid) {
		return given(getrequestspec()).body(withpojo).header("Authorization","Bearer"+" "+access_token).
				  when().put("/v1/playlists/"+playlistid)                                         //66t7CObnlQ5yvh2ynuJSTG
				  .then().spec(specbuilder1.getresponsespec()).log().all().extract().response();
	
	}
}

