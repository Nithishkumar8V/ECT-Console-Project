package EC;

import java.sql.Connection;
import java.sql.DriverManager;
public class jdbc {

	public class DBConnectionTest {
	    public static void main(String[] args) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/electricity_db", "root", "Bairava@26");
	            System.out.println("✅ Database connected!");
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

}
