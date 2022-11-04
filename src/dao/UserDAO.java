package dao;

import java.util.List;

import models.User;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User> {
  public UserDAO() {
  }

  @Override
  public User create(User entity) {
    return super.create(entity);
  }

  @Override
  public User update(User entity) {
    return super.update(entity);
  }

  @Override
  public void delete(Object id) {
    super.delete(User.class, id);
  }

  @Override
  public User find(Object primaryKey) {
    return super.find(User.class, primaryKey);
  }

  @Override
  public List<User> findAll(String queryString) {
    return super.findAll(queryString, User.class);
  }

}
