package controllers.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Size;
import services.SizeService;

/**
 * Servlet implementation class SizeController
 */
@WebServlet("/SizeController")
public class SizeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SizeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String sizeId = request.getParameter("sizeId");
			String sizeName = request.getParameter("sizeName");
			SizeService sv = new SizeService();
			Size s = sv.getSize(sizeId, sizeName);
			sv.addSize(s);
			List<Size> sizes = sv.findAll();
			System.out.println(sizes.size());
		} catch (Exception e) {
			System.out.println("Error at Size Controller");
		}
	}

}
