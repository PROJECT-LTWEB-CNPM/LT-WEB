package controllers;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.io.PrintWriter;
>>>>>>> 5ff24020b2ced68e7b1712c7d6212c23aaf10030
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import models.Product;
import services.ProductService;

@WebServlet("/search")
public class SearchProduct extends HttpServlet {
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

=======
import models.Category;
import models.Product;
import services.CategoryService;
import services.ProductService;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String findProduct = request.getParameter("findProduct");
    if (findProduct != null) {
      searchProductByCategoryId(request, response, findProduct);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  
>>>>>>> 5ff24020b2ced68e7b1712c7d6212c23aaf10030
//  protected void autoRenderWhenSearch_HomePage(HttpServletRequest request, HttpServletResponse response, String textSearch) throws ServletException, IOException {
//    ProductService productService = new ProductService();
//    List<Product> listProduct = productService.getProductByProductName(textSearch);
//
//    String contextPath = request.getContextPath();
//    PrintWriter out = response.getWriter();
//    for (Product p : listProduct) {
//      out.println("<div class=\"catalog__item\">\r\n"
//          + "                    <div class=\"group_content\">\r\n"
//          + "                        <div class=\"home-product-item__img\"\r\n"
//          + "                            style=\"background-image: url(" + p.getMainImageUrl() + ");\">\r\n"
//          + "                        </div>\r\n"
//          + "                        <h4 class=\"home-product-item__name\">\r\n"
//          + "                            <a\r\n"
//          + "                                href=\"" + contextPath + "/product-detail?product_id=" + p.getProductId()
//          + "\">" + p.getProductName() + "</a>\r\n"
//          + "                        </h4>\r\n"
//          + "                        <h4 class=\"shop_name\">SHOPLANE</h4>\r\n"
//          + "                        <div class=\"home-product-item__rating\">\r\n"
//          + "                            <c:forEach begin=\"0\" end=\"3\">\r\n"
//          + "                                <ion-icon name=\"star-outline\"></ion-icon>\r\n"
//          + "                            </c:forEach>\r\n"
//          + "                        </div>\r\n"
//          + "                        <div class=\"home-product-item__price\">\r\n"
//          + "                            <span class=\"home-product-item__price-current\">" + p.getNewPrice()
//          + "đ</span>\r\n"
//          + "                            <span class=\"home-product-item__price-old\">" + p.getOldPrice()
//          + "đ</span>\r\n"
//          + "                        </div>\r\n"
//          + "                    </div>\r\n"
//          + "                </div>");
//    }
//  }
<<<<<<< HEAD
=======
 
>>>>>>> 5ff24020b2ced68e7b1712c7d6212c23aaf10030

  protected void searchProductByCategoryId(HttpServletRequest request, HttpServletResponse response, String findProduct)
      throws ServletException, IOException {

    ProductService productService = new ProductService();
    List<Product> listProductWithSearch = new ArrayList<>();
    listProductWithSearch = productService.getProductByProductName(findProduct);
    request.setAttribute("findProduct", findProduct);
    request.setAttribute("listProductWithSearch", listProductWithSearch);
    request.getRequestDispatcher("/default/search-product/index.jsp").forward(request, response);
  }
<<<<<<< HEAD

=======
  
  
>>>>>>> 5ff24020b2ced68e7b1712c7d6212c23aaf10030
//  protected void autoRenderWhenSearch_CollectionPage(HttpServletRequest request, HttpServletResponse response, String textSearch) throws ServletException, IOException {
//    ProductService productService = new ProductService();
//    List<Product> listProduct = productService.getProductByProductName(textSearch);
//
//    String contextPath = request.getContextPath();
//    PrintWriter out = response.getWriter();
//    for (Product p : listProduct) {
//      out.println("<div class=\"grid__column-3-3\">\r\n"
//          + "                                    <div class=\"group_content\">\r\n"
//          + "                                        <div class=\"home-product-item__img\"\r\n"
//          + "                                            style=\"background-image: url("+ p.getMainImageUrl() +");\">\r\n"
//          + "                                        </div>\r\n"
//          + "                                        <h4 class=\"home-product-item__name\">\r\n"
//          + "                                            <a\r\n"
//          + "                                                href=\\\"\" + contextPath + \"/product-detail?product_id=\" + p.getProductId()"
//          + "\">" + p.getProductName() + "</a>\r\n"
//          + "                                        </h4>\r\n"
//          + "                                        <h4 class=\"shop_name\">SHOPLANE</h4>\r\n"
//          + "                                        <div class=\"home-product-item__rating\">\r\n"
//          + "                                            <i class=\"fas fa-star\"></i> <i class=\"fas fa-star\"></i> <i\r\n"
//          + "                                                class=\"fas fa-star\"></i> <i class=\"fas fa-star\"></i> <i\r\n"
//          + "                                                class=\"fas fa-star\"></i>\r\n"
//          + "                                        </div>\r\n"
//          + "                                        <div class=\"home-product-item__price\">\r\n"
//          + "                                            <span class=\"home-product-item__price-current\">"+ p.getNewPrice() +"</span>\r\n"
//          + "                                            <span class=\"home-product-item__price-old\">"+ p.getOldPrice() +"</span>\r\n"
//          + "                                        </div>\r\n"
//          + "                                    </div>\r\n"
//          + "                                </div>");
//    }
//  }
}
