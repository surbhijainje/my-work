package specbuilder;

import java.time.Instant;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class token_manager extends config_loader{
private static String access_token;
private static Instant Expiration_time;

	public static Response Renew_token() throws Exception {
		HashMap<String,String>formsdata=new HashMap<String,String>();
		init();
		formsdata.put("grant_type",prop.getProperty("grant_type"));
		formsdata.put("refresh_token",prop.getProperty("refresh_token"));
		formsdata.put("client_id",prop.getProperty("client_id"));
		formsdata.put("client_secret",prop.getProperty("client_secret"));
		
		Response response=RestAssured.given().baseUri("https://accounts.spotify.com")
		.contentType(ContentType.URLENC).formParams(formsdata).log().all()
		.when().post("/api/token")
		.then().spec(specbuilder1.getresponsespec())
		.extract().response();
		
		if(response.statusCode()!=200) {
			throw new RuntimeException("Renew token Expired");       //assertion
			
		}
		return response;
		
		
		
		
	}
	
	public static String Get_token() throws Exception {
		
		
    
    // try {
     if( access_token==null || Instant.now().isAfter(Expiration_time)) {
    	 System.out.println("Renewing token");
     
     Response response = Renew_token();
	 access_token = response.path("access_token");
     int expiry_time=  response.path("expires_in");
      Expiration_time = Instant.now().plusSeconds(expiry_time);
     }
		
		
	
	else {
		System.out.println("token is good to use");
	}
    // }
	/*
	 * catch(Exception e){ throw new
	 * RuntimeException("ABORT!!!Failed to get token"); }
	 */
     return access_token;
	}
	
}

