package controllers.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bill
 */
@WebServlet("/system/bills/")
public class BillServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public BillServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = "/system/bills/index.jsp";
    request.getRequestDispatcher(url).forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
