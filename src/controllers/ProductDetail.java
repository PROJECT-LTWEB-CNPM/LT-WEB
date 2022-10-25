package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Option;
import models.Order;
import models.Product;
import models.ProductImage;
import services.OptionService;
import services.ProductImagesService;
import services.ProductService;
import utils.Helper;

@WebServlet("/product-detail")
public class ProductDetail extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ProductDetail() {
    super();
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
      OptionService os = new OptionService();
      Option option = os.find(optionId);
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
    ProductImagesService productImagesService = new ProductImagesService();
    List<ProductImage> productImages = productImagesService.getAllProductImage(pId);
    return productImages;
  }

  protected Product getProductByPId(String pId) {
    ProductService productSevice = new ProductService();
    Product product = productSevice.findProductdById(pId);
    return product;
  }

  protected List<Option> getOptionsByPId(String pId) {
    OptionService os = new OptionService();
    List<Option> options = os.findBy(pId);
    return options;
  }

}
