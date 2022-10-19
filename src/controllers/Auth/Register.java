package controllers.Auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Role;
import models.User;
import services.RoleService;

/**
 * Servlet implementation class Register
 */
@WebServlet("/default/account/register")
public class Register extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Register() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  private String getUid() {
    return "u01";
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      String fullName = request.getParameter("fullName");
      String phonenumber = request.getParameter("phonenumber");
      String address = request.getParameter("address");
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      String uid = this.getUid();
      User user = new User(uid, fullName, address, phonenumber, email, password);

      RoleService rs = new RoleService();
      Role r = rs.getRoleByRoleId("ROL1");
      user.setRole(r);
//			int isAdded = us.add(user);
      int isAdded = 1;
      if (isAdded == 1) {
        String url = request.getContextPath() + "/default/account/login.jsp";
        response.sendRedirect(url);
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
      doGet(request, response);
    }
  }

}
