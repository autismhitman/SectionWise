package section24Assignemnt;

import static io.restassured.RestAssured.given;
import static  org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UserAssignment {
	
	@Test 
	public void addEmployee() {
	 
		Geo geo = new Geo();
		geo.setLat("-37.3159");
		geo.setLng("81.1496");
		
		Address address = new Address();
		address.setStreet("Kulas Light");
		address.setSuite("Apt. 556");
		address.setCity("Gwenborough");
		address.setZipcode("92998-3874");
		address.setGeo(geo);
		
		User user = new User();
		user.setName("Navin");
		user.setUsername("Neo");
		user.setEmail("Sincere@april.biz");
		user.setAddress(address);
		
		
		
 	User createdUser=
		
		given().baseUri("https://jsonplaceholder.typicode.com")
		.contentType(ContentType.JSON)
		.log().all()
		.body(user)
		.when()
		.post("/users")
		.then()
		.log().all()
		.extract()
		.response()
		.as(User.class);
	 
	 assertThat(user.getName(),equalTo(createdUser.getName()));
	 assertThat(createdUser.getId(), equalTo(11));
	}
 
}
