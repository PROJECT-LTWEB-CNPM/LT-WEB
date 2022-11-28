package com.shoplane.controllers.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.OptionDAO;
import com.shoplane.dao.ProductDAO;
import com.shoplane.dao.ProductImageDAO;
import com.shoplane.models.Option;
import com.shoplane.models.Order;
import com.shoplane.models.Product;
import com.shoplane.models.ProductImage;
import com.shoplane.services.client.ProductService;
import com.shoplane.utils.Helper;

@WebServlet(urlPatterns = { "/product-detail", "/product-detail/" })
public class ProductDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  OptionDAO optionDAO = null;
  ProductDAO productDAO = null;

  public ProductDetailServlet() {
    super();
    optionDAO = new OptionDAO();
    this.productDAO = new ProductDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String productId = request.getParameter("product_id").trim();
    if (productId != null) {
      // Get product by productId
      Product product = this.getProductByPId(productId);
      request.getSession().setAttribute("product", product);

      // Get list image preview
      List<ProductImage> productImages = this.getPImages(productId);
      request.setAttribute("productImages", productImages);

      List<Option> options = this.getOptionsByPId(productId);
      request.setAttribute("options", options);

      // Forward url
      String url = "/default/product-detail/index.jsp";
      request.getRequestDispatcher(url).forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      // Get data from input form
      String optionId = req.getParameter("oId").trim();
      String quantyString = req.getParameter("quanty").trim();
      int quanty = Integer.parseInt(quantyString);
      // Get Option
//      OptionService os = new OptionService();
      Option option = this.optionDAO.find(optionId);
      // Calc price
      int price = option.getProduct().getNewPrice() * quanty;
      // orderid
      String oId = Helper.getRandom();

      // Create order
      Order o = new Order(oId, new Date(), quanty, price, option);

      // Add order to list
      @SuppressWarnings("unchecked")
      List<Order> ors = (List<Order>) req.getSession().getAttribute("orders");
      if (ors == null) {
        ors = new ArrayList<>();
        ors.add(o);
      } else {
        boolean flag = false;
        for (Order or : ors) {
          if (or.getOption().getOptionId().equals(o.getOption().getOptionId())) {
            int currOrderQuanty = or.getOrderedQuantity() + o.getOrderedQuantity();
            int newPriceOrder = or.getPrice() + o.getPrice();
            or.setOrderedQuantity(currOrderQuanty);
            or.setPrice(newPriceOrder);
            flag = true;
            break;
          }
        }
        if (!flag) {
          ors.add(o);
        }
      }
      // Set att session
      req.getSession().setAttribute("orders", ors);
      req.getSession().setAttribute("orderSize", ors.size());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  protected List<ProductImage> getPImages(String pId) {
    // ProductImagesService productImagesService = new ProductImagesService();
    ProductDAO productDAO = new ProductDAO();
    ProductImageDAO productImageDAO = new ProductImageDAO();
    Product p = productDAO.find(pId);
    List<ProductImage> productImages = productImageDAO.findByProduct(p);
    return productImages;
  }

  protected Product getProductByPId(String pId) {
    ProductService productSevice = new ProductService();
    Product product = this.productDAO.find(pId);
    return product;
  }

  protected List<Option> getOptionsByPId(String pId) {
    Product product = this.productDAO.find(pId);
    List<Option> options = this.optionDAO.findByProduct(product);
    return options;
  }

}
