package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Product;
import utils.Common;

public class ProductService {

  private List<Product> listP = new ArrayList<>();
  private List<Product> listPC = new ArrayList<>();

  // create default constructor
  public ProductService() {

  }

  public ProductService(String productType, String categoryId) {
    this.listP = getProductByType(productType);
    this.listPC = getProductByCategory(categoryId);
  }

  public List<Product> getListP() {
    return this.listP;
  }

  public List<Product> getListPC() {
    return this.listPC;
  }

  // Get Categories By Product Type Id
  private List<Product> getProductByType(String pt) {

    EntityManager em = Common.getEntityManager();

    String qString = "Select pt from Product pt where pt.producttype='" + pt + "'";

    TypedQuery<Product> q = em.createQuery(qString, Product.class);

    List<Product> listP;
    try {
      listP = q.getResultList();
      if (listP == null || listP.isEmpty()) {
        listP = null;
      }
    } finally {
      em.close();
    }

    return listP;
  }

  // get products by type public method
  public List<Product> getAllProductByType(String productType) {
    EntityManager em = Common.getEntityManager();
    String qString = "Select pt from Product pt where pt.producttype='" + productType + "'";

    TypedQuery<Product> q = em.createQuery(qString, Product.class);

    List<Product> listP;
    try {
      listP = q.getResultList();
      if (listP == null || listP.isEmpty()) {
        listP = null;
      }
    } finally {
      em.close();
    }

    return listP;
  }

  public static List<Product> getProductByCategory(String ct) {

    EntityManager em = Common.getEntityManager();

    String qString = "Select p from Product p where p.category='" + ct + "'";

    TypedQuery<Product> q = em.createQuery(qString, Product.class);

    List<Product> listP;

    try {
      listP = q.getResultList();
      if (listP == null || listP.isEmpty()) {
        listP = null;
      }
    } finally {
      em.close();
    }

    return listP;
  }

  public List<Product> getOrderedProduct(String typeId, String categoryId, String orderType) {
    List<Product> listResult = new ArrayList<>();

    if (categoryId != null && categoryId != "") {
      listResult = getProductByCategory(categoryId);
    } else {
      listResult = getProductByType(typeId);
    }

    switch (orderType) {
      case "price-ascending":
        Collections.sort(listResult, CompareProduct.LOWEST_PRICE);
        break;
      case "price-descending":
        Collections.sort(listResult, CompareProduct.HIGHEST_PRICE);
        break;
      case "created-descending":
        Collections.reverse(listResult);
        break;

    }

    if (listResult != null) {
      for (Product p : listResult) {
        System.out.println(p.getProductName() + p.getNewPrice());
      }
    } else {
      System.out.println("ListResult is null");
    }
    return listResult;
  }

  // get product by id
  public Product getProductById(String productId) {
    EntityManager em = Common.getEntityManager();
    Product product = em.find(Product.class, productId);
    return product;
  }
  
//  get product by product name
  public List<Product>  getProductByProductName(String productName) {
    EntityManager em = Common.getEntityManager();
    
    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.productName like '%" + productName + "%'", Product.class);
    
    List<Product> products = query.getResultList();
    return products;
  }

  //// CODE của TRường

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

//	Lấy sản phầm theo id của sản phẩm
  public Product findProductdById(String productId) {
    EntityManager em = Common.getEntityManager();
    Product product = em.find(Product.class, productId);

    return product;
  }

//	Tìm sản phẩm theo category id
  public List<Product> getAllShortByCategoryId(String categoryId) {
    EntityManager em = Common.getEntityManager();

    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.category ='" + categoryId + "'",
        Product.class);

    List<Product> products = query.getResultList();
    return products;
  }

  public List<Product> findBy(String cateType, String cateId) {
    EntityManager em = Common.getEntityManager();

    String queryString = "SELECT p FROM Product p WHERE p.producttype ='" + cateType + "'";

    if (cateId != "") {
      queryString += " AND p.category = '" + cateId + "'";
    }

    TypedQuery<Product> query = em.createQuery(queryString,
        Product.class);

    List<Product> products = query.getResultList();
    return products;
  }
  
//Tìm sản phẩm theo category id khi search
public List<Product> getAllProductByCategoryId(String categoryId) {
    EntityManager em = Common.getEntityManager();
    
    TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.category ='" + categoryId + "'", Product.class);
    
    List<Product> products = query.getResultList();
    return products;
}
}
