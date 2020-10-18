package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@WebServlet(name = "servlets.InfoServlet")
public class InfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(60);
        String welcome;
        Integer counter = 0;
        try {
            if(session.isNew()) {
                welcome = "Hello, it is your first visit to the our website! Welcome.";
            }
            else {
                Integer count = (Integer)session.getAttribute("counter");
                welcome = "Welcome back!";
                if(count!=null) {
                    counter = new Integer(count.intValue() + 1);
                }
            }
            session.setAttribute("counter" , counter);
            out.println("<html><head><title>Information</title></head><body>");
            out.println("<h3>" + welcome + "</h3><br>");
            out.println("<b> Session ID : </b>" + session.getId() + "<br>");
            out.println("<b> Creation time of the Session : </b>" + new Date(session.getCreationTime()) + "<br>");
            out.println("<b> Last access time : </b>" + new Date(session.getLastAccessedTime()) + "<br>");
            out.println("<b> Maximum inactive time interval : </b>" + session.getMaxInactiveInterval() + "<br>");
            out.println("You have visited us :" + (counter++));
            if(counter == 1) {
                out.println("time");
            }
            else {
                out.println("times");
            }
            out.println("</body></html>");
        }
        finally {
            out.close();
        }
        doGet(request,response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = getServletConfig().getInitParameter("message");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>" + message + "</h2>");
        } finally {
            writer.close();
        }
    }
}
