package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ElectronicsServlet", urlPatterns = "/ElectronicsServlet")
public class ElectronicsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private final Map<Integer,String> electronics;
    public ElectronicsServlet() {
        electronics = new HashMap<>();
        electronics.put(1,"Laptop");
        electronics.put(2, "Personal Computer");
        electronics.put(3,"iPhone11");
        electronics.put(4,"Playstation 5");
        electronics.put(5, "Headphones");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "browse";
        switch (action) {
            case "addToCart":
                this.addToCard(request,response);
                break;
            case "empty":
                this.empty(request,response);
                break;
            case "viewCart":
                this.viewCart(request,response);
                break;
            case "browse":
                this.browse(request, response);
                break;
        }
        String message = getServletConfig().getInitParameter("message");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>" + message + "</h2>");
        } finally {
            writer.close();
        }
    }
    @SuppressWarnings("unchecked")
    private void addToCard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer electronicId = Integer.parseInt(request.getParameter("electronicId"));
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("cart") == null) {
            httpSession.setAttribute("cart" , new HashMap<String, Integer>());
        }
        Map<String,Integer> cart = (Map<String, Integer>) httpSession.getAttribute("cart");
        if(cart.containsKey(electronics.get(electronicId))) {
            cart.put(electronics.get(electronicId), cart.get(electronics.get(electronicId)) + 1);
        }
        else {
            cart.put(electronics.get(electronicId), 1);
            response.sendRedirect("ElectronicsServlet?action=viewCart");
        }
    }
    @SuppressWarnings("unchecked")
    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Integer> cart = (Map<String, Integer>) request.getSession().getAttribute("cart");
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("viewCart.jsp").forward(request,response);
    }
    private void empty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getSession().removeAttribute("cart");
        browse(request, response);
    }
    private void browse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("electronics", electronics);
        request.getRequestDispatcher("browse.jsp").forward(request,response);
    }

}
