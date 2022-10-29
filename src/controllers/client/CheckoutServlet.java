package controllers.client;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Bill;
import models.Order;
import models.User;
import services.BillService;
import services.OrderService;
import utils.Helper;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  BillService bs = null;
  OrderService os = null;

  public CheckoutServlet() {
    super();
    bs = new BillService();
    os = new OrderService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // forward url
      String url = "/default/cart/checkouts/index.jsp";

      // Forward
      request.getRequestDispatcher(url).forward(request, response);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    @SuppressWarnings("unchecked")
    List<Order> orders = (List<Order>) request.getSession().getAttribute("orders");
    User user = (User) request.getSession().getAttribute("user");
    try {

      // Get data from form checkout
      String fullname = request.getParameter("fullname");
      String phonenumber = request.getParameter("phonenumber");
      String address = request.getParameter("address");
      String totalPriceStr = request.getParameter("totalPrice");

      // create Bill
      String billId = Helper.getRandom();
      int totalPrice = Integer.parseInt(totalPriceStr);
      Bill bill = new Bill(billId, new Date(), totalPrice, user);
      // Set bill in each order

      for (Order order : orders) {
        order.setBill(bill);
      }

      // Insert Bill, list order to db

      boolean isAddBill = bs.add(bill);
      if (isAddBill) {
        Boolean isAddOrders = this.os.addList(orders);
        if (isAddOrders) {
          request.getSession().removeAttribute("orders");
          request.getSession().removeAttribute("orderSize");
          String msg = "success";
          response.getWriter().append(msg);
        }
      }

    } catch (Exception e) {
      System.out.println("Here " + e.getMessage());
    }
  }

}
