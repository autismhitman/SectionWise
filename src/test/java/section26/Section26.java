package section26;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import section24Assignemnt.User;

public class Section26 {
	
	
	@Test
	public void createCollection() {
		
		Info info = new Info();
		info.setName("Sample Collection");
		info.setDescription("This is just a sample collection.");
		info.setSchema("https://schema.getpostman.com/json/collection/v2.1.0/collection.json");
		
		
		Header header= new Header();
		header.setKey("Content-Type");
		header.setValue("application/json"); 
		
		List<Header> headerlist = new ArrayList<>();
		headerlist.add(header);
		
		Body body = new Body();
		body.setMode("raw");
		body.setRaw("{\"data\": \"123\"}");
		
		Request request = new Request();
		request.setUrl("https://postman-echo.com/post");
		request.setMethod("POST");
		request.setHeader(headerlist) ;
		request.setBody(body);
		request.setDescription("This is a sample POST Request");
		
		
		Item1 item1 = new Item1();
		item1.setName("Sample POST Request");
		item1.setRequest(request);
		
		List<Item1> i1 = new ArrayList<>();
		i1.add(item1);
		 	
		Item item11 = new Item();
		item11.setName("This is a folder");
        item11.setItem(i1);
        
        Request request12 = new Request();
   			request12.setUrl("https://postman-echo/get");
   			request12.setMethod("GET");
   			request12.setDescription("This is a sample GET Request");
   			
        Item item12 = new Item();
        item12.setName("Sample GET Request");
        item12.setRequest(request12);
        
     
          List<Item> mainItem = new ArrayList<>();
          mainItem.add(item11);
          mainItem.add(item12);
		

		
         Collection collect = new Collection();
		 collect.setInfo(info);
	     collect.setItem(mainItem);
		
		CollectionRoot cr = new CollectionRoot();
		cr.setCollection(collect);
		
		
		
		CollectionRoot createdUser=
				
				given().baseUri("https://api.getpostman.com")
				//.header("","")//here need to provide thechabi tala
				.contentType(ContentType.JSON)
				.log().all()
				.body(cr)
				.when()
				.post("/collections")
				.then()
				.log().all()
				.extract()
				.response()
				.as(CollectionRoot.class);
			 
			 assertThat(cr.collection.info.name,equalTo(createdUser.getCollection().getName()));
		 
			 
	}
	

}


