package testing1;

import static io.restassured.RestAssured.requestSpecification;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class replacement_of_HashMap {
	@BeforeClass
	public void beforeclass() {	
		
			RequestSpecBuilder rsb=new RequestSpecBuilder();
			rsb.setBaseUri("https://postman-echo.com").setContentType("application/json; charset=utf-8");
			
			requestSpecification=rsb.build();
			
			ResponseSpecBuilder resb=new ResponseSpecBuilder();
			resb.expectStatusCode(200)
			 .expectContentType(ContentType.JSON)
			.expectResponseTime(Matchers.lessThan(4000l));
			
			}
	
  @Test
  public void object_node() throws JsonProcessingException {
	  //batters
	  ObjectMapper om=new ObjectMapper();
	  ObjectNode mainobject = om.createObjectNode();         //create hashmap
	  mainobject.put("id", "1008");
	  mainobject.put("type","pink");
	  
	  ObjectNode nestedobject1 = om.createObjectNode();           //create another hashmap
	  nestedobject1.put("id", "1009");
	  nestedobject1.put("type","chocolate");
	  
	  ArrayNode mainsobject = om.createArrayNode();    ///create arraylist
	  mainsobject.add(nestedobject1);                  //adding hashmap to arraylist
	  mainsobject.add(mainobject);
	  
	  ObjectNode nestedobject2 = om.createObjectNode();   ///create another hashmap(batter)
	  nestedobject2.set("batter", mainsobject);
	  
	  
	 
	  
	  //toppings
	  
	 
	  ObjectNode mainobject1 = om.createObjectNode();         //create hashmap
	  mainobject1.put("id", "5001");
	  mainobject1.put("type","none");
	  
	  ObjectNode nestedobject4 = om.createObjectNode();           //create another hashmap
	  nestedobject4.put("id", "5002");
	  nestedobject4.put("type","Glazed");
	  
	  ArrayNode node = om.createArrayNode();    ///create arraylist
	  node.add(nestedobject4);
	  node.add(mainobject1);
	  
	 
	  //final hashmap
	  
	  ObjectNode finals = om.createObjectNode(); 
	  finals.put("name", "cake");
	  finals.put("id", "0001");
	  finals.put("type", "donut");
	  finals.set("batters", nestedobject2);
	  finals.set("toppings", node);
	  
	  String mainobjectstr = om.writeValueAsString(finals);
	  given().body(mainobjectstr).when().log().all().post("/post").then();
  }
}
