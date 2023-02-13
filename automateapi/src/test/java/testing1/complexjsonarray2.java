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

public class complexjsonarray2 {
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
		resb.build();}
		
		
  @Test
  public void comlexjson() {
	 List<Object>jsonarray=new ArrayList<Object>(); 
	
	 HashMap<String,Object>obj=new HashMap<String,Object>();
	 obj.put("id","1001");
	 obj.put("type","Regular");
	 List<Integer>jsonarray1=new ArrayList<Integer>(); 
	 jsonarray1.add(5);
	 jsonarray1.add(3);
	 HashMap<String,Object>obj1=new HashMap<String,Object>();
	 obj1.put("id", jsonarray1);
	 obj1.put("type","chocolate");
	 jsonarray.add(obj);
	 jsonarray.add(obj1);
	 
	 //batter
	 HashMap<String,Object>batter=new HashMap<String,Object>();
	 batter.put("batter",jsonarray );
	 
	 //batters
	// HashMap<String,Object>batters=new HashMap<String,Object>();
	 //batters.put("batters", batter);
	 
	 //topping
	  List<Object>jsonArray2=new ArrayList<Object>();
	  HashMap<String,String>obj4=new HashMap<String,String>();
	  HashMap<String,Object>obj5=new HashMap<String,Object>();
	  obj4.put("id", "5001");
	  obj4.put("type", "None");
	  obj5.put("id", "5002");
	  List<String>jsonArray3=new ArrayList<String>();
	  jsonArray3.add("test1");
	  jsonArray3.add("test2");
	  
	  obj5.put("type",jsonArray3);
	  
	  jsonArray2.add(obj4);
	  jsonArray2.add(obj5); 
	  
	  HashMap<String,Object>mainobj3=new HashMap<String,Object>();
		 
		
	  mainobj3.put("id", "0001");
	  mainobj3.put("type","donut");
	  mainobj3.put("name","Cake");
	  mainobj3.put("ppu",0.55);
	  mainobj3.put("batters", batter);
	  mainobj3.put("topping", jsonArray2);

	 
	 RestAssured.given().body(mainobj3)
	  .when().post("/post");
  }
}
