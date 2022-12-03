package com.shoplane.controllers.client.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/account/change-password", "/account/change-password/" })
public class ChangePasswordServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ChangePasswordServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String pageUrl = "/pages/default/account/changePassword/index.jsp";
    request.getRequestDispatcher(pageUrl).forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }

}
