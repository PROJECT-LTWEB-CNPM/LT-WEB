package controllers.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;
import models.Product;
import services.CategoryService;
import services.ProductService;

/**
 * Servlet implementation class Collection
 */
@WebServlet("/collection")
public class CollectionServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public CollectionServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    String categoryId = request.getParameter("category_id").trim();
    String categoryType = request.getParameter("category_type").trim();
    
    // get sort type form select form
    String orderType  = request.getParameter("orderType");
    
    if (orderType == null) orderType = "normal";
    
    System.out.println(orderType);

    if (categoryId != null && categoryType != null) {
      handleGetProducts(request, response, categoryType, categoryId, orderType);
    }
  }

  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
  
  protected void handleGetProducts(HttpServletRequest req, HttpServletResponse res, String cateType, String cateId, String orderType)
      throws ServletException, IOException {

    // Create services
    ProductService ps = new ProductService();
    CategoryService categoryService = new CategoryService();

    // Init data
    List<Product> pList = null;
    List<Category> cate = null;
    String cateName = "TẤT CẢ SẢN PHẨM";

    if (cateId.contains("AO5") || cateId.contains("QUAN4")) {
      pList = ps.findBy(cateType, "");
    } else {
      pList = ps.findBy(cateType, cateId);
      cateName = categoryService.findCategorydById(cateId).getCategoryName();
    }
    cate = categoryService.findBy(cateType);
    
    pList = ps.getOrderedProduct(pList, orderType);

    // Set att => collection/index.jsp
    req.setAttribute("cateName", cateName);
    req.setAttribute("categoryId", cateId);
    req.setAttribute("categoryType", cateType);
    req.setAttribute("cates", cate);
    req.setAttribute("productBycategoryId", pList);

    req.getRequestDispatcher("/default/collections/index.jsp").forward(req, res);
  }
  
  
}
