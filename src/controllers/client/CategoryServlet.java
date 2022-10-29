package controllers.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/loai-san-pham" })
public class CategoryServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public CategoryServlet() {
    super();

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Get product type
    /*
     * String productType = request.getParameter("pt");
     * System.out.println("product Type Is " + productType);
     * 
     * // Get category id from url
     * String category = request.getParameter("ct");
     * System.out.println("Category id Is " + category);
     * 
     * // get order type from options
     * String orderType = request.getParameter("sortType");
     * if (orderType == null)
     * orderType = "normal";
     * 
     * System.out.println("Sort Type Is " + orderType);
     * 
     * // the url of jsp file that we will forward data
     * String url = "/default/collections/index.jsp";
     * 
     * if (productType == null) {
     * // error
     * } else {
     * // get list categories from databases
     * CategoryService cs = new CategoryService(productType);
     * List<Category> listC = cs.getListCategories();
     * 
     * // get Category Name for title of category
     * String categoryName = cs.getCategoryNameById(category);
     * 
     * // create list result
     * List<Product> listP;
     * ProductService ps = new ProductService(productType, category);
     * 
     * listP = ps.getOrderedProduct(productType, category, orderType);
     * 
     * request.setAttribute("productTypeId", productType);
     * request.setAttribute("categoryId", category);
     * request.setAttribute("categoryName", categoryName);
     * request.setAttribute("listP", listP);
     * request.setAttribute("listC", listC);
     * 
     * }
     * 
     * // chuyển đến trang được chỉ định
     * getServletContext().getRequestDispatcher(url).forward(request, response);
     */
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}