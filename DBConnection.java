package EC;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/Electricity_db";
    private static final String USER = "root";
    private static final String PASS = "Bairava@26";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("❌ Database Connection Failed: " + e.getMessage());
        }
        return conn;
    }
}
