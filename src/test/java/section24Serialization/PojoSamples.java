package section24Serialization;

import static io.restassured.RestAssured.given;
 
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
 
import static  org.hamcrest.MatcherAssert.assertThat;
import io.restassured.http.ContentType;

public class PojoSamples {
	
	
	@Test
	public void checkPojoDeserialization() throws JsonProcessingException {
		
		 Values val= new Values();
		 val.setKey1("value1");
		 val.setKey2("value2");
		 
		Values values= given()
		 	.contentType(ContentType.JSON)
		 	.body(val)
		 	.log().all()
		 	.when().post("https://541a26d9-8f91-4213-b2d1-f597754588c3.mock.pstmn.io/POJOSIMPLE")
		 	.then().extract().response().as(Values.class);
		 
		 ObjectMapper om = new ObjectMapper();
		 String returnString = om.writeValueAsString(values);
		 
		 String pojoStr = om.writeValueAsString(val);
		 assertThat(om.readTree(returnString),equalTo(om.readTree(pojoStr)));
		 
		
	}
	
	 
	public void checkPojo() {
		
		 Values val= new Values();
		 val.setKey1("value1");
		 val.setKey2("value2");
		 
		 given()
		 	.contentType(ContentType.JSON)
		 	.body(val)
		 	.log().all()
		 	.when().post("https://541a26d9-8f91-4213-b2d1-f597754588c3.mock.pstmn.io/POJOSIMPLE")
		 	.then().body("key1", equalTo(val.getKey1()));
		 
		 
		
	}
	

}
