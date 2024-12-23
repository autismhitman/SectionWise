package section11;


import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;


public class Section11 {
	
	
	@Test
	public void blacklistHeaderInformations() {
		    
		 Set<String> headersinfor= new HashSet<>();
		 headersinfor.add("Keep-Alive"); headersinfor.add("Connection");headersinfor.add("Content-Type");
		 headersinfor.add("Vary");
	 
			 given()
			.baseUri("http://localhost:3000")
			.config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headersinfor)))
			.when()
			.get("/employees")
			.then()
			.log().all()
			.assertThat().statusCode(200);
	  
	}
	
	@Test
	public void loggingMethods() {
		
	 
			 given()
			.baseUri("http://localhost:3000")
			.config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
			 //.log().ifValidationFails()
			.when()
			.get("/employees")
			.then()
			//.log().ifValidationFails()
			.assertThat().statusCode(200);
	  
	}
}
