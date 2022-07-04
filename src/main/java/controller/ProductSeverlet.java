package controller;

import dao.Userdao;
import model.Product;
import selvice.ProductCreate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product")
public class ProductSeverlet extends HttpServlet {
    ProductCreate productCreate = new ProductCreate();
    Userdao userdao = new Userdao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
//        int id = Integer.parseInt(req.getParameter("id"));
        RequestDispatcher dispatcher ;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                dispatcher = req.getRequestDispatcher("/createproduct.jsp");
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                int index = productCreate.checkindex(id);
                Product p = ProductCreate.productList.get(index);
                req.setAttribute("product",p);
                dispatcher = req.getRequestDispatcher("/editproduct.jsp");
                break;
            default:
                req.setAttribute("product", userdao.getAllproduct());
                dispatcher = req.getRequestDispatcher("/showproduct.jsp");
        }
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher = null;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                int price = Integer.parseInt(req.getParameter("price"));
                String img = req.getParameter("img");
                productCreate.create(new Product(id, name, price, img));
                req.setAttribute("product", ProductCreate.productList);
                break;
            case "Edit":

                break;
            default:
                req.setAttribute("product", ProductCreate.productList);
                dispatcher = req.getRequestDispatcher("/showproduct.jsp");
                dispatcher.forward(req, resp);
        }
        dispatcher = req.getRequestDispatcher("/showproduct.jsp");
        dispatcher.forward(req, resp);
    }
}
