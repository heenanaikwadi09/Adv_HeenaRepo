package DDTPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsage {
	
	@Test(dataProvider = "getData")
	public void testCase(String firstName, String lastName) {
		
		System.out.println("firstName " + firstName + " lastName " + lastName );
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "john";
		objArr[0][1] = "bing";
		objArr[1][0] = "Ram";
		objArr[1][1] = "Ke";
		objArr[2][0] = "julee";
		objArr[2][1] = "kate";
		return objArr ;
		
	}

}
