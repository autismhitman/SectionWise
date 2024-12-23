package section13;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class CodeLayer {
	
	
    static RequestSpecification reqSpec ;
    static ResponseSpecification responseSpec ;
	
	public static  RequestSpecification makeRequest() {
		 
		   RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
		   reqSpecBuilder.setBaseUri("http://localhost:3000");
		   reqSpecBuilder.log(LogDetail.ALL);
		   
		         
		   return reqSpec = reqSpecBuilder.build();      
	}
	
	public static  ResponseSpecification checkResponse() {
		 
		   ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		   responseSpecBuilder
			   .expectStatusCode(200)
			   .expectContentType(ContentType.JSON);
		       
		         
		   return responseSpec = responseSpecBuilder.build().logDetail(LogDetail.ALL);      
	}
	
	
 
}
