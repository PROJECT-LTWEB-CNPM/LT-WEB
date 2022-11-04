package controllers.system;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

@WebServlet(urlPatterns = { "/system/users/", "/system/users/edit/", "/system/users/add/", "/system/users/delete/"})
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public UserServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String pageContext = request.getRequestURL().toString();
    String url = "/system/users/index.jsp";
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");

    String pageType = request.getParameter("pageType");
    String userNeedToEdit = request.getParameter("userNeedToEdit");

    if (pageType.equals("user/index.jsp")) {
      loadUserDataToManageUserPage(request, response, pageContext);
    } else if (pageType.equals("user/form/index.jsp")) {
        if (userNeedToEdit.equals("add")) {
        loadUserDataToManageUserForm(request, response, pageContext, null, "add");
      } 
      else {
        loadUserDataToManageUserForm(request, response, pageContext, userNeedToEdit, "edit");
      }
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
    String url = "http://localhost:8080/shoplane-ft/system/users/index.jsp";
    String uri = request.getRequestURL().toString();
    String pageType = request.getParameter("pageType");
    String listUserNeedToDelete = request.getParameter("listUserNeedToDelete");
    
    if (uri.contains("edit")) {
      update(request, response, url);
    } else if (uri.contains("add")) {
      add(request, response, url);
    }
    else if (pageType.contains("delete")) {
//      System.out.println("==============="+ listUserNeedToDelete +"======================");
      softDelete(request, response, listUserNeedToDelete, url);
    }
  }

  public void loadUserDataToManageUserPage(HttpServletRequest request, HttpServletResponse response,
      String pageContext) throws ServletException, IOException {
    UserService userService = new UserService();
    RoleService roleService = new RoleService();
    List<User> listUser = new ArrayList<>();
    listUser = userService.getAll("is_delete_acc", "0");

    PrintWriter out = response.getWriter();
    for (User user : listUser) {
      out.println("<div class=\"table__row\">\r\n"
          + "                            <div style=\"width: 5%\">\r\n"
          + "                                <input type=\"checkbox\" value=\""+ user.getUserId() +"\">\r\n"
          + "                            </div>\r\n"
          + "                            <div style=\"width: 10%\">" + user.getUserId() + "</div>\r\n"
          + "                            <div style=\"width: 25%\">" + user.getFullname() + "</div>\r\n"
          + "                            <div style=\"width: 25%\">" + user.getEmail() + "</div>\r\n"
          + "                            <div style=\"width: 15%\">" + roleService.getRoleByRoleId(user.getRole().getRoleId()).getRoleName() + "</div>\r\n"
          + "                            <div style=\"width: 15%\">20/11/2016</div>\r\n"
          + "                            <div style=\"width: 10%\" class=\"table__link\">\r\n"
          + "                                <a href=\"" + pageContext + "form/index.jsp?edit=" + user.getUserId()
          + "\">Xem chi tiết</a>\r\n"
          + "                            </div>\r\n"
          + "                        </div>");
    }
  }

  public void loadUserDataToManageUserForm(HttpServletRequest request, HttpServletResponse response,
      String pageContext, String userNeedToEdit, String activity) throws ServletException, IOException {
    String [] active = {"checked",""};
    String [] delete = {"","checked"};
    String [] roleAccount = {"", "", "checked", ""};
    
    User user = new User();
    UserService userService = new UserService();
    user = userService.findBy("user_id", userNeedToEdit);

    if (user == null) {
      user = new User("", "", "", "", "", "");
    }
    else {
      if (user.getIsActiveAcc() == 0) {
        active[0] = "";
        active[1] = "checked";
      }
      
      if (user.getIsDeleteAcc() == 1) {
        delete[0] = "checked";
        delete[1] = "";
      }
      
      if (user.getRole().getRoleId().equals("R01")) {
        roleAccount[0] = "checked";
        roleAccount[2] = "";
      }
      else if (user.getRole().getRoleId().equals("R02")) {
        roleAccount[1] = "checked";
        roleAccount[2] = "";
      }
      else if (user.getRole().getRoleId().equals("R04")) {
        roleAccount[3] = "checked";
        roleAccount[2] = "";
      }
    }
//    System.out.print("=============" + fileNeedToEdit + "=============");

    PrintWriter out = response.getWriter();

    out.println("<form action=\"" + pageContext + "" + activity + "/\" method=\"post\">"
        + "<div class=\"customer_info-item\">\r\n"
        + "                            <label for=\"userId\">User ID: </label> <input type=\"text\"\r\n"
        + "                                name=\"userId\" id=\"userId\" placeholder=\"User ID\" value=\""
        + user.getUserId() + "\">\r\n"
        + "                        </div>\r\n"
        + "                        <div class=\"customer_info-item\">\r\n"
        + "                            <label for=\"fullname\">Họ và tên: </label> <input type=\"text\"\r\n"
        + "                                name=\"fullname\" id=\"fullname\" placeholder=\"Họ và tên\" value=\""
        + user.getFullname() + "\">\r\n"
        + "                        </div>\r\n"
        + "                        <div class=\"customer_info-item\">\r\n"
        + "                            <label for=\"email\">Email: </label> <input type=\"text\"\r\n"
        + "                                name=\"email\" id=\"email\" placeholder=\"Email\" value=\"" + user.getEmail()
        + "\">\r\n"
        + "                        </div>\r\n"
        + "                        <div class=\"customer_info-item\">\r\n"
        + "                            <label for=\"phonenumber\">Số điện thoại: </label> <input\r\n"
        + "                                type=\"text\" name=\"phonenumber\" id=\"phonenumber\"\r\n"
        + "                                placeholder=\"Số điện thoại\" value=\"" + user.getPhonenumber() + "\">\r\n"
        + "                        </div>\r\n"
        + "                        <div class=\"customer_info-item\">\r\n"
        + "                            <label for=\"address\">Địa chỉ: </label> <input type=\"text\"\r\n"
        + "                                name=\"address\" id=\"address\" placeholder=\"Địa chỉ\" value=\""
        + user.getAddress() + "\">\r\n"
        + "                        </div>\r\n"
        + "                        <div class=\"customer_info-item\">\r\n"
        + "                            <label for=\"password\">Mật khẩu: </label> <input type=\"text\"\r\n"
        + "                                name=\"password\" id=\"password\" placeholder=\"Mật khẩu\" value=\""
        + user.getPassword() + "\">\r\n"
        + "                        </div>\r\n"
        + "<div class=\"customer_info-item-select\">\r\n"
        + "                    <label for=\"productName\">Trạng thái User account: </label>\r\n"
        + "                    <div class=\"select-button\">\r\n"
        + "                        <input type=\"radio\" id=\"active\" name=\"isActiveAcc\" value=\"1\" "+ active[0] +">\r\n"
        + "                         <label class=\"select-button-label\" for=\"active\">Active</label><br>\r\n"
        + "                         <input type=\"radio\" id=\"inactive\" name=\"isActiveAcc\" value=\"0\""+ active[1] +">\r\n"
        + "                         <label class=\"select-button-label\" for=\"inactive\">InActive</label><br>\r\n"
        + "                        <br>\r\n"
        + "                    </div>\r\n"
        + "                </div>\r\n"
        + "                <div class=\"customer_info-item-select\">\r\n"
        + "                    <label for=\"productName\">Trạng thái User account: </label>\r\n"
        + "                    <div class=\"select-button\">\r\n"
        + "                        <input type=\"radio\" id=\"delete\" name=\"isDeleteAcc\" value=\"1\""+ delete[0] +">\r\n"
        + "                         <label class=\"select-button-label\" for=\"delete\">Delete</label><br>\r\n"
        + "                         <input type=\"radio\" id=\"undelete\" name=\"isDeleteAcc\" value=\"0\" "+ delete[1] +">\r\n"
        + "                         <label class=\"select-button-label\" for=\"undelete\">Undelete</label><br>\r\n"
        + "                        <br>\r\n"
        + "                    </div>\r\n"
        + "                </div>"
        + "                 <div class=\"customer_info-item-select\">\r\n"
        + "                        <label for=\"productName\">Vai trò: </label>\r\n"
        + "                        <div class=\"select-button\">\r\n"
        + "                            <input type=\"radio\" id=\"admin\" name=\"roleAccount\" value=\"R01\""+ roleAccount[0] +">\r\n"
        + "                             <label class=\"select-button-label\" for=\"admin\">Admin</label><br>\r\n"
        + "                             <input type=\"radio\" id=\"employee\" name=\"roleAccount\" value=\"R02\""+ roleAccount[1] +">\r\n"
        + "                             <label class=\"select-button-label\" for=\"employee\">Nhân viên</label><br>\r\n"
        + "                            <input type=\"radio\" id=\"customer\" name=\"roleAccount\" value=\"R03\" "+ roleAccount[2] +">\r\n"
        + "                             <label class=\"select-button-label\" for=\"customer\">Khách hàng</label><br>\r\n"
        + "                            <input type=\"radio\" id=\"boss\" name=\"roleAccount\" value=\"R04\""+ roleAccount[3] +">\r\n"
        + "                             <label class=\"select-button-label\" for=\"boss\">Chủ</label><br>\r\n"
        + "                            <br>\r\n"
        + "                        </div>\r\n"
        + "                    </div>"  
        + "                        <button type=\"submit\" class=\"save_change\">Lưu</button>"
        + "</form>");
  }

  public void update(HttpServletRequest request, HttpServletResponse response, String url)
      throws ServletException, IOException {
    try {
      User user = new User();
      Role role = new Role();
      RoleService roleService = new RoleService();
      UserService userService = new UserService();
      
      role = roleService.getRoleByRoleId(request.getParameter("roleAccount"));
      BeanUtils.populate(user, request.getParameterMap());
      
      user.setRole(role);
      userService.update(user);
      response.sendRedirect(url);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void add(HttpServletRequest request, HttpServletResponse response, String url)
      throws ServletException, IOException {
    try {
      User user = new User();
      Role role = new Role();
      RoleService roleService = new RoleService();
      UserService userService = new UserService();
      
      role = roleService.getRoleByRoleId(request.getParameter("roleAccount"));
      BeanUtils.populate(user, request.getParameterMap());
      
      user.setRole(role);
      userService.add(user);
      response.sendRedirect(url);
    } catch (Exception e) {
      System.out.println("ERROR");
    }
  }
  
  public void softDelete (HttpServletRequest request, HttpServletResponse response, String listUserNeedToDelete, String url) {
    UserService userService = new UserService();
    User user = new User();
    
    if (listUserNeedToDelete != null) {
      for (String item : listUserNeedToDelete.split("/")) {
        if(!item.equals("on")) {
          user = userService.findBy("user_id", item);
          user.setIsDeleteAcc((byte)1);
          userService.update(user);
        }
      }
    }
  }
}
