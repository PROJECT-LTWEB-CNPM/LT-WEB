package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import services.UserService;

@WebServlet("/verify")
public class VerifyCode extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public VerifyCode() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");

    String url = "/default/account/register/verify.jsp";
    request.getRequestDispatcher(url).forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // relative path: /verify and /login same level
    String url = "./login";
    // Get session
    HttpSession session = request.getSession();
    // Get UserService
    UserService us = new UserService();

    try {
      String code = request.getParameter("code").trim();
      User u = (User) session.getAttribute("user");
      if (code.equals(u.getCode())) {
        // add user in db
        boolean isAdd = us.add(u);
        System.out.println(isAdd);

        if (!isAdd) {
          System.out.println("Error add user");
          url = "/error/index.jsp";
        } else {
          // delete user on session
          session.removeAttribute("user");
        }
      } else {
        request.setAttribute("errMsg", "*Mã xác nhận không đúng vui lòng nhập lại");
        doGet(request, response);
        return;
      }
    } catch (Exception e) {
    }

    response.sendRedirect(url);
  }

}
