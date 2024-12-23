package section18;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.testng.annotations.Test;

public class Section18 {
	
	//section19
        @Test
        public void formSending() {
        	     
                 given().multiPart("foo1", "bar1")
                 .multiPart("foo2", "bar2")
                 .log().all()
                 .when().post("https://postman-echo.com/post")
                 .then().log().all().assertThat().statusCode(200);
        }
        
        
        @Test
        public void fileUploading() {
        	     
                 given().multiPart("file", new File("api.txt"))
                 .multiPart("attributes", "{\"name\":\"omAPI.txt\",\"parent\":{\"id\":\"xx1\"}}")
                 .log().all()
                 .when().post("https://postman-echo.com/post")
                 .then().log().all().assertThat().statusCode(200);
        }
    //https://github.com/appium/appium/raw/refs/heads/master/packages/appium/sample-code/apps/ApiDemos-debug.apk
        
        
        @Test
        public void fileDownloading() throws IOException {
        	     
            byte[] arr=
            		given()
            		.baseUri("https://github.com") 
                    .log().all()
                    .when().get("/appium/appium/raw/refs/heads/master/packages/appium/sample-code/apps/ApiDemos-debug.apk")
                    .then().log().all().extract().response().asByteArray();
            
            OutputStream os = new FileOutputStream(new File("ApiDemos-debug.apk"));
            os.write(arr);
            os.close();
            
            
        }
}
