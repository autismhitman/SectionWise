package section10;

 
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Section10 {
	
	
	@Test
	public void hamcrestContainsMethods3() {
		
	 
			 given()
			.baseUri("http://localhost:3000")
			.when()
			.get("/employees")
			.then().body(
					"[0]", hasKey("id"),
					"[1]", hasValue(2),
					"[2]",hasEntry("id",3),
					"[2]",hasEntry("email","ramanlyngdoh@email.com")
					);
	  
	}
	
	
	@Test
	public void hamcrestContainsMethods2() {
		
	 
			 given()
			.baseUri("http://localhost:3000")
			.when()
			.get("/employees")
			.then().body(
					"firstname",not(emptyArray() )
					, "firstname",is(not(empty()))
					, "firstname", everyItem(startsWith("S"))
					);
	  
	}
	
	@Test
	public void hamcrestContainsMethod1() {
		
	 
			 given()
			.baseUri("http://localhost:3000")
			.when()
			.get("/employees")
			.then().body("firstname", containsInAnyOrder( "Sam","Ram","Raman"));
	 
	}
	
	@Test
	public void validateDatatusCode() {
		
		given()
			.baseUri("http://localhost:3000")
			.when()
			.get("/employees")
			.then()
			.log().all()
			.assertThat()
			.statusCode(200);
	}
	
	@Test
	public void validateNameList() {
		
		given()
			.baseUri("http://localhost:3000")
			.when()
			.get("/employees")
			.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body( 
					"firstname", hasItems("Sam","Ram","Raman"),
				    "[0].firstname",equalTo("Sam"),
				    "$.size()",equalTo(3)
				  );
		  
	}
	
	@Test
	public void FetchResponse() {
		
	Response response = 
			 given()
			.baseUri("http://localhost:3000")
			.when()
			.get("/employees")
			.then().extract().response();
			 
	
	 int actualSize= response.jsonPath().getList("firstname").size();
	 Assert.assertEquals(actualSize,3);
	}
	
	
	
}
