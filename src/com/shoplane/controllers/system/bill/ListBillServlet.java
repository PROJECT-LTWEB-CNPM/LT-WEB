package com.shoplane.controllers.system.bill;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.BillDAO;
import com.shoplane.models.Bill;
import com.shoplane.services.system.BillService;

@WebServlet(urlPatterns = { "/system/bills/", "/system/bills" })
public class ListBillServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BillDAO billDAO = null;

  public ListBillServlet() {
    super();
    this.billDAO = new BillDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    BillService billService = new BillService(request, response);
    billService.getListBill();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // define url, action on this servlet
    String url = "./";
    String[] selectedBills = request.getParameterValues("selectedBills");

    // validate and detele multiple bills
    if (selectedBills == null) {
      System.out.println("can't get checkbox params");
    } else {
      for (int i = 0; i < selectedBills.length; i++) {
        System.out.println(selectedBills[i]);
        Bill b = this.billDAO.find(selectedBills[i]);
        this.billDAO.delete(b);
      }
    }

    // redirect to current page
    response.sendRedirect(url);
  }

}
