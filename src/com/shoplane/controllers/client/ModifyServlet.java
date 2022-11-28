package com.shoplane.controllers.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/account/modify", "/account/modify/" })
public class ModifyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ModifyServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "/default/account/modify/index.jsp";
    request.getRequestDispatcher(url).forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      /*
       * String fullname = request.getParameter("fullname");
       * String phonenumber = request.getParameter("phonenumber");
       * String address = request.getParameter("address");
       * UserService us = new UserService();
       */
//			int isUpdated = us.update("u01", fullname, phonenumber, address);
      int isUpdated = 1;
      if (isUpdated == 1) {
        String url = request.getContextPath() + "/default/account/index.jsp";
        response.sendRedirect(url);
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
