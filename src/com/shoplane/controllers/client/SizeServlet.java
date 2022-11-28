package com.shoplane.controllers.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.SizeDAO;
import com.shoplane.models.Size;

@WebServlet("/SizeController")
public class SizeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public SizeServlet() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      String sizeId = request.getParameter("sizeId");
      String sizeName = request.getParameter("sizeName");
      SizeDAO sizeDAO = new SizeDAO();
      Size s = new Size();
      s.setSizeId(sizeId);
      s.setSizeName(sizeName);
      sizeDAO.create(s);
      List<Size> sizes = sizeDAO.findAll();
      System.out.println(sizes.size());
    } catch (Exception e) {
      System.out.println("Error at Size Controller");
    }
  }

}
