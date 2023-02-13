package testing1;

import static io.restassured.RestAssured.requestSpecification;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automateapi.header;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import verycomplexjsonpojoclasses.Getrequest;
import verycomplexjsonpojoclasses.Postrequest;
import verycomplexjsonpojoclasses.body;
import verycomplexjsonpojoclasses.collection;
import verycomplexjsonpojoclasses.infopojo;
import verycomplexjsonpojoclasses.item;
import verycomplexjsonpojoclasses.item1;
import verycomplexjsonpojoclasses.mainobject;
import verycomplexjsonpojoclasses.request;
import verycomplexjsonpojoclasses.request1;

public class verycomplexjsonpojobymam {
	@BeforeClass 
	public void beforeclass() {
	RequestSpecBuilder rsb=new RequestSpecBuilder();
	rsb.setBaseUri("https://api.getpostman.com").addHeader("x-api-key","PMAK-637489763da6e837adc433d6-2438ef243e78b152b22885e3bd36811209").
	setContentType(ContentType.JSON);
	
	requestSpecification=rsb.build();
	
	ResponseSpecBuilder resb=new ResponseSpecBuilder();
	resb.expectStatusCode(201)
	 .expectContentType(ContentType.JSON)
	.expectResponseTime(Matchers.lessThan(4000l)).build();
}
  @Test
  public void payload() {
	  //info
	  infopojo ip=new infopojo("test Collection", "This collection makes a request", "https://schema.getpostman.com/json/collection");
	  
	  //body
	  body bo= new body("raw", "data\\\":\\\"123\\");
	  
	  //header
   header hd=new header();
   hd.setKey("Content-Type");
   hd.setValue("application/json");

//creating header list
   List<Object> head=new ArrayList<Object>();
   head.add(hd);

  //request
  request req =new request("https://postman-echo.com/post", "POST", head,bo,"This is sample POST Request");
  
  
  //item1
	 item1 it1=new item1();
	 it1.setName("Sample POST Request");
	 it1.setRequest(req);
	 
	 //creating item1 list
	 List<Object>item1=new ArrayList<Object>();
	 item1.add(it1);
	 
	 //request1
	 request1 req1 =new request1("https://postman-echo/get", "GET", "This is sample GET Request");
	 
	  // creating first object of item array list	 
			Postrequest pr=new Postrequest();
			pr.setName("This is a folder");
			pr.setItem(item1);
			
			
	 //creating last object of item array list	
		Getrequest gr=new Getrequest();
		gr.setName("Sample GET Request");
	    gr.setRequest(req1);
	
	
	 
		
		//creating item array
		 List<Object>items=new ArrayList<Object>();	
		 items.add(pr);
		 items.add(gr);
	
	 
	 //collection
	 collection coll=new collection();
	 coll.setInfo(ip);
	 coll.setItem(items);
	 
	 //mainobject
	 mainobject mo=new mainobject();
	 mo.setCollection(coll);
	 
	 RestAssured.given().body(mo).log().all().when().post("/collections").then().log().all();
  }
}

                                  // REQUEST BODY

/*
 * { "collection": {
 * 
 * a "info": {
 * 
 * "name": "Test Collection", "description":
 * "This collection makes a request to the Postman Echo service to get a list of request headers sent by an HTTP client."
 * , "schema":
 * "https://schema.getpostman.com/json/collection/v2.1.0/collection.json" },
 * 
 * b "item": [
 * 
 * {
 * 
 * 1. "name": "This is a folder",
 * 
 * 2. "item1": [ { "name": "Sample POST Request",
 * 
 * "request":{
 * 
 * 1 "url": "https://postman-echo.com/post", 2 "method": "POST",
 * 
 * 3 "header": [ { "key": "Content-Type", "value": "application/json" } ],
 * 
 * 
 * 4 "body": { "mode" : "raw", "raw" : "{\"data\":\"123\"}" },
 * 
 * 
 * 5 "description": "This is sample POST Request" } } ] },
 * 
 * 
 * { 3. "name1" :"Sample GET Request",
 * 
 * "request1": {
 * 
 * "url": "https://postman-echo/get", "method": "GET", "description":
 * "This is sample GET Request" } } ] }
 */