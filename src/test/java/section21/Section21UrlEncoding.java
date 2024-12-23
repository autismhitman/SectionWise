package section21;

import org.testng.annotations.Test;

import io.restassured.config.EncoderConfig;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Section21UrlEncoding {
	
	
	@Test
	public void checkURLENcoding() {
		
		given().baseUri("https://postman-echo.com").config(config.encoderConfig(EncoderConfig.encoderConfig()
				.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
		       .formParam("key1", "value1")
		       .log().all()
		        .when().post("/post")
		         .then().log().all()
		         .assertThat().statusCode(200);
	}

}
