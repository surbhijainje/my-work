package specbuilder;

import static io.restassured.RestAssured.given;
import static specbuilder.specbuilder1.getrequestspec;

import io.restassured.response.Response;

public class generic_methods  {
	static	String  access_token="BQCTQTCjIMH_AEiirTv6PHX8plOWcNXct7k3ZtK4CciYs9ad6xdn9u0F-iYTvDP7r_Sj2tTbEJ4nI2EF0emCR2Ahfd20NtuKN7cp0UF4uagp_POWpTTf86_8-8lyvOM1petLbKg-_TMh3tO08YI-6T9xYmFvkVMIz9uuEC8IXxW_rWSzh5gC5TG6N0Ho76uYnXZDfCgqOArlM8HfChbr-R8EyztXbEoU_rn57V1T6xrFrXw4iMivrFktaNa4qUek3Xas7hVVsViv46JB";
	

	public static Response post(Object withpojo,String path,String access_token ) {
	
			return given(getrequestspec())
					  .body(withpojo).header("Authorization","Bearer"+" "+access_token).
					  when().post(path)
					  .then().spec(specbuilder1.getresponsespec()).extract().response();
		
	}
	
	
	
	/*
	 * public static Response post(Object withpojo,String token,String path ) {
	 * return given(getrequestspec())
	 * .body(withpojo).header("Authorization","Bearer"+" "+token). when().post(path)
	 * .then().spec(specbuilder1.getresponsespec()).extract().response(); }
	 */
	 
	

		
	
	public static Response get(String path,String access_token) {
		return given(getrequestspec()).header("Authorization","Bearer"+" "+access_token) .                            //66t7CObnlQ5yvh2ynuJSTG
				  when().get(path)
				  .then().spec(specbuilder1.getresponsespec()).extract().response();
	}
	
	
	public static Response update(Object withpojo,String path,String access_token) {
		return given(getrequestspec()).body(withpojo).header("Authorization","Bearer"+" "+access_token).
				  when().put(path)                                                                                   //66t7CObnlQ5yvh2ynuJSTG
				  .then().spec(specbuilder1.getresponsespec()).log().all().extract().response();
	
	}
}

