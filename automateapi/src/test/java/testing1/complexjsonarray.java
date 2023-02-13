package testing1;

import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class complexjsonarray {
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder rsb=new RequestSpecBuilder();
		rsb.setBaseUri("https://36c15fbb-29c3-400e-a641-b909c45fabf8.mock.pstmn.io")
		.addHeader("x-mock-match-request-body", "success").setContentType(ContentType.JSON)
		.log(LogDetail.ALL);
		RestAssured.requestSpecification=rsb.build();
		
		ResponseSpecBuilder resb=new ResponseSpecBuilder();
		resb.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.expectResponseTime(lessThan(4000l)).log(LogDetail.ALL);
		resb.build();
		
		
	}
  @Test
  public void complexjsonaaray() {
		
	  
	 
	  
	  HashMap<String,String>obj2=new HashMap<String,String>();
	  HashMap<String,String>obj3=new HashMap<String,String>();
	  
	  obj2.put("id", "1001");
	  obj2.put("type", "Regular");
	  obj3.put("id", "1002");
	  obj3.put("type", "Chocolate");
	  
	  List <HashMap<String,String>>jsonArray=new ArrayList <HashMap<String,String>>();
	  
	
	  jsonArray.add(obj2);
	  jsonArray.add(obj3);              //array list is created
	 
	  
	  HashMap<String,List <HashMap<String,String>>>mainobj=new HashMap<String,List <HashMap<String,String>>>();
	  mainobj.put("batter", jsonArray);
	  
	  HashMap<String,Object>mainobj1=new HashMap<String,Object>();
	 // mainobj1.put("batters", mainobj);
	 
	  
	 
	  
	  //topping
	  
	  List<Object>jsonArray2=new ArrayList<Object>();
	  HashMap<String,String>obj4=new HashMap<String,String>();
	  HashMap<String,String>obj5=new HashMap<String,String>();
	  obj4.put("id", "5001");
	  obj4.put("type", "None");
	  obj5.put("id", "5002");
	  obj5.put("type", "Glazed");
	  
	  jsonArray2.add(obj4);
	  jsonArray2.add(obj5); 
	  
	  HashMap<String,List<Object>>mainobj2=new HashMap<String,List<Object>>();
	 // mainobj2.put("topping", jsonArray2);
	  
	  
	  
		
		  HashMap<String,Object>mainobj3=new HashMap<String,Object>();
		 
		
		  mainobj3.put("id", "0001");
		  mainobj3.put("type","donut");
		  mainobj3.put("name","Cake");
		  mainobj3.put("ppu",0.55);
		  mainobj3.put("batters", mainobj);
		  mainobj3.put("topping", jsonArray2);
		 
	  
	  RestAssured.given().body(mainobj3)
	  .when().post("/post");
						  
  }
}
