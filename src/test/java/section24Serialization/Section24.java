package section24Serialization;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.http.ContentType;

public class Section24 {
	
	@Test
	public void validateComplexArrayRequest() throws JsonProcessingException {
		
		
		ObjectMapper om = new ObjectMapper();
		ArrayNode an= om.createArrayNode();
		
		ObjectNode ho= om.createObjectNode();
		ho.put("id", "5001");
 		ho.put("type", "None");
 		
 		ObjectNode ho1= om.createObjectNode();
 		ho1.put("id", "5002");
 		ho1.put("type", "Glazed");
 		
 		an.add(ho);
 		an.add(ho1);
		
//		List<HashMap<String, String>> li = new ArrayList<HashMap<String, String>>();
//		HashMap<String, String> hmap = new HashMap<>();
//		hmap.put("id", "5001");
//		hmap.put("type", "None");
//		
//		HashMap<String, String> hmap1 = new HashMap<>();
//		hmap1.put("id", "5002");
//		hmap1.put("type", "Glazed");
//		
//		li.add(hmap);
//		li.add(hmap1);
		
 		String li = om.writeValueAsString(an);
 				 
		given().contentType(ContentType.JSON)
    	 .body(li).log().all()
    	.when().post("https://541a26d9-8f91-4213-b2d1-f597754588c3.mock.pstmn.io/post").then().log().all().assertThat().statusCode(201);
		
	}
	
	 
	public void serializeJsonUsingJackson() throws JsonProcessingException {
		
		ObjectMapper om = new ObjectMapper();
		ObjectNode hmap= om.createObjectNode();
		hmap.put("firstname", "Ravishandran");
		hmap.put("lastname", "Ashwwin");
		hmap.put("email","rAshwin@email.com");
		
		String omi= om.writeValueAsString(hmap);
		
		given()
		    .baseUri("http://localhost:3000").contentType(ContentType.JSON)
		    .body(omi)
		    .when()
		    .post("/employees")
		    .then()
		    .assertThat()
		    .statusCode(201);
		
	}
	

	public void serializeJsonasHashMapusingObjectMapper() throws JsonProcessingException {
		
		HashMap<String, String> hmap= new HashMap<>();
		hmap.put("firstname", "Sam34");
		hmap.put("lastname", "Patel34");
		hmap.put("email","sp14@email.com");
		
		ObjectMapper om = new ObjectMapper();
		String omi= om.writeValueAsString(hmap);
		
		given()
		    .baseUri("http://localhost:3000").contentType(ContentType.JSON)
		    .body(omi)
		    .when()
		    .post("/employees")
		    .then()
		    .assertThat()
		    .statusCode(201);
		
	}
	
	 
	public void serializeJsonasHashMap() {
		
		HashMap<String, String> hmap= new HashMap<>();
		hmap.put("firstname", "Sam3");
		hmap.put("lastname", "Patel3");
		hmap.put("email","sp1@email.com");
	    
		given()
		    .baseUri("http://localhost:3000").contentType(ContentType.JSON)
		    .body(hmap)
		    .when()
		    .post("/employees")
		    .then()
		    .assertThat()
		    .statusCode(201);
		
	}	
	 
	public void serializeJsonasNormalString() {
		
		given()
		    .baseUri("http://localhost:3000").contentType(ContentType.JSON)
		    .body(" {\r\n"
		    		 
		    		+ "    \"firstname\": \"Sam1\",\r\n"
		    		+ "    \"lastname\": \"Patel1\",\r\n"
		    		+ "    \"email\": \"sp1@email.com\"\r\n"
		    		+ "  }")
		    .when()
		    .post("/employees")
		    .then()
		    .assertThat()
		    .statusCode(201);
		 
	}

}
