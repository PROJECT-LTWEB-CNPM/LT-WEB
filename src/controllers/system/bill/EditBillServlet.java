package controllers.system.bill;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Bill;
import services.client.BillService;

@WebServlet("/system/bills/detail")
public class EditBillServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public EditBillServlet() {
    super();

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // define url to forward
    String url = "/system/bills/detail/index.jsp";

    // get bill Id
    String billId = request.getParameter("bill");

    // find bill By Id
    Bill foundBill = BillService.findBillById(billId);

    // create new Session
    HttpSession session = request.getSession();

    // validate then set parameter to forward
    if (foundBill != null) {
      session.setAttribute("bill", foundBill);
    } else {
      System.out.println("Can't retrieve bill");
    }

    // forward parameter to another page
    getServletContext().getRequestDispatcher(url).forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // define url to redirect
    String url = "/system/bills/";

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
      BillService.update(updatedBill);
    }

    // redirect to BillServlet
    response.sendRedirect(request.getContextPath() + url);

  }

}
