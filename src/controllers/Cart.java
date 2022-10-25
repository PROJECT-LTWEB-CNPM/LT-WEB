package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Order;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/cart")
public class Cart extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Cart() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = "/default/cart/index.jsp";
    @SuppressWarnings("unchecked")
    List<Order> orders = (List<Order>) request.getSession().getAttribute("orders");
    if (orders != null) {
      // do something
      request.setAttribute("orders", orders);
    } else {
      orders = new ArrayList<>();
      url = "/default/cart/index.jsp";
    }
    // Forward to cart page
    request.getRequestDispatcher(url).forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  }

}
