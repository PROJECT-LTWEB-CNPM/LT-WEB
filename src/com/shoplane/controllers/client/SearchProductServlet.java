package com.shoplane.controllers.client;

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

@WebServlet("/search")
public class SearchProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String productName = request.getParameter("product_name");
    if (productName != null) {
      searchProductByCategoryId(request, response, productName);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  protected void searchProductByCategoryId(HttpServletRequest request, HttpServletResponse response, String findProduct)
      throws ServletException, IOException {

    ProductDAO productDAO = new ProductDAO();
    List<Product> listProductWithSearch = new ArrayList<>();
    listProductWithSearch = productDAO.findByProductName(findProduct);
    request.setAttribute("findProduct", findProduct);
    request.setAttribute("listProductWithSearch", listProductWithSearch);
    request.getRequestDispatcher("/default/search-product/index.jsp").forward(request, response);
  }
}
