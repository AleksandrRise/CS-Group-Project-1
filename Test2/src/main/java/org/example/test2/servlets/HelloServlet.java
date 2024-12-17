package org.example.test2.servlets;

import org.example.test2.model.Customer;
import org.example.test2.model.ShoppingCart;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        ShoppingCart cart = new ShoppingCart();
        System.out.println("A Cart object was made");
        System.out.println("There are " + cart.showCart().size() + " items");
        System.out.println("Total price of cart: " + cart.totalSum());

        String name = request.getParameter("name");
        Customer customer = new Customer(name);
        double balance = customer.getBalance();
        System.out.println("A Customer object was made whose name is: " + customer.getName() + ". Its balance is $" + balance);

        session.setAttribute("cart", cart);
        getServletContext().setAttribute("balance", balance);
        getServletContext().setAttribute("name", name);
        request.setAttribute("name", name);
        request.setAttribute("balance", balance);
        session.setAttribute("sessionBalance", balance);

        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/shop.jsp").forward(request, response);
    }

}