package APITesting.com.org.api;

import java.util.Scanner;

import org.testng.annotations.Test;

import APITesting.com.org.api.Current_Weather;
import APITesting.com.org.api.Youtube_Videos;
import APITesting.com.org.classes.Delivery_SMS;
import APITesting.com.org.classes.Delivery_Whatsapp_SMS;

public class Main_API {
@Test	
	public void API_Call() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWelcome to the WaytOneWLiFe\n");
		System.out.println("\nCurrently we are providing the services \n"
				+ "1. Weather Report \n2. Video Search\n");
		int service = sc.nextInt();
		if(service==1) {
			Current_Weather.Weather();
		}
		
		if(service==2) {
			Youtube_Videos.Youtubevideos();
			}
		Scanner sercheck = new Scanner(System.in);
		System.out.println("\nDo you like to send the Results via our SMS Service provider"
				+"\n1. Yes\n2. No\n");
		int service_check = sercheck.nextInt();
		if(service_check==1) {
		Scanner sms = new Scanner(System.in);
		System.out.println("\nDo you like to send the Results as SMS\n"+
							"1. SMS\n"+"2. Whatsapp\n");
		
		int smsservice = sc.nextInt();
		if(smsservice==1 && service==1) {
			Delivery_SMS.Send_SMS(Current_Weather.response);
		}
		else if(smsservice==1 && service==2) {
			Delivery_Whatsapp_SMS.Send_SMS(Current_Weather.response);
		}
		else if(smsservice==2 && service==1) {
			Delivery_SMS.Send_SMS(Youtube_Videos.videoid);
		}
		else if(smsservice==2 && service==2) {
			Delivery_Whatsapp_SMS.Send_SMS(Youtube_Videos.videoid);
		}
		
		}
		else {
			System.out.println("Thanks for your support!!! :)");
		}
	}

}
