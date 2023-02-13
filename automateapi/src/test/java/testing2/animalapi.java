package testing2;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.testng.annotations.Test;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class animalapi {
	
  
  @Test(priority=1)
  
	  public void file_filter_success1() throws FileNotFoundException {
	  PrintStream fos=new PrintStream(new File("reportsuccessinfo.log"));
	  given().baseUri("https://dog.ceo/api").filter((new RequestLoggingFilter(fos)))
	  .filter(new ResponseLoggingFilter(fos))
	  
	  .when().get("/breeds/list/all").then();
		 
		 
		
}
  @Test(priority=2)
  public void file_filter_fail1() throws FileNotFoundException {
	  PrintStream fos=new PrintStream(new File("reportfailinfo.log"));
	  given().baseUri("https://dog.ceo/api").filter((new RequestLoggingFilter(fos)))
	  .filter(new ResponseLoggingFilter(fos))
	  
	  .when().get("/breeds").then();
	  
}
  @Test(priority=3)
  public void file_filter_success2() throws FileNotFoundException {
	  PrintStream fos=new PrintStream(new File("reportsuccess2info.log"));
	  given().baseUri("https://world.openpetfoodfacts.org/api").filter((new RequestLoggingFilter(fos)))
	  .filter(new ResponseLoggingFilter(fos))
	  
	  .when().get("/v0/product/20106836.json").then();
}
  
  @Test(priority=4)
  public void file_filter_fail2() throws FileNotFoundException {
	  PrintStream fos=new PrintStream(new File("reportfail2info.log"));
	  given().baseUri("https://world.openpetfoodfacts.org/api").filter((new RequestLoggingFilter(fos)))
	  .filter(new ResponseLoggingFilter(fos))
	  
	  .when().get("").then();
}
}
