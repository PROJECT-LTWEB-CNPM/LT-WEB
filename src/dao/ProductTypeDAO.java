package dao;

import java.util.List;
import java.util.Map;

import models.ProductType;

public class ProductTypeDAO extends JpaDAO<ProductType> implements GenericDAO<ProductType> {
  public ProductTypeDAO() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public ProductType create(ProductType entity) {
    // TODO Auto-generated method stub
    return super.create(entity);
  }

  @Override
  public ProductType update(ProductType entity) {
    // TODO Auto-generated method stub
    return super.update(entity);
  }

  @Override
  public void delete(Object id) {
    // TODO Auto-generated method stub

  }

  @Override
  public ProductType find(Object primaryKey) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ProductType> findAll(String queryString) {
    // TODO Auto-generated method stub
    return super.findAll(queryString, ProductType.class);
  }

  @Override
  public List<ProductType> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
    // TODO Auto-generated method stub
    return super.findWithNamedQuery(queryName, parameters);
  }
}
