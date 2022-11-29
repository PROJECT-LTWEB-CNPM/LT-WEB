package com.shoplane.services.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.OptionDAO;
import com.shoplane.dao.ProductDAO;
import com.shoplane.models.Option;
import com.shoplane.models.Product;
import com.shoplane.services.SuperService;

public class OptionService extends SuperService {
  private OptionDAO optionDAO = null;
  private ProductDAO productDAO = null;

  public OptionService(HttpServletRequest request, HttpServletResponse response) {
    super(request, response);
    this.optionDAO = new OptionDAO();
    this.productDAO = new ProductDAO();
  }

  // [GET] ListOptionServlet
  public void handleGetListOption() throws ServletException, IOException {
    try {
      String url = "/system/options/list/index.jsp";
      String productId = this.request.getParameter("product_id").trim();
      Product product = this.productDAO.find(productId);
      List<Option> options = null;
      if (product != null) {
        options = this.optionDAO.findByProduct(product);
      }
      super.setAttribute("options", options);
      super.forwardToPage(url);
    } catch (Exception e) {
      super.log(e.getMessage());
      String error = "/500";
      this.redirectToPage(error);
    }
  }

  // [GET] CreateOptionServlet
  public void handleGetCreateOption() throws ServletException, IOException {
    try {
      String url = "/system/options/create/index.jsp";
      super.forwardToPage(url);
    } catch (Exception e) {
      super.log(e.getMessage());
      String error = "/500";
      this.redirectToPage(error);
    }
  }

  // [POST] CreateOptionServlet
  public void handlePostCreateOption() {

  }

  // [GET] detail option
  public void handleGetDetailOption() throws ServletException, IOException {
    String url = "/system/options/detail-update/index.jsp";

    this.request.getRequestDispatcher(url).forward(request, response);
  }

}
