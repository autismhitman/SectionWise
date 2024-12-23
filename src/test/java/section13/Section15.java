package section13;

import static io.restassured.RestAssured.given;
 
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
 
import static  org.hamcrest.MatcherAssert.assertThat;

public class Section15 {
	
	
	public void createEmployee() {
		  
		Employee emp = new Employee();
		emp.setFirstname(Data.getFirstName());
		emp.setLastname(Data.getLastName());
		emp.setEmail(Data.getEmail());
		 
		 given().spec(CodeLayer.makeRequest())
		     .body(emp)
		 	 .when()
		 	 .post("/employees")
		 	 .as(Employee2.class);
		 	
		
	}
	

	@Test
	public void updateEmployee() {
		  
		Employee emp = new Employee();
		emp.setFirstname(Data.getFirstName());
		emp.setLastname(Data.getLastName());
		emp.setEmail(Data.getEmail());
		
       System.out.println(emp.firstname +"---"+ emp.lastname+"---"+ emp.email);
		
		Employee2 emp2= given().spec(CodeLayer.makeRequest())
		     .body(emp)
		 	 .when()
		 	 .put("/employees/8")
		 	 .as(Employee2.class);
		
		assertThat(emp.firstname, equalTo(emp2.getFirstname()));
		 			
	}
	

	@Test
	public void deleteEmployee() {
		  
		      given()
		      .spec(CodeLayer.makeRequest())
		     .pathParam("id", 5)
		 	 .when()
		 	 .delete("/employees/{id}")
		 	 .then().assertThat().statusCode(200);
		 	  
		
		 
		 			
	}

}
