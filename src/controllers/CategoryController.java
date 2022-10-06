package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;
import models.Product;
import services.ProductService;
import services.CategoryService;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet(urlPatterns = {"/loai-san-pham"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		String productType = request.getParameter("pt");
		String category = request.getParameter("ct");
		String url = "/default/collections/index.jsp";
		if (productType == null) {
			// error
		}else{
			CategoryService cs = new CategoryService(productType); 
			List<Category> listC = cs.getListCategories();
			String categoryName = cs.getCategoryNameById(category);
			
			ProductService ps = new ProductService(productType, category);
			List<Product> listP;
			if (category != null) {
				listP = ps.getListPC();
				if (listP == null) {
					listP = Collections.<Product>emptyList();
				}
			}else {
				listP = ps.getListP();
			}
			
			
			
			request.setAttribute("categoryName", categoryName);
			request.setAttribute("listP", listP);
			request.setAttribute("listC", listC);
			
		}
		
		
		// chuyển đến trang được chỉ định
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
