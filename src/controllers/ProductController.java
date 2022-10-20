package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
	List<String> listProductIdInCart = new ArrayList<String>();
	List<Product> listProductInCart = new ArrayList<>();
       
   
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
		String showCart = request.getParameter("showCart");
		String delete = request.getParameter("delele");
		
		
		if (productId != null) {
			
			renderProductToHomeView(request, response, productId);
			request.getSession().removeAttribute("productImagesDetail");
			showProductImage(request, response, productId);
			request.getRequestDispatcher("/default/products/index.jsp").forward(request, response);	
		}
		
		if (categoryId != null) {
//			request.getSession().removeAttribute("productType");
//			request.getSession().removeAttribute("productBycategoryId");
//			request.getSession().removeAttribute("category");
			renderProductWithType(request, response, categoryId);
		}
		
		if (showAll != null)
		{
			showAll(request, response, showAll);
		}
		
		if (imageId != null) {
			showProductImageDetail(request, response, imageId);
			request.getRequestDispatcher("/default/products/index.jsp").forward(request, response);	
		}
		
		if (showCart != null && showCart.equals("showCart")) {
			listProductInCart = new ArrayList<>();
			request.getSession().removeAttribute("listProductInCart");
			renderProductInCartToview(request, response);
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String findProduct = request.getParameter("findProduct");
		String productId = request.getParameter("productId");
		
		if (findProduct != null) {
			searchProductByCategoryId(request, response, findProduct);
		}
		
		if (productId != null) {
//			System.out.println(productId);
			addProductIdToCart (request, response, productId);
			handleLogicCart(request, response);
//			request.getRequestDispatcher("/default/products/index.jsp").forward(request, response);	
		}
	}
	
	
	
	
	
	
	
	
	protected void renderProductToHomeView(HttpServletRequest request, HttpServletResponse response, String productId) throws ServletException, IOException{
		ProductService productSevice = new ProductService();
		Product product = productSevice.findProductdById(productId);
		request.getSession().setAttribute("product", product);
	}
	
	protected void renderProductWithType(HttpServletRequest request, HttpServletResponse response, String categoryId) throws ServletException, IOException{
		ProductService productSevice = new ProductService();
		List<Product> productBycategoryId = productSevice.getAllProductByCategoryId(categoryId);
		
		CategoryService categoryService = new CategoryService();
		Category category = categoryService.findCategorydById(categoryId);
		
//		Lấy loại sản phẩm thông qua tên bằng hàm contains('ÁO')
		request.getSession().setAttribute("productType",category.getCategoryName());
		
		request.getSession().setAttribute("productBycategoryId", productBycategoryId);
		request.getSession().setAttribute("category", category);
		
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
		
		request.getSession().setAttribute("productImagesDetail", productImagesDetail);
	}
	
//	Tìm kiếm sản phẩm
	protected void searchProductByCategoryId (HttpServletRequest request, HttpServletResponse response, String findProduct) throws ServletException, IOException{
		
		ProductService productService = new ProductService();
		List<Product> listProductWithSearch = new ArrayList<>();
//	Tìm kiếm danh sách category phù hợp với từ khóa được nhập vào
		CategoryService categoryService = new CategoryService();
		List<Category> listCategoryWithSearch = categoryService.getCategoryByCategoryName(findProduct.toUpperCase());
		
		for(Category c : listCategoryWithSearch) {
			listProductWithSearch.addAll(productService.getAllProductByCategoryId(c.getCategoryId()));
		}
//		System.out.println(listCategory.size());
//		System.out.println(listProduct.size());	
		request.getSession().setAttribute("listCategoryWithSearch", listCategoryWithSearch);
		request.setAttribute("listProductWithSearch", listProductWithSearch);
		request.getRequestDispatcher("/default/collections/index.jsp").forward(request, response);	
	}
	
	protected void addProductIdToCart (HttpServletRequest request, HttpServletResponse response, String productId) {
		if (!listProductIdInCart.contains(productId)) {
			listProductIdInCart.add(productId);
		}
	}
	
	protected void renderProductInCartToview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalPrice = 0;
		ProductService productService = new ProductService();
		for(String s : listProductIdInCart) {
			Product product = productService.findProductdById(s);
			totalPrice += product.getNewPrice();
			listProductInCart.add(product);
		}
		request.setAttribute("totalPrice", totalPrice);
		request.getSession().setAttribute("listProductInCart", listProductInCart);
		request.getRequestDispatcher("/default/cart/index.jsp").forward(request, response);	
	}
	
	protected void handleLogicCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listProductInCart = new ArrayList<>();
		request.getSession().removeAttribute("listProductInCart");
		renderProductInCartToview(request, response);
	}
	
	protected void deleteFromProductFromCart(HttpServletRequest request, HttpServletResponse response, String delete) throws ServletException, IOException {
		listProductIdInCart.remove(Integer.parseInt(delete));
		handleLogicCart(request, response);
	}
	
	
}