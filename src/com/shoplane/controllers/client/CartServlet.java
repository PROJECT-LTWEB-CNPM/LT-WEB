package com.shoplane.controllers.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoplane.models.Order;

@WebServlet(urlPatterns = { "/cart", "/cart/" })
public class CartServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public CartServlet() {
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
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    try {
      HttpSession session = req.getSession();
      String opId = req.getParameter("oId");
      String url = "/default/cart/index.jsp";
      @SuppressWarnings("unchecked")
      List<Order> ors = (List<Order>) req.getSession().getAttribute("orders");

      int index = -1;
      if (ors != null) {
        for (int i = 0; i < ors.size(); i++) {
          if (ors.get(i).getOption().getOptionId().equals(opId)) {
            index = i;
            break;
          }
        }
        if (index != -1) {
          ors.remove(index);
          session.setAttribute("orders", ors);
          req.getSession().setAttribute("orderSize", ors.size());
        }
      }
      req.getRequestDispatcher(url).forward(req, res);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
