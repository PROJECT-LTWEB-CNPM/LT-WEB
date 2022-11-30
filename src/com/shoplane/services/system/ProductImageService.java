package com.shoplane.services.system;

import java.io.IOException;
import java.util.ArrayList;
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

  // [GET] CreateProductImageServlet
  public void getProductImageForm() throws IOException {
    try {
      super.setEncoding(Constants.UTF8);
      String url = "/system/imagesPreview/create/index.jsp";
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

  // [POST] CreateProductImageServlet
  public void createProductImage() throws IOException {
    try {
      super.setEncoding(Constants.UTF8);
      // Get Params
      String productId = super.getParameter("productId").trim();
      String imageId = super.getParameter("imageId").trim();
      String imageUrl = super.getParameter("imageUrl").trim();

      // Define url
      String url = super.getContextPath() + "/system/products/images/?product_id=" + productId;

      // Get data
      Product product = this.productDAO.find(productId);

      // Create
      ProductImage productImage = new ProductImage();
      productImage.setImageId(imageId);
      productImage.setImageUrl(imageUrl);
      productImage.setProduct(product);
      this.productImageDAO.create(productImage);

      // Set att
      super.setAttribute("productId", productId);
      super.setAttribute("product", product);

      // forward
      super.redirectToPage(url);

    } catch (Exception e) {
      super.log(e.getMessage());
      String error = super.getContextPath() + "/system/500";
      super.redirectToPage(error);
    }
  }

  // [GET] EditProductImageServlet
  public void getProductImageEditForm() throws IOException {
    try {
      super.setEncoding(Constants.UTF8);
      String url = "/system/imagesPreview/detail/index.jsp";
      String productId = super.getParameter("product_id");
      String imageId = super.getParameter("image_id");

      // Get data
      Product product = this.productDAO.find(productId);
      ProductImage productImage = this.productImageDAO.find(imageId);

      // Set att
      super.setAttribute("productId", productId);
      super.setAttribute("product", product);
      super.setAttribute("imageId", imageId);
      super.setAttribute("productImage", productImage);

      // forward
      super.forwardToPage(url);
    } catch (Exception e) {
      super.log(e.getMessage());
      String error = super.getContextPath() + "/system/500";
      super.redirectToPage(error);
    }
  }

  // [POST] EditProductImageServlet
  public void updateProductImage() throws IOException {
    try {
      super.setEncoding(Constants.UTF8);
      // Get Params
      String productId = super.getParameter("productId").trim();
      String imageId = super.getParameter("imageId").trim();
      String imageUrl = super.getParameter("imageUrl").trim();

      // Define url
      String url = super.getContextPath() + "/system/products/images/?product_id=" + productId;

      // Get data
      Product product = this.productDAO.find(productId);

      // Create
      ProductImage productImage = this.productImageDAO.find(imageId);
      productImage.setImageId(imageId);
      productImage.setImageUrl(imageUrl);
      productImage.setProduct(product);
      this.productImageDAO.update(productImage);

      // Set att
      super.setAttribute("productId", productId);
      super.setAttribute("product", product);

      // forward
      super.redirectToPage(url);

    } catch (Exception e) {
      super.log(e.getMessage());
      String error = super.getContextPath() + "/system/500";
      super.redirectToPage(error);
    }
  }

  // [GET] DeleteProductImage
  public void deleteProductImage() throws IOException {
    try {
      super.setEncoding(Constants.UTF8);
      // Get Params
      String productId = super.getParameter("product_id").trim();
      String imageIdsSelected = super.getParameter("imagesSelected");
      String[] imageIds = null;
      List<ProductImage> productImages = new ArrayList<>();
      ProductImage productImage = null;

      // Convert ids str to Array
      if (!imageIdsSelected.equals("")) {
        imageIds = imageIdsSelected.split(",");
      }
      // Check
      if (imageIds != null) {
        for (String imageId : imageIds) {
          productImage = this.productImageDAO.find(imageId);
          productImages.add(productImage);
        }
      }

      this.productImageDAO.bulkDelete(productImages);

      // Define url
      String url = super.getContextPath() + "/system/products/images/?product_id=" + productId;

      // Get data
      Product product = this.productDAO.find(productId);

      // Set att
      super.setAttribute("productId", productId);
      super.setAttribute("product", product);

      // forward
      super.redirectToPage(url);

    } catch (Exception e) {
      String error = super.getContextPath() + "/system/500";
      super.redirectToPage(error);
    }
  }

}
