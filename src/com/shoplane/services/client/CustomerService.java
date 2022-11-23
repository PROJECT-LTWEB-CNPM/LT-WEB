package com.shoplane.services.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoplane.dao.RoleDAO;
import com.shoplane.dao.UserDAO;
import com.shoplane.models.Role;
import com.shoplane.models.User;
import com.shoplane.utils.Bcrypt;
import com.shoplane.utils.Helper;

public class CustomerService {

  HttpServletRequest request = null;
  HttpServletResponse response = null;
  UserDAO userDAO = null;

  public CustomerService(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
    this.userDAO = new UserDAO();
  }

  // Get login
  public void handleGetLogin() {
    try {
      HttpSession session = request.getSession();
      response.setCharacterEncoding("UTF-8");
      String url = "/default/account/login/index.jsp";

      User user = (User) session.getAttribute("user");

      if (user != null) {
        url = "./cart";
        response.sendRedirect(url);
        return;
      }
      request.getRequestDispatcher(url).forward(request, response);

    } catch (Exception e) {
      System.out.println("Login controller " + e.getMessage());
    }
  }

  // Post Login
  public void handlePostLogin() throws IOException {
    HttpSession session = request.getSession();
    String url = "./account";
    String nextUrl = request.getParameter("caller");
    if (nextUrl != null && !nextUrl.equals(url)) {
      url = nextUrl;
    }
    try {
      String email = request.getParameter("email").trim();
      String pwdNotHash = request.getParameter("password").trim();

      // Get user by email
      User u = null;
      // Check user is null?
      if (u == null) {
        handleLoginFailed(request, response);
        /*
         * } else {
         * boolean isMatchPwd = Bcrypt.checkpwd(pwdNotHash, u.getPassword());
         * // Check pwd input with pwd in db
         * if (!isMatchPwd) {
         * handleLoginFailed(request, response);
         * } else {
         * // save user data on session
         * session.setAttribute("user", u);
         * }
         */ }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    response.sendRedirect(url);
  }

  private void handleLoginFailed(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("errMsg", "*Tài khoản hoặc mật khẩu không chính xác");
    this.handleGetLogin();
    return;
  }

  // Get Register
  public void handleGetRegister() throws ServletException, IOException {
    String url = "/default/account/register/index.jsp";
    try {
    } catch (Exception e) {
      url = "/error/index.jsp";
    }
    request.getRequestDispatcher(url).forward(request, response);
  }

  // Post Register
  public void handlePostRegister() throws IOException {
    // init services
    SendMail sm = new SendMail();

    // Get Session
    HttpSession session = request.getSession();

    String url = request.getContextPath() + "/verify";
    try {
      // Get User
      User user = this.handleGetUser(request);
      // Set code
      user.setCode(sm.getRandom());

      // send mail code to user
      boolean isSended = sm.sendMail(user);

      if (isSended) {
        System.out.println("Send mail success");
      } else {
        System.out.println("Send mail fail");
      }

      // set user to session
      session.setAttribute("user", user);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    response.sendRedirect(url);
  }

  private User handleGetUser(HttpServletRequest request) {

    // init services
    // RoleService rs = new RoleService();
    RoleDAO roleDAO = new RoleDAO();

    // Get Role
    Role r = roleDAO.find("ROL1");

    // Get param from sign up fomr
    String userId = Helper.getRandom();
    String fullName = request.getParameter("fullName").trim();
    String phonenumber = request.getParameter("phonenumber").trim();
    String address = request.getParameter("address").trim();
    String email = request.getParameter("email").trim();
    String pwd = request.getParameter("password").trim();

    // Get hashed pwd
    String pwdHashed = Bcrypt.hashpwd(pwd);
    if (pwdHashed == null) {
      pwdHashed = "";
    }

    // Get user
    User user = new User(userId, fullName, address, phonenumber, email, pwdHashed);
    user.setRole(r);

    return user;
  }

  // Get Verify
  public void handleGetVerify() throws ServletException, IOException {
    this.request.setCharacterEncoding("UTF-8");
    this.response.setCharacterEncoding("UTF-8");

    String url = "/default/account/register/verify.jsp";
    request.getRequestDispatcher(url).forward(request, response);
  }

  public void handlePostVerify() throws IOException {

    String url = "./login";
    String code = request.getParameter("code").trim();
    User user = (User) this.request.getSession().getAttribute("user");
    try {
      if (code.equals(user.getCode())) {
        this.userDAO.create(user);
        this.request.getSession().removeAttribute("user");
      } else {
        request.setAttribute("errMsg", "*Mã xác nhận không đúng vui lòng nhập lại");
        this.handleGetVerify();
        return;
      }
    } catch (Exception e) {
      url = "./error";
    }
    response.sendRedirect(url);
  }

  // Get Logout
  public void handleGetLogout() {

  }
}
