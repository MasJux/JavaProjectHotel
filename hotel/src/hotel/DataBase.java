package hotel;

import java.sql.*;

public class DataBase {
    public Connection connection;

    public static Connection ConnectDB() throws ClassNotFoundException {
 
////String dbURL = "jdbc:oracle:thin:@192.168.0.213:1521:XE";
////String username = "maciek";
////String password = "12345";

          
      try {
          Class.forName("oracle.jdbc.OracleDriver");
          Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "hotel", "12345");
          return conn;
      } catch (SQLException e) {
          System.out.println("Error");
          e.printStackTrace();
      }
      return null;
    }
}