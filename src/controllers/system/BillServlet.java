package controllers.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.BillService;
import models.Bill;

@WebServlet("/system/bills/")
public class BillServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public BillServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = "./index.jsp";
    List<Bill> bills = BillService.getAll();
    
    
    if (bills == null) {
      System.out.println("can not retrive bill list or bill list is null");
    }else {
      for(Bill b: bills){
        System.out.println(b.getBillId());
      }
    }
    
    request.setAttribute("bills", bills);
    request.getRequestDispatcher(url).forward(request, response);
  }

 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //logParameters(request, response);
    // get multiple selectd box value
    String url = "./";
    String[] selectedBills= request.getParameterValues("selectedBills");
    //boolean isChosen = true;
    if(selectedBills == null) {
     // isChosen = false;
      System.out.println("can't get checkbox params");
    }else {
      for (int i=0; i< selectedBills.length; i++) {
        
        System.out.println(selectedBills[i]);
        Bill b = BillService.findBillById(selectedBills[i]);
        BillService.delete(b);
      }
    }
    response.sendRedirect(url);
  }
  
  private void logParameters (HttpServletRequest request, HttpServletResponse response) {
    String[] selectedBills= request.getParameterValues("selectedBills");
    if(selectedBills == null) {
      System.out.println("can't get checkbox params");
    }else {
      for (int i=0; i< selectedBills.length; i++) {
        System.out.println(selectedBills[i]);
      }
    }
    
  }

}
