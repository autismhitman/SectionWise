package section17;


import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Section17 {
	
	
	@Test
	public void complexJsonBody() {
		
		HashMap<String,Object> hmap = new HashMap<>();
		hmap.put("id","0001");
		hmap.put("type","donut");
		hmap.put("name","Cake");
		hmap.put("ppu",0.55);
		
		HashMap<String,Object> hmap1 = new HashMap<>();
			hmap1.put("id", "5001");
			hmap1.put("type", "None");
		
		HashMap<String,Object> hmap2 = new HashMap<>();
			hmap2.put("id", "5002");
		
		List<String> li1 = new ArrayList<>();
			li1.add("test1");
			li1.add("test2");
		hmap2.put("type", li1);
		
		List<HashMap<String, Object>> lmap = new ArrayList<HashMap<String, Object>>();
		lmap.add(hmap1);
		lmap.add(hmap2);
		
		hmap.put("topping", lmap);
				
		HashMap<String,Object> hbatter = new HashMap<>();
		 hbatter.put("id", "1001");
		 hbatter.put("type", "Regular");
	
		HashMap<String,Object>  hbatter1 = new HashMap<>();
		List<Integer> li2 = new ArrayList<>();
			li2.add(5);
			li2.add(9);
		hbatter1.put("id", li2);
		hbatter1.put("type", "Chocolate");
		
		List<HashMap<String, Object>> batter = new ArrayList<HashMap<String, Object>>();
		batter.add(hbatter);
		batter.add(hbatter1);
		
		HashMap<String, List> batterMap = new HashMap<>();
		 batterMap.put("batter", batter);
		 
		hmap.put("batters", batterMap);
		
		given().contentType(ContentType.JSON)
			.body(hmap)
			.log().all()
			.when()
			.post("https://541a26d9-8f91-4213-b2d1-f597754588c3.mock.pstmn.io/post")
			.then()
			.log().all()
			.assertThat()
			.statusCode(201);
		
		
	}
	
	
	@Test
	public void validateComplexArrayRequest() {
		
		List<HashMap<String, String>> li = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hmap = new HashMap<>();
		hmap.put("id", "5001");
		hmap.put("type", "None");
		
		HashMap<String, String> hmap1 = new HashMap<>();
		hmap1.put("id", "5002");
		hmap1.put("type", "Glazed");
		
		li.add(hmap);
		li.add(hmap1);
		
		given().contentType(ContentType.JSON)
    	 .body(li).log().all()
    	.when().post("https://541a26d9-8f91-4213-b2d1-f597754588c3.mock.pstmn.io/post").then().log().all().assertThat().statusCode(201);
		
	}
	

}
