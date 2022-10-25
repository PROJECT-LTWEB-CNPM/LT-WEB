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
import utils.Bcrypt;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private UserService us = null;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Login() {
    super();
    this.us = new UserService();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    String url = "/default/account/login/index.jsp";

    request.getRequestDispatcher(url).forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String url = "./account";
    String nextUrl = request.getParameter("caller");
    if (nextUrl != null) {
      url += nextUrl;
      System.out.println("=====================No");
    } else {
      url = url + "/default/account/index.jsp";
    }
    try {
      String email = request.getParameter("email").trim();
      String pwdNotHash = request.getParameter("password").trim();

      // Get user by email
      User u = this.us.findBy("email", email);
      // Check user is null?
      if (u == null) {
        handleLoginFailed(request, response);
      } else {
        boolean isMatchPwd = Bcrypt.checkpwd(pwdNotHash, u.getPassword());
        // Check pwd input with pwd in db
        if (!isMatchPwd) {
          handleLoginFailed(request, response);
        } else {
          // save user data on session
          session.setAttribute("user", u);
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    response.sendRedirect(url);
  }

  private void handleLoginFailed(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("errMsg", "*Tài khoản hoặc mật khẩu không chính xác");
    doGet(request, response);
    return;
  }

}
