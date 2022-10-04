package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;
import models.Product;
import models.ProductImage;
import services.ProductService;
import services.CategoryService;
import services.ProductImagesService;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String productId = request.getParameter("productId");
		String categoryId = request.getParameter("categoryId");
		String showAll = request.getParameter("showAll");
		String imageId = request.getParameter("imageId");
		
		if (productId != null) {
			renderProductToHomeView(request, response, productId);
			showProductImage(request, response, productId);
			request.getRequestDispatcher("/default/products/index.jsp").forward(request, response);	
		}
		
		if (categoryId != null) {
			renderShirtProductWithType(request, response, categoryId);
		}
		
		if (showAll != null)
		{
			showAll(request, response, showAll);
		}
		
		if (imageId != null) {
			showProductImageDetail(request, response, imageId);
			request.getRequestDispatcher("/default/products/index.jsp").forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	protected void renderProductToHomeView(HttpServletRequest request, HttpServletResponse response, String productId) throws ServletException, IOException{
		ProductService productSevice = new ProductService();
		Product product = productSevice.findProductdById(productId);
		request.setAttribute("product", product);
	}
	
	protected void renderShirtProductWithType(HttpServletRequest request, HttpServletResponse response, String categoryId) throws ServletException, IOException{
		ProductService productSevice = new ProductService();
		List<Product> productBycategoryId = productSevice.getAllShortByCategoryId(categoryId);
		
		CategoryService categoryService = new CategoryService();
		Category category = categoryService.findCategorydById(categoryId);
		
//		Lấy loại sản phẩm thông qua tên bằng hàm contains('ÁO')
		request.setAttribute("productType",category.getCategoryName());
		
		request.setAttribute("productBycategoryId", productBycategoryId);
		request.setAttribute("category", category);
		
		request.getRequestDispatcher("/default/collections/index.jsp").forward(request, response);	
	}
	
	protected void showAll(HttpServletRequest request, HttpServletResponse response, String showAll) throws ServletException, IOException{
		request.setAttribute("showAll", showAll);
		request.getRequestDispatcher("/default/home/index.jsp").forward(request, response);	
	}
	
	protected void showProductImage(HttpServletRequest request, HttpServletResponse response, String productId) throws ServletException, IOException{
		ProductImagesService productImagesService = new ProductImagesService();
		List<ProductImage> productImages = productImagesService.getAllProductImage(productId);
		
		request.getSession().setAttribute("productImages", productImages);
//		request.setAttribute("productImages", productImages);
	}
	
	protected void showProductImageDetail(HttpServletRequest request, HttpServletResponse response, String imageId) throws ServletException, IOException{
		ProductImagesService productImagesService = new ProductImagesService();
		ProductImage productImagesDetail = productImagesService.findProductImageById(imageId);
		
		request.setAttribute("productImagesDetail", productImagesDetail);
	}
}
