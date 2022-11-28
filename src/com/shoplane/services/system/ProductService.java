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
import com.shoplane.services.SuperService;
import com.shoplane.utils.Constants;

public class ProductService extends SuperService {

  private ProductDAO productDAO = null;
  private CategoryDAO categoryDAO = null;
  private ProductTypeDAO productTypeDAO = null;

  public ProductService(HttpServletRequest request, HttpServletResponse response) {
    super(request, response);
    this.productDAO = new ProductDAO();
    this.categoryDAO = new CategoryDAO();
    this.productTypeDAO = new ProductTypeDAO();
  }

  // [GET] ListProductServlet
  public void handleGetShowProductList(String url) throws ServletException, IOException {
    try {
      // Set encoding
      super.setEncoding(Constants.UTF8);

      // get list
      List<Product> products = this.productDAO.findAll();
      super.setAttribute("products", products);

      // Check url
      if (url == null) {
        url = "/system/products/list/index.jsp";
        super.forwardToPage(url);
      } else {
        super.redirectToPage(url);
      }
    } catch (Exception e) {
      super.log(e.getMessage());
      String error = "/500";
      super.redirectToPage(error);
    }
  }

  // [GET] CreateProductServlet
  public void handleGetCreateProduct() throws ServletException, IOException {
    try {
      String url = "/system/products/create/index.jsp";
      List<Category> categories = this.categoryDAO.findAll();
      List<ProductType> productTypes = this.productTypeDAO.findAll();

      super.setAttribute("categories", categories);
      super.setAttribute("productTypes", productTypes);

      super.forwardToPage(url);

    } catch (Exception e) {
      super.log(e.getMessage());
      String error = "/500";
      super.redirectToPage(error);
    }
  }

  // [POST] CreateProductServlet
  public void handlePostCreateProduct() throws ServletException, IOException {
    try {
      // Get props
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

      // Url = ./ => Same with /system/products
      String url = "./";
      // Create product
      this.productDAO.create(product);

      // forward
      super.redirectToPage(url);

    } catch (Exception e) {
      super.log(e.getMessage());
      String error = "/500";
      super.redirectToPage(error);
    }
  }

  // [GET] DetailProductServlet
  public void handleGetDetailProduct() throws ServletException, IOException {
    try {
      // Link
      String url = "/system/products/detail-update/index.jsp";

      // Param
      String productId = this.request.getParameter("product_id");

      // Get item
      Product product = this.productDAO.find(productId);

      // Set att and forward
      super.setAttribute("product", product);
      super.forwardToPage(url);

    } catch (Exception e) {
      super.log(e.getMessage());
      String error = "/500";
      super.redirectToPage(error);
    }
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
