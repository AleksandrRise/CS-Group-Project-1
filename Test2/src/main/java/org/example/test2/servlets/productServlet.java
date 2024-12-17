package org.example.test2.servlets;

import org.example.test2.model.Product;
import org.example.test2.model.ShoppingCart;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "productServlet", value = "/product-servlet")
public class productServlet extends HttpServlet {
    public boolean inStock = true;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        String productName = request.getParameter("title");
        Double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(productName, price, inStock );
        System.out.println("Product name " + product.getName() +
        " was created. Price: " + product.getPrice());


        cart.addItem(product);
        System.out.println("There are " + cart.showCart().size() + " items");

        int count = cart.showCart().size();
        getServletContext().setAttribute("count", count);
        System.out.println("Cart Price: " + cart.totalSum());

        Double cartPrice = cart.totalSum();
        getServletContext().setAttribute("cartPrice", cartPrice);
        Double balance = (Double) session.getAttribute("balance");
        request.setAttribute("balance", balance);

        session.setAttribute("sessionCartPrice", cartPrice);

        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/shop.jsp").forward(request, response);
    }
}
