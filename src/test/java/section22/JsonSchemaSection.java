package section22;

import org.testng.annotations.Test;
 
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
public class JsonSchemaSection {
	
	
	@Test
	public void checkSchema() {
		
		given()
			.baseUri("http://localhost:3000")
			.when()
			.get("/employees")
			.then()
			.assertThat()
			.body(matchesJsonSchemaInClasspath("sc.json") );
		
		System.out.println(System.getProperty("user.dir"));
		
	}
	
	 

}
