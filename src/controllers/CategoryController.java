package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
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
		System.out.print("Product type is " + productType );
		String url = "/default/collections/index.jsp";
		//PrintWriter out = response.getWriter();
		try {
			if (productType == null) {
				// trả về trang báo lỗi
				//out.print("Error");
			}else {
				// khởi tạo các đối tượng dựa vào productType
				CategoryService cs = new CategoryService(productType);
				ProductService ps = new ProductService(productType);
				
				// Lấy các list category và list sản phẩm theo loại sản phẩm
				List<Product> listP = ps.getListP();
				for(Product p : listP) {
					System.out.println(p.getProductName());
				}
				List<Category> listC = cs.getListCategories();
				for(Category c : listC) {
					System.out.println(c.getCategoryName());
				}
				
				if (listP == null || listC == null) {
					// Trả về thông báo lỗi
					//print("Error");
				}
				
				request.setAttribute("listP", listP);
				request.setAttribute("listC", listC);	
			}
		}finally {
			//out.close();
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
