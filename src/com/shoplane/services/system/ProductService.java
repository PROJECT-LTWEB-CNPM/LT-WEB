package com.shoplane.services.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.CategoryDAO;
import com.shoplane.dao.ProductDAO;
import com.shoplane.dao.ProductTypeDAO;
import com.shoplane.models.Category;
import com.shoplane.models.Product;
import com.shoplane.models.ProductType;

public class ProductService {
  private HttpServletRequest request;
  private HttpServletResponse response;
  private ProductDAO productDAO = null;
  private CategoryDAO categoryDAO = null;
  private ProductTypeDAO productTypeDAO = null;

  public ProductService(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
    this.productDAO = new ProductDAO();
    this.categoryDAO = new CategoryDAO();
    this.productTypeDAO = new ProductTypeDAO();
  }

  // [GET] show list product
  public void handleGetShowProductList(String url) throws ServletException, IOException {
    try {
      List<Product> products = this.productDAO.findAll();
      this.request.setAttribute("products", products);
    } catch (Exception e) {
      url = "./error";
      System.out.println(e.getMessage());
    }
    if (url == null) {
      url = "/system/products/list/index.jsp";
      request.getRequestDispatcher(url).forward(request, response);
    } else {
      this.response.sendRedirect(url);
    }
  }

  // [GET] create product
  public void handleGetCreateProduct() throws ServletException, IOException {
    String url = "/system/products/create/index.jsp";
    List<Category> categories = this.categoryDAO.findAll();
    List<ProductType> productTypes = this.productTypeDAO.findAll();

    this.request.setAttribute("categories", categories);
    this.request.setAttribute("productTypes", productTypes);

    request.getRequestDispatcher(url).forward(request, response);
  }

  // [POST] create product
  public void handlePostCreateProduct() throws ServletException, IOException {
    String productId = this.request.getParameter("productId").trim();
    String productName = this.request.getParameter("productName").trim();
    String mainImageUrl = this.request.getParameter("mainImageUrl").trim();
    int oldPrice = Integer.parseInt(this.request.getParameter("oldPrice").trim());
    int newPrice = Integer.parseInt(this.request.getParameter("newPrice").trim());
    String origin = this.request.getParameter("origin").trim();
    String pattern = this.request.getParameter("pattern").trim();
    String meterial = this.request.getParameter("meterial").trim();
    String description = this.request.getParameter("description").trim();
    Product product = new Product(productId, productName, mainImageUrl, oldPrice, newPrice, description, origin,
        pattern, meterial);
    String url = "./";

    try {
      this.productDAO.create(product);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      url = "./error";
    }
    this.response.sendRedirect(url);
  }

  // [GET] detail product
  public void handleGetDetailProduct() throws ServletException, IOException {
    String url = "/system/products/detail-update/index.jsp";
    String productId = this.request.getParameter("product_id");
    try {
      Product product = this.productDAO.find(productId);
      this.request.setAttribute("product", product);
    } catch (Exception e) {
      url = "./error";
    }
    request.getRequestDispatcher(url).forward(request, response);
  }

  // [GET] Update product
  public void handleGetUpdateProduct() throws ServletException, IOException {
    this.handleGetShowProductList("./");
  }

  // [POST] Update product
  public void handlePostUpdateProduct() {

  }

  // [GET] delete product
  public void handleGetDeleteProduct() {

  }
}
