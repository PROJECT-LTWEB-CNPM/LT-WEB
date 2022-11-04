package dao;

import java.util.List;

import models.Product;

public class ProductDAO extends JpaDAO<Product> implements GenericDAO<Product> {
  public ProductDAO() {
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
  public List<Product> findAll(String queryString) {
    return super.findAll(queryString, Product.class);
  }

}
