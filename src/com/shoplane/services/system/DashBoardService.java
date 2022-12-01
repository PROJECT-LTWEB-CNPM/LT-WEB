package com.shoplane.services.system;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.services.SuperService;

public class DashBoardService extends SuperService {

  public DashBoardService(HttpServletRequest request, HttpServletResponse response) {
    super(request, response);
  }

  public void getDashboard() throws IOException {
    try {
      String url = "/system/dashboard/index.jsp";

      // Set url active sidebar
      super.getSession().setAttribute("urlPatten", "");
      super.forwardToPage(url);
    } catch (Exception e) {
      super.log(e.getMessage());
      String error = "/500";
      super.redirectToPage(error);
    }
  }

}
