package DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DDTbyDeletingdata_Database {

	public static void main(String[] args) throws SQLException {
	
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza", "root", "Password@131");
		
		Statement stmt = conn.createStatement();
		
		int result = stmt.executeUpdate("delete from Ninza_CRM_Details where Browser='Chrome'");

		System.out.println(result);
		if(result!=0)
		{
			System.out.println("data stored successfully");
		}
		else
		{
			System.out.println("operation failed");
		}
		
		conn.close();

	}

}
