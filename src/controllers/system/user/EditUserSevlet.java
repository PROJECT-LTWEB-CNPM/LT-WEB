package controllers.system.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import models.Role;
import models.User;
import services.client.RoleService;

@WebServlet("/system/users/edit")
public class EditUserSevlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  RoleService roleService = null;

  public EditUserSevlet() {
    super();
    roleService = new RoleService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = "/system/users/edit/index.jsp";
    String userId = request.getParameter("user_id");
    UserDAO userDao = new UserDAO();
    User user = userDao.find(userId);
    List<Role> roles = this.roleService.findAll();
    request.setAttribute("user", user);
    request.setAttribute("roles", roles);
    request.getRequestDispatcher(url).forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
