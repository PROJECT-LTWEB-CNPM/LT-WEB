package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import models.ProductImage;
import services.ProductImagesService;
import services.ProductService;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/product-detail")
public class ProductDetail extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ProductDetail() {
    super(); // TODO Auto-generated constructor stub
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String productId = request.getParameter("product_id").trim();
    if (productId != null) {
      // Get product by productId
      ProductService productSevice = new ProductService();
      Product product = productSevice.findProductdById(productId);
      request.getSession().setAttribute("product", product);
      //
      ProductImagesService productImagesService = new ProductImagesService();
      List<ProductImage> productImages = productImagesService.getAllProductImage(productId);
      request.getSession().setAttribute("productImages", productImages);
      request.getRequestDispatcher("/default/product-detail/index.jsp").forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
