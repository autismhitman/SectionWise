package section13;



import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;
 
import static  org.hamcrest.MatcherAssert.assertThat;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;
public class Section13 {
	
	 
	
	@Test
	public void method1() {
	 given().spec(CodeLayer.makeRequest())
			 .when()
			 .get("/employees")
			 .then().spec(CodeLayer.checkResponse()); 
 	
	}
	
	@Test
	public void queryTest() {
		
		QueryableRequestSpecification qrs = SpecificationQuerier.query(CodeLayer.makeRequest());
				
				System.out.println(qrs.getBaseUri());
				
	}
	
	
	
}
