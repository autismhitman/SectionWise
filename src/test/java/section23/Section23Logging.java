package section23;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Section23Logging {
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void seclogging() throws FileNotFoundException {
		
		PrintStream printStream = new PrintStream("log.log");
		
		RequestSpecBuilder reqSpec= new RequestSpecBuilder()
				.addFilter(new RequestLoggingFilter(LogDetail.BODY, printStream))
				.addFilter(new ResponseLoggingFilter(LogDetail.STATUS, printStream));
		
		requestSpecification = reqSpec.build();
		
		ResponseSpecBuilder responseSpec= new ResponseSpecBuilder();
				 
				
				
		
		responseSpecification = responseSpec.build();
		
	}
	
	
	 
	/*
	 * public void checkLoggin() {
	 * 
	 * given().baseUri("http://localhost:3000") .filter(new
	 * RequestLoggingFilter(LogDetail.HEADERS)) .filter(new
	 * ResponseLoggingFilter(LogDetail.STATUS)) .when() .get("/employees")
	 * .then().statusCode(200); }
	 */
	
	@Test
	public void checkLoggin1() {
		
		given().spec(requestSpecification).baseUri("http://localhost:3000")
		  .when()
		.get("/employees")
		.then()
		.spec(responseSpecification).assertThat().statusCode(200);
	}

}
