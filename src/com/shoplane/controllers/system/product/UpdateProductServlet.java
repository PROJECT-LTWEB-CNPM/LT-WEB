package com.shoplane.controllers.system.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.services.system.ProductService;

@WebServlet("/system/products/update")
public class UpdateProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public UpdateProductServlet() {
    super();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ProductService productService = new ProductService(request, response);
    productService.handleGetUpdateProduct();
  }

}
