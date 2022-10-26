package controllers;

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


@WebServlet("/collection")
public class Collection extends HttpServlet {
  private static final long serialVersionUID = 1L;

  
  public Collection() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    String productType = request.getParameter("category_type").trim();
    String categoryId = request.getParameter("category_id").trim();
    // get sort type form select form
    String orderType  = request.getParameter("orderType");
    
    if (orderType == null) orderType = "normal";
    
    System.out.println(orderType);

    if (categoryId != null && productType != null) {
      handleGetProducts(request, response, productType, categoryId, orderType);
    }
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }


  protected void handleGetProducts(HttpServletRequest req, HttpServletResponse res, String cateType, String cateId, String sortType)
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
    }
    
    pList = ps.getOrderedProduct(pList, sortType);
    
    cate = categoryService.findBy(cateType);

    // Set att => collection/index.jsp
    req.setAttribute("cateName", cateName);
    req.setAttribute("categoryId", cateId);
    req.setAttribute("categoryType", cateType);
    req.setAttribute("cates", cate);
    req.setAttribute("productBycategoryId", pList);

    req.getRequestDispatcher("/default/collections/index.jsp").forward(req, res);
  }
  
  
  
}
