package section24Serialization;

import static io.restassured.RestAssured.given;
import static  org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class EmpSerialization {
	
	@Test(dataProvider="getEmployee")
	public void addEmployee(String fname, String lname, String email) {
		
		Employee emp = new Employee();
		emp.setFirstname(fname);
		emp.setLastname(lname);
		emp.setEmail(email);
		
		
	Employee createdEmp=
		
		given().baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(emp)
		.when()
		.post("/employees")
		.then()
		.extract()
		.response()
		.as(Employee.class);
	
	assertThat(emp.getFirstname(),equalTo(createdEmp.getFirstname()));
		
	}
	
	
	@DataProvider(name="getEmployee")
	public Object[][] getEmployee(){
		
		return new Object[][] {
			{"Usman","khwaja","ukhwaja@email.com"},
			{"Travis","Head","thead@email.com"},
			
		};
		
	}
	
	
	
	
	

}
