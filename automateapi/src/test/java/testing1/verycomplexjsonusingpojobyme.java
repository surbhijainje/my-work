package testing1;

import static io.restassured.RestAssured.requestSpecification;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automateapi.body;
import automateapi.finalpojo;
import automateapi.header;
import automateapi.info;
import automateapi.item;
import automateapi.request;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class verycomplexjsonusingpojobyme {
	@BeforeClass 
	public void beforeclass() {
	RequestSpecBuilder rsb=new RequestSpecBuilder();
	rsb.setBaseUri("https://api.getpostman.com").addHeader("x-api-key","PMAK-637489763da6e837adc433d6-2438ef243e78b152b22885e3bd36811209").
	setContentType("application/json; charset=utf-8");
	
	requestSpecification=rsb.build();
	
	ResponseSpecBuilder resb=new ResponseSpecBuilder();
	resb.expectStatusCode(201)
	 .expectContentType(ContentType.JSON)
	.expectResponseTime(Matchers.lessThan(4000l)).build();
}
  @Test
  public void complex_json() {
	  finalpojo fp=new finalpojo();
	  info in=new info();
	  in.setName("Test Collection");
	  in.setDescription("This collection makes a request to the Postman Echo service");
	  in.setSchema("https://schema.getpostman.com/json/collection/v2.1.0/collection.json");
	  
	
	 
	item it=new item();
	body bo= new body();
	
	bo.setMode("raw");
	bo.setRaw("data123");
	
	header head=new header();
	
	head.setKey("Content-Type");
	head.setValue("application/json");
	
	 List<header>HEAD=new ArrayList<header>(); 
	 HEAD.add(head);
		
		request req=new request();
		req.setUrl("https://postman-echo.com/post");
		req.setMethod("post");
		req.setHeader(HEAD);
		req.setDescription("This is sample POST Request");
		req.setBody(bo);
		it.setRequest(req);
		it.setName("Sample POST Request");	
		
		List<item> ite=new ArrayList<item>();
		ite.add(it);
		
		item it2=new item();
		it2.setName("This is a folder");
		it2.setItem(ite);
		
		
		List<item> it3= new ArrayList<item>();
		it3.add(it2);
		item its2=new item();
		its2.setItem(it3);
		
		 
		RestAssured.given().body(its2).log().all().when().post("/collections").then().log().all();
}
}
