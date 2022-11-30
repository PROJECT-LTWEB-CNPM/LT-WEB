package com.shoplane.services.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.RoleDAO;
import com.shoplane.dao.UserDAO;
import com.shoplane.models.Role;
import com.shoplane.models.User;
import com.shoplane.services.SuperService;
import com.shoplane.utils.Constants;
import com.shoplane.utils.Helper;

public class UserService extends SuperService {

  UserDAO userDAO = null;
  RoleDAO roleDAO = null;

  public UserService(HttpServletRequest request, HttpServletResponse response) {
    super(request, response);
    this.userDAO = new UserDAO();
    this.roleDAO = new RoleDAO();
  }

  // [GET] ListUserServlet
  public void getListUser() throws IOException {
    try {
      super.setEncoding(Constants.UTF8);
      // Set active sidebar item
      super.getSession().setAttribute("urlPatten", Constants.USERS);
      // Define url
      String url = "/system/users/list/index.jsp";

      String roleId = super.getParameter("role_id");
      String currentPageStr = super.getParameter("current_page");
      String pageSizeStr = super.getParameter("page_size");

      int currentPage = 1;
      int pageSize = 10;
      if (currentPageStr != null && pageSizeStr != null) {
        if (Helper.isNumeric(currentPageStr)) {
          currentPage = Integer.parseInt(currentPageStr);
        }

        if (Helper.isNumeric(pageSizeStr)) {
          pageSize = Integer.parseInt(pageSizeStr);
        }
      }
      if (roleId == null) {
        roleId = Constants.ALL_ROLE;
      }

      // Get Data
      List<User> users = new ArrayList<>();
      List<Role> roles = this.roleDAO.findAll();
      Role role = this.roleDAO.find(roleId);

      // Create params
      Map<String, Object> params = new HashMap<>();
      int totalItem = this.userDAO.count();

      if (roleId.equals(Constants.ALL_ROLE)) {
        // users = this.userDAO.findByIsDeleted(Byte.parseByte("0"));
        users = this.userDAO.pagination(currentPage, pageSize);
      } else {
        params.put("role", role);
        users = this.userDAO.findByRole(params);
        totalItem = this.userDAO.countByRole(params);
      }

      // Chưa ổn lắm => Cần phải fix chỉnh lại chỗ này
      int totalPage = (int) Math.ceil((double) totalItem / pageSize);

      // Set att
      super.setAttribute("users", users);
      super.setAttribute("roles", roles);
      super.setAttribute("roleId", roleId);
      super.setAttribute("currentPage", currentPage);
      super.setAttribute("pageSize", pageSize);
      super.setAttribute("totalItem", totalItem);
      super.setAttribute("totalPage", totalPage);

      // forward
      super.forwardToPage(url);
    } catch (Exception e) {
      super.log(e.getMessage());
      String error = super.getContextPath() + "/system/500";
      super.redirectToPage(error);
    }
  }

}
