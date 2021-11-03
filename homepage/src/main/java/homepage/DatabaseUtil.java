package homepage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
        public static Connection getConnection() {
                try {
                		String dbID = "root";
                		String dbPW = "tjddnjs18!@";
                		String PORTNO = "3306";
                		String DBNAME = "mysql2";
                		String TIMEZONE = "serverTimeZone=UTC";
            		
                		String dbURL = "jdbc:mysql://localhost:" + PORTNO + "/" + DBNAME + "?" + TIMEZONE;
                        Class.forName("com.mysql.jdbc.Driver");
                        return DriverManager.getConnection(dbURL, dbID, dbPW);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;
        }
}