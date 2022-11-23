package com.shoplane.controllers.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.BillDAO;
import com.shoplane.models.Bill;
import com.shoplane.models.User;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  // BillService bs = null;
  BillDAO billDAO = null;

  public AccountServlet() {
    super();
//    this.bs = new BillService();
    this.billDAO = new BillDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String url = "/default/account/index.jsp";
      User user = (User) request.getSession().getAttribute("user");
      List<Bill> bills = this.billDAO.findByUser(user);
      if (bills != null) {
        request.setAttribute("bills", bills);
      }
      request.getRequestDispatcher(url).forward(request, response);
    } catch (Exception e) {
      System.out.println("Error account java" + e.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
