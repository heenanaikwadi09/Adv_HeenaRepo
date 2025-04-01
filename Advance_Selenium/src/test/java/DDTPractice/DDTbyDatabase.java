package DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DDTbyDatabase {

	public static void main(String[] args) throws SQLException {
		Driver driveRef = new Driver();
		DriverManager.registerDriver(driveRef);
		
		Connection conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/Ninza", "root", "Password@131");
		
		Statement stmt = conn.createStatement();
		
		ResultSet result = stmt.executeQuery("select * from Ninza_CRM_Details");

		while(result.next())
		{
			String browser = result.getString(1);
			String url = result.getString(2);
			String uname = result.getString(3);
			String pwd = result.getString(4);
			
			System.out.print(browser + " ");
			System.out.print(url + " ");
			System.out.print(uname + " ");
			System.out.println(pwd);
			
		}
		
		conn.close();
	}

}
