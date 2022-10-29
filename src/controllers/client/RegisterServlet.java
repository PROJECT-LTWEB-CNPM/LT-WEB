package controllers.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Role;
import models.User;
import services.RoleService;
import services.SendMail;
import utils.Bcrypt;
import utils.Helper;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public RegisterServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "/default/account/register/index.jsp";
    try {
    } catch (Exception e) {
      url = "/error/index.jsp";
    }
    request.getRequestDispatcher(url).forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

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
    RoleService rs = new RoleService();

    // Get Role
    Role r = rs.getRoleByRoleId("ROL1");

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

}
