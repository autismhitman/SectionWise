package section16;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Section16Files{
	
	@Test
	public void creatEmByString() {
		String file = "{\r\n"
				+ "\r\n"
				+ "    \"firstname\": \"Salman1\",\r\n"
				+ "    \"lastname\": \"Khan1\",\r\n"
				+ "    \"email\": \"sk1@email.com\"\r\n"
				+ "}";
		
      given().baseUri("http://localhost:3000").contentType(ContentType.JSON)
    	.body(file).log().all()
    	.when().post("/employees").then().log().all().assertThat().statusCode(201);
    }
   
	@Test
	public void creatEm() {
		File file = new File(".//src//test//java//section16//fileA.json");
		
      given().baseUri("http://localhost:3000").contentType(ContentType.JSON)
    	.body(file).log().all()
    	.when().post("/employees").then().log().all().assertThat().statusCode(201);
    }
	
	@Test
	public void creatEmpUsingMap() {
		Map<String, String> hmap = new HashMap<>();
		hmap.put("firstname", "SalmanMap");
		hmap.put("lastname", "Khan");
		hmap.put("email", "sk@email.com");
		
      given().contentType(ContentType.JSON)
    	.body(hmap).log().all()
    	.when().post("http://localhost:3000/employees").then().log().all().assertThat().statusCode(201);
    }

}
