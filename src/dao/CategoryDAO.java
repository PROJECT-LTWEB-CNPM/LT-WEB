package dao;

import java.util.List;
import java.util.Map;

import models.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {
  public CategoryDAO() {
  }

  @Override
  public Category create(Category entity) {
    // TODO Auto-generated method stub
    return super.create(entity);
  }

  @Override
  public Category update(Category entity) {
    // TODO Auto-generated method stub
    return super.update(entity);
  }

  @Override
  public void delete(Object id) {
    // TODO Auto-generated method stub

  }

  @Override
  public Category find(Object primaryKey) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Category> findAll(String queryString) {
    return super.findAll(queryString, Category.class);
  }

  @Override
  public List<Category> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
    // TODO Auto-generated method stub
    return super.findWithNamedQuery(queryName, parameters);
  }
}
