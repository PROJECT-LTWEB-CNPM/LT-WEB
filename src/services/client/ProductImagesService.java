package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.ProductImage;
import utils.Common;

public class ProductImagesService {

  public ProductImagesService() {

  }

//	Lấy list hình ảnh theo product của sản phẩm
  public List<ProductImage> getAllProductImage(String productId) {
    EntityManager em = Common.getEntityManager();

    TypedQuery<ProductImage> query = em.createQuery("SELECT p FROM ProductImage p WHERE p.product ='" + productId + "'",
        ProductImage.class);
    List<ProductImage> productImages = query.getResultList();
    return productImages;
  }

//	Lấy sản phầm theo id của sản phẩm
  public ProductImage findProductImageById(String imageId) {
    EntityManager em = Common.getEntityManager();
    ProductImage productImage = em.find(ProductImage.class, imageId);

    return productImage;
  }
}
