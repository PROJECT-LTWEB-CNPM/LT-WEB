package com.shoplane.controllers.client.order.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.CategoryDAO;
import com.shoplane.dao.ProductDAO;
import com.shoplane.dao.ProductTypeDAO;
import com.shoplane.models.Category;
import com.shoplane.models.Product;
import com.shoplane.models.ProductType;
import com.shoplane.services.client.ProductService;
import com.shoplane.utils.Constants;

@WebServlet(urlPatterns = { "/collection", "/collection/" })
public class ListProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ProductDAO productDAO = null;
  ProductTypeDAO productTypeDAO = null;
  CategoryDAO categoryDAO = null;

  public ListProductServlet() {
    super();
    this.productDAO = new ProductDAO();
    this.productTypeDAO = new ProductTypeDAO();
    this.categoryDAO = new CategoryDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    String categoryId = request.getParameter("category_id").trim();
    String categoryType = request.getParameter("category_type").trim();

    // get sort type form select form
    String orderType = request.getParameter("orderType");

    if (orderType == null)
      orderType = Constants.OLDEST;

    if (categoryId != null && categoryType != null) {
      handleGetProducts(request, response, categoryType, categoryId, orderType);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  protected void handleGetProducts(HttpServletRequest req, HttpServletResponse res, String cateType, String cateId,
      String orderType)
      throws ServletException, IOException {

    try {

      // Create services
      ProductService ps = new ProductService();

      // Init data
      List<Product> pList = null;
      List<Category> cate = null;
      String cateName = "TẤT CẢ SẢN PHẨM";
      Category category = null;
      ProductType productType = this.productTypeDAO.find(cateType);

      if (cateId.contains("AO5") || cateId.contains("QUAN4")) {
      } else {
        category = this.categoryDAO.find(cateId);
        cateName = categoryDAO.find(cateId).getCategoryName();
      }

      pList = this.productDAO.findByCategoryAndProductType(productType, category);
      ProductType pType = productTypeDAO.find(cateType);
      cate = categoryDAO.findByProductType(pType);

      pList = ps.getOrderedProduct(pList, orderType);
      System.out.println(orderType);

      // Set att => collection/index.jsp
      req.setAttribute("cateName", cateName);
      req.setAttribute("categoryId", cateId);
      req.setAttribute("categoryType", cateType);
      req.setAttribute("cates", cate);
      req.setAttribute("productBycategoryId", pList);

      req.getRequestDispatcher("/default/collections/index.jsp").forward(req, res);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      req.getRequestDispatcher("/500.jsp").forward(req, res);
    }
  }

}
