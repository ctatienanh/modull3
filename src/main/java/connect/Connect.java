package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/qldt";
            String username = "root";
            String pass = "snoopyy4578";
            return DriverManager.getConnection(url,username,pass);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.printf("xxx");
            return null;
        }
    }

}
