package controllers.system.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Role;
import services.client.RoleService;

@WebServlet("/system/users/create")
public class CreateUserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  RoleService roleService = null;

  public CreateUserServlet() {
    super();
    roleService = new RoleService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = "/system/users/create/index.jsp";
    List<Role> roles = this.roleService.findAll();
    request.setAttribute("roles", roles);

    request.getRequestDispatcher(url).forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = "./";
    response.sendRedirect(url);

  }

}
