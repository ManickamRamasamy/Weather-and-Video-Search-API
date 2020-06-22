package APITesting.com.org.api;

import APITesting.com.org.classes.Delivery_SMS;
import APITesting.com.org.classes.Delivery_Whatsapp_SMS;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.given;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.logging.ConsoleHandler;
import org.json.simple.JSONObject;
import org.mozilla.javascript.tools.shell.ConsoleTextArea;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBodyData;
import com.jayway.restassured.response.ResponseBodyExtractionOptions;
import com.twilio.rest.api.v2010.account.Message;


public class Current_Weather{
	public static String response;	//Response stored as String
	private static Response resp;		//API response values
	private static JsonPath jsonpathvalue;	//Fetching JSON Response value using Jsonpath 


	public static void Weather() {
		
	Scanner cwd = new Scanner(System.in);
	System.out.println("Choose which weather details do you want to know?"+"\n"
			+ "1. Current weather" +"\n"
			+ "2. Historical weather");
	int weather_data = cwd.nextInt();

	//Historical Weather
	if (weather_data==2) {
		System.out.println("Sorry for the inconvinencies, currently Historical weather data is not implemented");
	}
	
	
	if(weather_data==1) {

	Scanner ld = new Scanner(System.in);
	System.out.println("\n Choose which location details do you want to enter?" +"\n"
			+ "1. City name" +"\n"
			+ "2. City code/Id" +"\n"
			+ "3. Latitude and Longitude details \n");
	int Location_data = ld.nextInt();
	
	//Current weather and City Name
	if(weather_data==1 && Location_data==1) {
			Scanner cn= new Scanner(System.in);  
			System.out.print("\n Enter a City Name: \n");  
			String city_name= cn.nextLine(); 
			
			Scanner apidv= new Scanner(System.in);  
			System.out.print("\n Do you have API ID for Open Weather: \n 1.Yes \n 2.No \n");  
			int app_id_verify= apidv.nextInt(); 
			
			if (app_id_verify ==1) {
			Scanner apid= new Scanner(System.in);  
			System.out.print("\n Enter your Open weather API ID: \n");  
			String app_id= apid.nextLine(); 
			

			resp = given().param("units","Imperial").
					param("q", city_name).
					param("appid", app_id).
					when()
					.get("http://api.openweathermap.org/data/2.5/weather");
			
			}
			else if(app_id_verify ==2) {
				System.out.println("\nBelow are th guidelines to get your API ID for Open weather"
						+ "\n Go to the URL - https://openweathermap.org/ and Sign up. You will get your API id after sign up");
			}
			
	}
	
	//Current weather and City ID
	else if(weather_data==1 && Location_data==2) {
		Scanner cid= new Scanner(System.in);  
		System.out.print("\n Enter a City Code/ID: ");  
		String city_id= cid.nextLine(); 
		
		Scanner apidv= new Scanner(System.in);  
		System.out.print("\n Do you have API ID for Open Weather: \n 1.Yes \n 2.No");  
		int app_id_verify= apidv.nextInt(); 
		
		if (app_id_verify ==1) {
		Scanner apid= new Scanner(System.in);  
		System.out.print("\n Enter your Open weather API ID: ");  
		String app_id= apid.nextLine(); 
		

		resp = given().param("units","Imperial").
				param("id", city_id).
				param("appid", app_id).
				when()
				.get("http://api.openweathermap.org/data/2.5/weather");
		
		}
		else if(app_id_verify ==2) {
			System.out.println("\nBelow are th guidelines to get your API ID for Open weather"
					+ "\n Go to the URL - https://openweathermap.org/ and Sign up. You will get your API id after sign up");
		}
		
}
	

	//Current weather and Location Latitude & Longitude
	
	else if(weather_data==1 && Location_data==3) {
		Scanner lat= new Scanner(System.in);  
		System.out.print("\n Enter a Latitude of your location : \n");  
		String latitude= lat.nextLine(); 
		
		Scanner lon = new Scanner(System.in);  
		System.out.print("\n Enter a Longitude of your location : \n");  
		String longitude= lon.nextLine(); 
		
		Scanner apidv= new Scanner(System.in);  
		System.out.print("\n Do you have API ID for Open Weather: \n 1.Yes \n 2.No");  
		int app_id_verify= apidv.nextInt(); 
		
		if (app_id_verify ==1) {
		Scanner apid= new Scanner(System.in);  
		System.out.print("\n Enter your Open weather API ID: ");  
		String app_id= apid.nextLine(); 
		

		resp = given().param("units","Imperial").
				param("lat", latitude).
				param("lon", longitude).
				param("appid", app_id).
				when()
				.get("http://api.openweathermap.org/data/2.5/weather");
		
		
		
		}
		else if(app_id_verify ==2) {
			System.out.println("\nBelow are th guidelines to get your API ID for Open weather"
					+ "\n Go to the URL - https://openweathermap.org/ and Sign up. You will get your API id after sign up");
		}
		
}

//	System.out.println("Response: " + resp.asString());
	
	//JSON path declaration
	
	jsonpathvalue = resp.jsonPath();
	
	//Response stored as String using Json path
	
	response = "\nCity Name: " +jsonpathvalue.get("name") + "\n" +
	"Country: " + jsonpathvalue.get("sys.country") +"\n" +
	"Co-Ordinates with Latitude and Longtitude: " + jsonpathvalue.get("coord") + "\n" +
	"Temperature: " + jsonpathvalue.get("main.temp") + "F\n" +
	"Minimum Temperature: " + jsonpathvalue.get("main.temp_min") +"F\n" +
	"Maximum Temperature: " + jsonpathvalue.get("main.temp_max") + "F\n" +
	"Pressure: " + jsonpathvalue.get("main.pressure") + "\n" +
	"Wind Speed: " + jsonpathvalue.get("wind.speed")+ "m/s";
	System.out.println("Weather of your Location - \n" + response);
	
	//Send Response as SMS to the Mobile Number 
//	Delivery_SMS.Send_SMS(response);
//	Delivery_Whatsapp_SMS.Send_SMS(response);
	
	
	
		}

	}

}