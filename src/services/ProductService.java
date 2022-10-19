package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import models.Product;
import utils.Common;

public class ProductService {
//	Lấy tất cả các sản phẩm không phân biệt là quần hay áo
  public List<Product> getAll() {
    EntityManager em = Common.getEntityManager();
    TypedQuery<Product> query = em.createNamedQuery("Product.findAll", Product.class);

    return query.getResultList();
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
    EntityTransaction tss = em.getTransaction();

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
    EntityTransaction tss = em.getTransaction();

    String typeProduct = "QUAN";

    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.producttype ='" + typeProduct + "'",
        Product.class);
    List<Product> products = query.getResultList();
    return products;
  }

// 	Lấy tất cả các sản phẩm là quần với số lượng xác định
  public List<Product> getAllShort(int page, int pageSize) {
    EntityManager em = Common.getEntityManager();
    EntityTransaction tss = em.getTransaction();

    String typeProduct = "QUAN";

    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.producttype ='" + typeProduct + "'",
        Product.class);
    query.setFirstResult(page * pageSize);
    query.setMaxResults(pageSize);

    List<Product> products = query.getResultList();
    return products;
  }

//	Lấy sản phầm theo id của sản phẩm
  public Product findProductdById(String productId) {
    EntityManager em = Common.getEntityManager();
    Product product = em.find(Product.class, productId);

    return product;
  }

//	Tìm sản phẩm theo category id
  public List<Product> getAllShortByCategoryId(String categoryId) {
    EntityManager em = Common.getEntityManager();
    EntityTransaction tss = em.getTransaction();

    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.category ='" + categoryId + "'",
        Product.class);

    List<Product> products = query.getResultList();
    return products;
  }

  public List<Product> findBy(String cateType, String cateId) {
    EntityManager em = Common.getEntityManager();
    EntityTransaction tss = em.getTransaction();

    String queryString = "SELECT p FROM Product p WHERE p.producttype ='" + cateType + "'";

    if (cateId != "") {
      queryString += " AND p.category = '" + cateId + "'";
    }

    TypedQuery<Product> query = em.createQuery(queryString,
        Product.class);

    List<Product> products = query.getResultList();
    return products;
  }
}
