package servlets;

import classes.Confirmation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlets.LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("html/text");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String submitted = request.getParameter("submit");
        if(Confirmation.checkUser(userName, password)) {
            HttpSession httpSession = request.getSession(true);

            httpSession.setAttribute("username", userName);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Welcome.jsp");
//            requestDispatcher.forward(request,response);
            response.sendRedirect(request.getContextPath() + "/servlets.WelcomeServlet");

        }
        else {
            out.println("Username or Password incorrect");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
