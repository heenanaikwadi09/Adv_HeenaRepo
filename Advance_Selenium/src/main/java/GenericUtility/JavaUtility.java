package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNum(int limit)
	{
		Random ran = new Random();
		int randomNum = ran.nextInt(limit);
		return randomNum;
	}
	
	public String genrateSystemDate()
	{
		  Date dateobj = new Date();
	      SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
	      String todaysDate = sim.format(dateobj);
	      return todaysDate;
	}
	

//	public String generateReqDate(int days) {
//        Date dateobj = new Date();
//        SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
//        String todaysDate = sim.format(dateobj);
//
//        // Create a Calendar instance
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH, days);  // Add the specified number of days
//        String closeDate = sim.format(cal.getTime());
//        System.out.println(closeDate);
//        return closeDate;
		
		 public String generateReqDate(int days) {
		        Calendar calendar = Calendar.getInstance();
		        calendar.add(Calendar.DAY_OF_MONTH, days);  // Add the specified number of days
		        
		        // Format the date in dd-MM-yyyy format
		        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		        return formatter.format(calendar.getTime());
    }

}
