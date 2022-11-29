package com.shoplane.controllers.client.order.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.ProductDAO;
import com.shoplane.models.Product;

@WebServlet(urlPatterns = { "/search", "/search/" })
public class SearchProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  ProductDAO productDAO = null;

  public SearchProductServlet() {
    super();
    productDAO = new ProductDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String productName = request.getParameter("product_name");
      if (productName != null) {
        List<Product> listProductWithSearch = new ArrayList<>();
        listProductWithSearch = this.productDAO.findByProductName(productName);
        request.setAttribute("findProduct", productName);
        request.setAttribute("listProductWithSearch", listProductWithSearch);
        request.getRequestDispatcher("/default/search-product/index.jsp").forward(request, response);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      String pageUrl = "/500.jsp";
      request.getRequestDispatcher(pageUrl).forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
