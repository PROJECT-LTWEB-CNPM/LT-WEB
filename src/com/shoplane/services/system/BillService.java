package com.shoplane.services.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoplane.dao.BillDAO;
import com.shoplane.models.Bill;
import com.shoplane.services.SuperService;
import com.shoplane.utils.Constants;
import com.shoplane.utils.Helper;

public class BillService extends SuperService {

  BillDAO billDAO = null;

  public BillService(HttpServletRequest request, HttpServletResponse response) {
    super(request, response);
    this.billDAO = new BillDAO();
  }

  // [GET] ListBillServlet
  public void getListBill() throws IOException {
    try {
      // Set url patten active sidebar item
      super.getSession().setAttribute("urlPatten", Constants.BILLS);
      // Set encoding
      super.setEncoding(Constants.UTF8);
      // define url
      String url = "/system/bills/list/index.jsp";
      String statusStr = super.getParameter("status");
      String currentPageStr = super.getParameter("current_page");
      String pageSizeStr = super.getParameter("page_size");

      // Convert string to int
      int currentPage = 1;
      int pageSize = 10;
      int status = 2;

      if (currentPageStr != null && pageSizeStr != null) {
        if (Helper.isNumeric(currentPageStr)) {
          currentPage = Integer.parseInt(currentPageStr);
        }

        if (Helper.isNumeric(pageSizeStr)) {
          pageSize = Integer.parseInt(pageSizeStr);
        }
      }
      if (statusStr != null) {
        if (Helper.isNumeric(statusStr)) {
          status = Integer.parseInt(statusStr);
        }
      }

      Map<String, Object> params = new HashMap<>();
      List<Bill> bills = new ArrayList<>();
      int totalItem = this.billDAO.count();

      // Get data
      if (statusStr.equals(Constants.ALL_STATUS)) {
        bills = this.billDAO.pagination(currentPage, pageSize);
      } else {
        params.put("statusBill", (byte) status);
        bills = this.billDAO.paginationByStatus(params, currentPage, pageSize);
        totalItem = this.billDAO.countByStatus(params);
      }
      // Chưa ổn lắm => Cần phải fix chỉnh lại chỗ này
      int totalPage = (int) Math.ceil((double) totalItem / pageSize);

      // set params and forward
      super.setAttribute("bills", bills);
      super.setAttribute("status", status);
      super.setAttribute("currentPage", currentPage);
      super.setAttribute("pageSize", pageSize);
      super.setAttribute("totalPage", totalPage);
      super.forwardToPage(url);

    } catch (Exception e) {
      super.log(e.getMessage());
      String error = super.getContextPath() + "/system/500";
      super.redirectToPage(error);
    }
  }

  // [GET] EditBillServlet
  public void getEditBill() throws IOException {
    try {
      super.setEncoding(Constants.UTF8);
      // define url to forward
      String url = "/system/bills/detail/index.jsp";

      // get bill Id
      String billId = request.getParameter("bill_id");

      // find bill By Id
      Bill foundBill = this.billDAO.find(billId);

      // create new Session
      HttpSession session = request.getSession();

      // validate then set parameter to forward
      if (foundBill != null) {
        session.setAttribute("bill", foundBill);
      } else {
        super.log("Can't retrieve bill");
      }

      // Set Att
      super.setAttribute("billId", billId);
      // forward parameter to another page
      super.forwardToPage(url);

    } catch (Exception e) {
      super.log(e.getMessage());
      String error = super.getContextPath() + "/system/500";
      super.redirectToPage(error);
    }
  }

  // [POST] EditBillServlet
  public void updateBill() throws IOException {
    try {
      // define url to redirect
      String url = "/system/bills";

      // get updated value from updating form
      int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
      byte status = Byte.parseByte(request.getParameter("status"));

      // create new session
      HttpSession httpSession = request.getSession();

      // get bill object from previous session
      Bill updatedBill = (Bill) httpSession.getAttribute("bill");

      // validate Bill
      if (updatedBill != null) {
        updatedBill.setTotalPrice(totalPrice);
        updatedBill.setStatusBill(status);
        this.billDAO.update(updatedBill);
      }

      // redirect to BillServlet
      this.redirectToPage(url);

    } catch (Exception e) {
      super.log(e.getMessage());
      String error = super.getContextPath() + "/system/500";
      this.redirectToPage(error);
    }
  }

  // [GET] CreateBillServlet
  public void getBillForm() throws IOException {
    try {
      // define url to redirect
      String url = "/system/bills/create/index.jsp";

      super.forwardToPage(url);

    } catch (Exception e) {
      super.log(e.getMessage());
      String error = super.getContextPath() + "/system/500";
      this.redirectToPage(error);
    }
  }

}
