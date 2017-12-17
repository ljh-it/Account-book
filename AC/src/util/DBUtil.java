package util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBUtil {
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "Bill";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "735139542";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return (Connection) DriverManager.getConnection(url, loginName, password);
    }
	

}
