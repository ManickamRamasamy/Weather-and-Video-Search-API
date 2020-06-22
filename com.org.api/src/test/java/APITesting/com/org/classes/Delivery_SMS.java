package APITesting.com.org.classes;

import java.util.Scanner;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class Delivery_SMS {
	
	public static void Send_SMS(String Response) {
		String response = Response;
		int string_length = response.length();
		if(string_length <1600) {
		Scanner smsv = new Scanner(System.in);
		System.out.println("\nDo you want to send this weather details as SMS message \n to your number :"+"\n"
				+ "1. Yes" +"\n"
				+ "2. No\n");
		int sms = smsv.nextInt();
		
		if(sms==1) {
			
			Scanner ts = new Scanner(System.in);
			System.out.println("\nDo you already sign up in Twilio :"+"\n"
					+ "1. Yes" +"\n"
					+ "2. No\n");
			int setup = ts.nextInt();
			
			if(setup==1) {
				
				Scanner asid= new Scanner(System.in);  
				System.out.print("\n Enter your ACCOUNT_SID of Tiwilo: ");  
				String acc_sid= asid.nextLine(); 
				
				Scanner au_to= new Scanner(System.in);  
				System.out.print("\n Enter your AUTH_TOKEN of Tiwilo: ");  
				String auth_token= au_to.nextLine(); 
			
				Scanner fnum= new Scanner(System.in);  
				System.out.print("\n Enter your FROM phone number to send SMS message with country code like +91 for INDIA:\n ");  
				String from_number= fnum.nextLine(); 
				
				Scanner tnum= new Scanner(System.in);  
				System.out.print("\n Enter your TO phone number to send SMS message with country code like +91 for INDIA: \n");  
				String to_number= tnum.nextLine(); 
				
			  String ACCOUNT_SID = acc_sid;
			  String AUTH_TOKEN = auth_token;

			 
			     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			     Message message = Message.creator(
			             new com.twilio.type.PhoneNumber(to_number),
			             new com.twilio.type.PhoneNumber(from_number),
			             response)
			         .create();

			     System.out.println(message.getSid());
			}
			else {
				System.out.println("\n1.Go to - https://www.twilio.com/"
						+ "Sign up\n2.Get you ACCOUNT_SID, AUTH_TOKEN and Your Phone number ");
			}
		}
		else {
			System.out.println("\nThank you for your support\n");
		}
		}
		else if (string_length>=1600) {
			System.out.println("String characters exceeds");
		}
	}

}
