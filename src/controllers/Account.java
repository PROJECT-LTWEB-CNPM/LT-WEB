package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Bill;
import models.User;
import services.BillService;

@WebServlet("/account")
public class Account extends HttpServlet {
  private static final long serialVersionUID = 1L;
  BillService bs = null;

  public Account() {
    super();
    this.bs = new BillService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      String url = "/default/account/index.jsp";
      User user = (User) request.getSession().getAttribute("user");
      List<Bill> bills = this.bs.findByUser(user);
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
