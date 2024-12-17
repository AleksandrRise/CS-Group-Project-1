package org.example.test2.servlets;

import org.example.test2.model.ShoppingCart;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "checkOutServlet", value = "/check-out-servlet")
public class checkOutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Double checkPrice = (Double) getServletContext().getAttribute("cartPrice");
        Double shopBalance = (Double) session.getAttribute("sessionBalance");
        Double sessionCartPrice = (Double) session.getAttribute("sessionCartPrice");
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        if (checkPrice == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('You need to have items in your cart!');");
            out.println("location='shop.jsp';");
            out.println("</script>");
        }else{
            if(shopBalance < sessionCartPrice) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Not sufficient Funds');");
                out.println("location='shop.jsp';");
                out.println("</script>");
            }else{
                getServletContext().getAttribute("name");
                getServletContext().getAttribute("cartPrice");
                getServletContext().getAttribute("balance");

                Double balance = (Double) getServletContext().getAttribute("balance");
                Double cartPrice = (Double) getServletContext().getAttribute("cartPrice");
                Double newBalance = balance - cartPrice;
                System.out.println("New balance: " + newBalance);
                getServletContext().setAttribute("newBalance", newBalance);

                getServletContext().getRequestDispatcher("/checkOut.jsp").forward(request, response);
            }
        }


    }
}
