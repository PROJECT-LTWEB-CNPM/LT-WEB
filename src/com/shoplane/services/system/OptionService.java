package com.shoplane.services.system;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.OptionDAO;
import com.shoplane.dao.ProductDAO;
import com.shoplane.models.Option;
import com.shoplane.models.Product;

public class OptionService {
  private HttpServletRequest request;
  private HttpServletResponse response;
  private OptionDAO optionDAO = null;
  private ProductDAO productDAO = null;

  public OptionService(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
    this.optionDAO = new OptionDAO();
    this.productDAO = new ProductDAO();
  }

  // [GET] list option
  public void handleGetListOption() throws ServletException, IOException {
    String url = "/system/options/list/index.jsp";
    String productId = this.request.getParameter("product_id").trim();
    try {
      Product product = this.productDAO.find(productId);
      List<Option> options = null;
      if (product != null) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("product", product);
        options = this.optionDAO.findWithNamedQuery("Option.findByProduct", parameter);
      }
      this.request.setAttribute("options", options);
    } catch (Exception e) {

    }
    this.request.getRequestDispatcher(url).forward(request, response);
  }

  // [GET] create option
  public void handleGetCreateOption() throws ServletException, IOException {
    String url = "/system/options/create/index.jsp";

    this.request.getRequestDispatcher(url).forward(request, response);
  }

  // [POST] create option
  public void handlePostCreateOption() {

  }

  // [GET] detail option
  public void handleGetDetailOption() throws ServletException, IOException {
    String url = "/system/options/detail-update/index.jsp";

    this.request.getRequestDispatcher(url).forward(request, response);
  }

}
