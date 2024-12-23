package section12;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class Section12 {
	 
	    //Extract response headers
		@Test
		public void extractResponseHeaders() {
			Headers head=	    given()
				 .baseUri("http://localhost:3000") 
				 .when()
				 .get("/employees")
				 .then().log().all()
				 .assertThat()
				     .statusCode(200)
				     .extract().headers();
			
	           for(Header h : head) {
	        	   
	        	   System.out.println(h.getName()+"==="+ h.getValue());
	           }
		}
		
		
	//validate headers
	@Test
	public void validateHeaders() {
		     given()
			 .baseUri("http://localhost:3000") 
			 .when()
			 .get("/employees")
			 .then().log().all()
			 .assertThat()
			     .statusCode(200)
			     .header("Connection", "keep-alive");
	}
	
   //using map 	
	@Test
	public void passingHeaderInformationasMaps() {
		
		Map<String, String> headers= new HashMap<>();
		headers.put("Headers", "Accept=*/*");
		
		 given()
			.baseUri("http://localhost:3000")
			.headers(headers)
			.when()
			.log().headers()
			.get("/employees")
			.then().log().all()
			.assertThat().statusCode(200);
	}
	
	//using headers//multiple headers
	@Test
	public void passingHeaderInformationasHeaders() {
		
		Header headers= new Header("Headers", "Accept=*/*");
		Header header1= new Header("Headers", "Accept=*/*");
		Headers head= new Headers(headers,header1) ;
		
		 given()
			.baseUri("http://localhost:3000") 
			.headers(head)
			.when()
			.log().headers()
			.get("/employees")
			.then().log().all()
			.assertThat().statusCode(200);
	}

}
