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
import com.shoplane.utils.Constants;
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
  public void handleGetLogin() throws ServletException, IOException {
    try {
      HttpSession session = request.getSession();

      String url = "/default/account/login/index.jsp";

      User user = (User) session.getAttribute("user");

      if (user != null) {
        url = "./account";
        response.sendRedirect(url);
        return;
      }
      this.request.getRequestDispatcher(url).forward(request, response);

    } catch (Exception e) {
      String errorPage = "/500.jsp";
      this.request.getRequestDispatcher(errorPage).forward(request, response);
    }
  }

  // Post Login
  public void handlePostLogin() throws IOException, ServletException {
    try {
      String url = "./account";
      String nextUrl = request.getParameter("caller");
      String email = request.getParameter("email").trim();
      String pwdNotHash = request.getParameter("password").trim();

      // Check Url
      if (!nextUrl.equals("") && !nextUrl.equals(url)) {
        url = nextUrl;
      }

      // Get user by email
      User u = this.userDAO.findByEmail(email);
      // Check user
      if (u != null) {
        // Check pwd
        if (Bcrypt.checkpwd(pwdNotHash, u.getPassword())) {
          request.getSession().setAttribute("user", u);
          response.sendRedirect(url);
        } else {
          request.setAttribute("errMsg", "*Mật khẩu không chính xác");
          this.handleGetLogin();
        }
      } else {
        request.setAttribute("errMsg", "*Email không tồn tại");
        this.handleGetLogin();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      String errorUrl = "/500.jsp";
      request.getRequestDispatcher(errorUrl).forward(request, response);
    }
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
    Role r = roleDAO.find(Constants.USER_ROLE);

    // Get param from sign up form
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
  public void handleGetLogout() throws IOException, ServletException {
    try {
      this.request.getSession().removeAttribute("user");
      this.response.sendRedirect("./login");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      String errorPage = "/500.jsp";
      this.request.getRequestDispatcher(errorPage).forward(request, response);
    }
  }
}
