package ru.gb.servlet;

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

    private ProductService productService = new ProductService();
    private String words[] = {"Knife","The globe","The skeleton of a fish","Compass","Book","Cherry","Cup","Spoon","Pillow","Fishing Hook"};
    private float costs[] = {999.5f,350.0f,15.5f,300.0f,1001.5f,666.66f,150.0f,80.0f,800.0f,120.9f};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product products[] = new Product[10];
        for (int i = 0; i < 10; i++) {
            products[i] = productService.createNewProduct(words[i], costs[i]);
        }
        req.setAttribute("products", products);

        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
