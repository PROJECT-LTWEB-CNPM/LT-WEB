package com.shoplane.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoplane.models.Category;
import com.shoplane.models.Product;
import com.shoplane.models.ProductType;

public class ProductDAO extends JpaDAO<Product> implements GenericDAO<Product> {
  public ProductDAO() {
    super();
  }

  @Override
  public Product create(Product entity) {
    return super.create(entity);
  }

  @Override
  public Product update(Product entity) {
    return super.update(entity);
  }

  @Override
  public void delete(Object id) {
    super.delete(Product.class, id);
  }

  @Override
  public Product find(Object primaryKey) {
    return super.find(Product.class, primaryKey);
  }

  @Override
  public List<Product> findAll() {
    String queryString = "Product.findAll";
    return super.findAll(queryString, Product.class);
  }

  @Override
  public List<Product> pagination(int currentPage, int pageSize) {
    String queryString = "Product.findAll";
    return super.pagination(queryString, Product.class, currentPage, pageSize);
  }

  @Override
  public int count() {
    String queryName = "Product.count";
    return super.count(queryName);
  }

  public List<Product> findByProductType(ProductType productType) {
    String queryName = "Product.findByProductType";
    Map<String, Object> param = new HashMap<>();
    param.put("productType", productType);
    return this.findWithNamedQuery(queryName, param);
  }

  public List<Product> findByCategory(Category category) {
    String queryName = "Product.findByCategory";
    Map<String, Object> param = new HashMap<>();
    param.put("category", category);
    return this.findWithNamedQuery(queryName, param);
  }

  public List<Product> findByProductName(String productName) {
    String queryName = "Product.findByProductName";
    Map<String, Object> param = new HashMap<>();
    productName = "%" + productName + "%";
    param.put("productName", productName);
    return this.findWithNamedQuery(queryName, param);
  }

  public List<Product> findByCategoryAndProductType(ProductType productType, Category category) {
    List<Product> products = null;

    if (category != null) {
      String queryName = "Product.findByCategoryAndProductType";
      Map<String, Object> params = new HashMap<>();
      params.put("category", category);
      params.put("productType", productType);
      products = this.findWithNamedQuery(queryName, params);
    } else {
      products = this.findByProductType(productType);
    }
    return products;
  }

  public List<Product> paginationByProductTypeAndCategory(Map<String, Object> parameters, int currentPage,
      int pageSize) {
    String queryName = "Product.findByCategoryAndProductType";
    return super.paginationWithNamedQuery(queryName, Product.class, parameters, currentPage, pageSize);
  }

  public List<Product> paginationByProductType(Map<String, Object> parameters, int currentPage,
      int pageSize) {
    String queryName = "Product.findByProductType";
    return super.paginationWithNamedQuery(queryName, Product.class, parameters, currentPage, pageSize);
  }

  public int countByProductType(Map<String, Object> params) {
    String queryName = "Product.countByProductType";
    return super.countWithNamedQuery(queryName, params);
  }

  public int countByProductTypeAndCategory(Map<String, Object> params) {
    String queryName = "Product.countByProductTypeAndCategory";
    return super.countWithNamedQuery(queryName, params);
  }
}
