package com.shoplane.services.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoplane.dao.ProductDAO;
import com.shoplane.dao.ProductImageDAO;
import com.shoplane.models.Product;
import com.shoplane.models.ProductImage;
import com.shoplane.services.SuperService;
import com.shoplane.utils.Constants;

public class ProductImageService extends SuperService {

  ProductImageDAO productImageDAO = null;
  ProductDAO productDAO = null;

  public ProductImageService(HttpServletRequest request, HttpServletResponse response) {
    super(request, response);
    this.productImageDAO = new ProductImageDAO();
    this.productDAO = new ProductDAO();
  }

  // [GET] ListPreviewImageServlet
  public void getImageList() throws IOException {
    try {
      super.setEncoding(Constants.UTF8);
      String url = "/system/imagesPreview/list/imagesPreview.jsp";
      String productId = super.getParameter("product_id");

      // Get data
      Product product = this.productDAO.find(productId);
      List<ProductImage> productImages = this.productImageDAO.findByProduct(product);

      // Set att
      super.setAttribute("productId", productId);
      super.setAttribute("product", product);
      super.setAttribute("productImages", productImages);

      // forward
      super.forwardToPage(url);
    } catch (Exception e) {
      super.log(e.getMessage());
      String error = super.getContextPath() + "/system/500";
      super.redirectToPage(error);

    }
  }

}
