package specbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import  io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class specbuilder1 {
	
	
	public static RequestSpecification getrequestspec() {
		return new RequestSpecBuilder().
		setBaseUri("https://api.spotify.com")
		
		.setContentType("application/json;charset=utf-8")
		.log(LogDetail.ALL).
		build();
	}
		
 	
		

    public static ResponseSpecification getresponsespec() {
    	return new ResponseSpecBuilder().
    			
		//expectStatusCode(200).
		//expectContentType(ContentType.JSON).
		log(LogDetail.ALL).
		build();
    
    	 
    }
	}
