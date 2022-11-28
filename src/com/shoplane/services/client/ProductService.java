package com.shoplane.services.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.shoplane.models.Product;
import com.shoplane.utils.Common;
import com.shoplane.utils.Constants;

public class ProductService {

  // create default constructor
  public ProductService() {

  }

  public List<Product> getOrderedProduct(List<Product> products, String orderType) {
    List<Product> listResult = new ArrayList<>(products);

    switch (orderType) {
      case Constants.ASC:
        Collections.sort(listResult, CompareProduct.LOWEST_PRICE);
        break;
      case Constants.DESC:
        Collections.sort(listResult, CompareProduct.HIGHEST_PRICE);
      case Constants.NEWEST:
        Collections.reverse(listResult);
        break;
      default:
        break;
    }

    return listResult;
  }

//	Lấy tất cả các sản phẩm là áo
  public List<Product> getAllShirt() {
    EntityManager em = Common.getEntityManager();

    String typeProduct = "AO";

    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.producttype ='" + typeProduct + "'",
        Product.class);
    List<Product> products = query.getResultList();
    return products;
  }

// 	Lấy tất cả các sản phẩm là áo với số lượng xác định
  public List<Product> getAllShirt(int page, int pageSize) {
    EntityManager em = Common.getEntityManager();

    String typeProduct = "AO";

    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.producttype ='" + typeProduct + "'",
        Product.class);
    query.setFirstResult(page * pageSize);
    query.setMaxResults(pageSize);

    List<Product> products = query.getResultList();
    return products;
  }

//	Lấy tất cả các sản phẩm là quần
  public List<Product> getAllShort() {
    EntityManager em = Common.getEntityManager();

    String typeProduct = "QUAN";

    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.producttype ='" + typeProduct + "'",
        Product.class);
    List<Product> products = query.getResultList();
    return products;
  }

// 	Lấy tất cả các sản phẩm là quần với số lượng xác định
  public List<Product> getAllShort(int page, int pageSize) {
    EntityManager em = Common.getEntityManager();

    String typeProduct = "QUAN";

    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.producttype ='" + typeProduct + "'",
        Product.class);
    query.setFirstResult(page * pageSize);
    query.setMaxResults(pageSize);

    List<Product> products = query.getResultList();
    return products;
  }

}
