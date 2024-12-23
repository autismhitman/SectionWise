package section17;


import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;


public class AssignmentSection17 {
	
	
	@Test
	public void assignment() {
		
		
		List<Integer> colorList = new ArrayList<>();
		colorList.add(0);
		colorList.add(0);
		colorList.add(0);
		colorList.add(1);
		
		HashMap<String, Object> hmapCode = new HashMap<>();
		hmapCode.put("rgba", colorList);
		hmapCode.put("hex", "#FFF");
		
		HashMap<String, Object> mainMap2 = new HashMap<>();
		mainMap2.put("color", "white");
		mainMap2.put("category","value");
		mainMap2.put("code",hmapCode);
		
		List<Integer> colorList1 = new ArrayList<>();
		colorList1.add(255);
		colorList1.add(255);
		colorList1.add(255);
		colorList1.add(1);
		
		HashMap<String, Object> hmapCode1 = new HashMap<>();
		hmapCode1.put("rgba", colorList1);
		hmapCode1.put("hex", "#000");
		
		HashMap<String, Object> mainMap1 = new HashMap<>();
		mainMap1.put("color", "black");
		mainMap1.put("category","hue");
		mainMap1.put("type","primary");
		mainMap1.put("code",hmapCode1);
		
		
		
	
		
		List<Object> colors = new ArrayList<>();
		colors.add(mainMap1);
		colors.add(mainMap2);
		
		HashMap<String, Object> finalMap = new HashMap<>();
		finalMap.put("colors", colors);
		
		given().contentType(ContentType.JSON).header("x-mock-match-request-body",true)
		.body(finalMap)
		.log().all()
		.when()
		.post("https://541a26d9-8f91-4213-b2d1-f597754588c3.mock.pstmn.io/postAssignment")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
		
	}

}
