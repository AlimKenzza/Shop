package servlets;

import classes.Football;
import classes.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Integer id = Integer.parseInt(request.getParameter("id"));
//        String item_name = (String) request.getAttribute("item_name");
//        int price = (int) request.getAttribute("price");
        Football football = new Football();
        HttpSession session1 = request.getSession();
        if(action.equals("ordernow")) {
            if(session1.getAttribute("cart")==null) {
                List<Item> cart = new ArrayList<Item>();
                try {
                    cart.add(new Item(football.fetchFootball(request.getParameter("id")),1));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                session1.setAttribute("cart", cart);

            }
            else {
                List<Item> cart = (List<Item>) session1.getAttribute("cart");
                try {
                    cart.add(new Item(football.fetchFootball(request.getParameter("id")),1));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                session1.setAttribute("cart", cart);
            }
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        }
    }
}
