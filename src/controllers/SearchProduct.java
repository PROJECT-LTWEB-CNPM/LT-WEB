package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import services.ProductService;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String textSearch = request.getParameter("findProduct");
		ProductService productService = new ProductService();
		List<Product> listProduct = productService.getProductByProductName(textSearch);
		
		String contextPath = request.getContextPath();
		PrintWriter out = response.getWriter();
		for (Product p : listProduct) {
		  out.println("<div class=\"catalog__item\">\r\n"
		      + "                    <div class=\"group_content\">\r\n"
		      + "                        <div class=\"home-product-item__img\"\r\n"
		      + "                            style=\"background-image: url("+ p.getMainImageUrl() +");\">\r\n"
		      + "                        </div>\r\n"
		      + "                        <h4 class=\"home-product-item__name\">\r\n"
		      + "                            <a\r\n"
		      + "                                href=\""+ contextPath +"/product-detail?product_id=" + p.getProductId() +"\">"+ p.getProductName() +"</a>\r\n"
		      + "                        </h4>\r\n"
		      + "                        <h4 class=\"shop_name\">SHOPLANE</h4>\r\n"
		      + "                        <div class=\"home-product-item__rating\">\r\n"
		      + "                            <c:forEach begin=\"0\" end=\"3\">\r\n"
		      + "                                <ion-icon name=\"star-outline\"></ion-icon>\r\n"
		      + "                            </c:forEach>\r\n"
		      + "                        </div>\r\n"
		      + "                        <div class=\"home-product-item__price\">\r\n"
		      + "                            <span class=\"home-product-item__price-current\">"+ p.getNewPrice() +"đ</span>\r\n"
		      + "                            <span class=\"home-product-item__price-old\">"+ p.getOldPrice() +"đ</span>\r\n"
		      + "                        </div>\r\n"
		      + "                    </div>\r\n"
		      + "                </div>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
