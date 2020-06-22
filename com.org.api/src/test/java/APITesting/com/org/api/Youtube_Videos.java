package APITesting.com.org.api;

import static com.jayway.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.mozilla.javascript.tools.shell.ConsoleTextArea;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBodyData;
import com.jayway.restassured.response.ResponseBodyExtractionOptions;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import java.io.Console;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

import org.mozilla.javascript.tools.shell.ConsoleTextArea;
import org.testng.annotations.Test;

import com.google.api.client.json.Json;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import APITesting.com.org.classes.Delivery_SMS;
import APITesting.com.org.classes.Delivery_Whatsapp_SMS;


import bsh.ConsoleInterface;

public class Youtube_Videos {
	
	public static String videoid ;
	
@Test
	public static void Youtubevideos(){
	
	Scanner sc = new Scanner(System.in);
	System.out.println("\nEnter search content for Video search\n");
	String search = sc.next();
	
	Scanner mr = new Scanner(System.in);
	System.out.println("\nEnter your maximum number of Result displayed\n");
	String max_result = mr.next();
		
		Response resp = given().
				parameter("part", "snippet").
				parameter("maxResults", max_result).
				parameter("q", search).
				parameter("type","video").
				parameter("key", "AIzaSyBZgxDr7DAjp1cnIl9LoEOwiPR52uG728U").
				when().
				get("https://www.googleapis.com/youtube/v3/search");
		
//				System.out.println("Youtube videos" + resp.asString());

		
		
		
		JsonPath jsonpathvalue = resp.jsonPath();
		List<String> allvideoid = jsonpathvalue.getList("items.id.videoId");

		for(int i=0,j=1; i<allvideoid.size(); i++,j++) {
		   videoid = allvideoid.get(i);
		    System.out.println(j+". https://www.youtube.com/watch?v=" + videoid);
		}

	
		
		//Send Response as SMS to the Mobile Number 
//		Delivery_SMS.Send_SMS(videoid);
//		Delivery_Whatsapp_SMS.Send_SMS(videoid);
	 
	}

}
