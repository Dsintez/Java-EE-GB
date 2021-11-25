package ru.gb.servlet;

import ru.gb.beans.Cart;
import ru.gb.entity.Product;
import ru.gb.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductHttpServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private ProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = new Cart();
        for (int i = 0; i < 5; i++) {
            cart.putProduct(i);
        }
        req.setAttribute("cart", cart);

        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
