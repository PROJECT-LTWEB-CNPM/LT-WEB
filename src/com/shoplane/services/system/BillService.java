package com.shoplane.services.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoplane.dao.BillDAO;
import com.shoplane.models.Bill;
import com.shoplane.services.SuperService;
import com.shoplane.utils.Constants;

public class BillService extends SuperService {

  BillDAO billDAO = null;

  public BillService(HttpServletRequest request, HttpServletResponse response) {
    super(request, response);
    this.billDAO = new BillDAO();
  }

  // [GET] ListBillServlet
  public void getListBill() throws IOException {
    try {
      // Set encoding
      super.setEncoding(Constants.UTF8);
      // define url
      String url = "/system/bills/list/index.jsp";

      // get all current bills in database
      List<Bill> bills = this.billDAO.findAll();

      // set params and forward
      super.setAttribute("bills", bills);
      super.forwardToPage(url);
    } catch (Exception e) {
      super.log(e.getMessage());
      String error = "/500";
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
      String billId = request.getParameter("id");

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
      // forward parameter to another page
      super.forwardToPage(url);

    } catch (Exception e) {
      super.log(e.getMessage());
      String error = "/500";
      this.redirectToPage(error);
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
      String error = "/500";
      this.redirectToPage(error);
    }
  }

}
