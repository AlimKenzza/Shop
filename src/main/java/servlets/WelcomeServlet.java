package servlets;

import classes.Football;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

@WebServlet(name = "servlets.WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/sportshop";
    static final String DATABASE_USER = "postgres";
    static final String DATABASE_PASSWORD = "alimzhan125";
    static final String GET_ALL_FOOTBALL_RECORDS = "SELECT * FROM football";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private final Set<String> cities;

    public WelcomeServlet() {
        cities = new HashSet<String>();
        cities.add("Nur-Sultan");
        cities.add("Almaty");
        cities.add("Semey");
        cities.add("Aktau");
        cities.add("Shymkent");
        cities.add("Karaganda");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Demo";
        String docType = "<!DOCTYPE html>";

//     List<Football> footballs = Arrays.asList(new Football(1,"ball", 10999), new Football(2, "t-shirt", 19990), new Football(3,"gloves", 9999));
//        Football football = new Football(1,"ball", 20000);


//        HttpSession httpSession = request.getSession();
//        if(httpSession!=null) {
//            String username = (String) httpSession.getAttribute("username");
//            out.println("Hello " + username);
//        }
//        else {
//            out.println("Please login first");
//            request.getRequestDispatcher("index.jsp").include(request,response);
//        }
//        try {
//
//            Class.forName(JDBC_DRIVER);
//            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
//
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery(GET_ALL_FOOTBALL_RECORDS);
//
//            out.println(docType + "<html><head><title>" + title + "</title></head><body>");
//            out.println("<h1>GoalKeepers DATA</h1>");
//            out.println("<br/>");
//            while (resultSet.next()) {
//
//                football.setId(resultSet.getInt(1));
//                football.setItem_name(resultSet.getString(2));
//                football.setPrice(resultSet.getInt(3));
//
//            }
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        List<Football> footballers = Arrays.asList(football.getId(), football.getItem_name(), football.getPrice());
//        out.println("</body></html>");
//        List<> list = new ArrayList<>();
//        list.add(foot_id);
//        list.add(prod_name);
//        list.add(price);

        request.setAttribute("states", cities);
        RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
        rd.forward(request,response);
    }
}
