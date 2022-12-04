package com.shoplane.controllers.client.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.CategoryDAO;
import com.shoplane.dao.ProductDAO;
import com.shoplane.dao.ProductTypeDAO;
import com.shoplane.services.client.ProductService;

@WebServlet(urlPatterns = { "/collection", "/collection/" })
public class ListProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ProductDAO productDAO = null;
  ProductTypeDAO productTypeDAO = null;
  CategoryDAO categoryDAO = null;

  public ListProductServlet() {
    super();
    this.productDAO = new ProductDAO();
    this.productTypeDAO = new ProductTypeDAO();
    this.categoryDAO = new CategoryDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ProductService productService = new ProductService(request, response);
    productService.getCollectionProduct();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
