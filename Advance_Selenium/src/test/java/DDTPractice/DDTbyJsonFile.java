package DDTPractice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDTbyJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		FileReader file = new FileReader("C:\\Users\\Heena\\eclipse-workspace\\Advance_Selenium\\src\\test\\resources\\Data.json");
		Object javaObj = parser.parse(file);
		
		
		JSONObject obj = (JSONObject) javaObj;
	    String name = obj.get("Name").toString();
	    String id = obj.get("Id").toString(); //we get sting as we use toString method to convert for using it in sendkeys as sendkey's accepts only sting value
	    Object id1 = obj.get("Id");   //we get integer
	    String branch = obj.get("Branch").toString();
	    String age = obj.get("Age").toString();
	    String isStudent = obj.get("isStudent").toString(); //we get sting as we use toString method to convert for using it in sendkeys as sendkey's accepts only sting value
	    Object isStudent1 = obj.get("isStudent");  //we get boolean
	  //  String backlog = obj.get("Backlog").toString(); // as it is null toString can'5t convert into null to string value 
	    Object backlog1 = obj.get("Backlog");  //we get as it is (null value)

	    
	    System.out.println(name);
	    System.out.println(id);
	    System.out.println(id1);
	    System.out.println(branch);
	    System.out.println(age);
	    System.out.println(isStudent);
	    System.out.println(isStudent1);
//	    System.out.println(backlog);
	    System.out.println(backlog1);
	    
	    
	}

}
