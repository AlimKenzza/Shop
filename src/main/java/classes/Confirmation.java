package classes;

import javax.servlet.http.HttpServlet;
import java.sql.*;

public class Confirmation {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/sportshop";
    static final String DATABASE_USER = "postgres";
    static final String DATABASE_PASSWORD = "alimzhan125";
    public static boolean checkUser(String username, String password) {
        boolean st = false;
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement("select * from users where username=? and user_password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            st = resultSet.next();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
