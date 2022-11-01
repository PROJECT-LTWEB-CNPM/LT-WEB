package controllers.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.BillService;
import models.Bill;



@WebServlet("/system/bills/detail")
public class BillDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BillDetailServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/system/bills/detail/index.jsp";
		String billId = request.getParameter("bill");
		System.out.println("Bill Id is " + billId);
		
		Bill foundBill = BillService.findBillById(billId);
		HttpSession session = request.getSession();
		
		if (foundBill != null) {
		  session.setAttribute("bill", foundBill);
		}else {
		  System.out.println("Can't retrieve bill");
		}
		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   System.out.println("is working");
	    String url = "/system/bills/";
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		byte status = Byte.parseByte(request.getParameter("status"));
		
		HttpSession httpSession = request.getSession();
		Bill updatedBill  = (Bill)httpSession.getAttribute("bill");
		if (updatedBill != null) {
		    updatedBill.setTotalPrice(totalPrice);
	        updatedBill.setStatusBill(status);
	        BillService.update(updatedBill);
		}
		response.sendRedirect(request.getContextPath() + url);
		
	}

}
