package section34;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
public class Section34 {

	@BeforeClass
	public void setUp() {
		RestAssured.requestSpecification = 
				new RequestSpecBuilder()
				.setRelaxedHTTPSValidation()
				.setBaseUri("https://localhost:8443").build();
	}

	@Test
	public void validateFormAuthentication_using_csrfToken() {
		
		SessionFilter sessionFilter = new SessionFilter();
      
		given().filter(sessionFilter)
		.auth()
		.form("dan", "dan123", new FormAuthConfig("/signin", "txtUsername", "txtPassword")).csrf("/login")
		.log().all()
        .when()
        .get("/login").
		 then()
		 .log().all()
		 .statusCode(200);
		
		 System.out.println(sessionFilter.getSessionId());
		 
		  // given().filter(sessionFilter)
		 //given().cookie("JSESSIONID",sessionFilter.getSessionId())
		 Cookie someCookie = new Cookie.Builder("JSESSIONID",sessionFilter.getSessionId())
				 .setSecured(true).setComment("some comment").build();
		 
		 Cookie dummy = new Cookie.Builder("dummy","dummyvalue").build();
		 Cookies cookies = new Cookies(someCookie,dummy);
		 
		 given().cookies(cookies)
		 .log().all()
	        .when()
	        .get("/profile/index").
			 then()
			 .log().all()
			 .statusCode(200)
             .body("html.body.div.p", equalTo("This is User Profile\\Index. Only authenticated people can see this"));
	}

}
