package com.shoplane.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoplane.models.Bill;
import com.shoplane.models.User;

public class BillDAO extends JpaDAO<Bill> implements GenericDAO<Bill> {
  public BillDAO() {
    super();
  }

  @Override
  public Bill create(Bill entity) {
    return super.create(entity);
  }

  @Override
  public Bill update(Bill entity) {
    return super.update(entity);
  }

  @Override
  public void delete(Object id) {
    super.delete(Bill.class, id);
  }

  @Override
  public Bill find(Object primaryKey) {
    // TODO Auto-generated method stub
    return super.find(Bill.class, primaryKey);
  }

  @Override
  public List<Bill> findAll() {
    String queryName = "Bill.findAll";
    return super.findAll(queryName, Bill.class);
  }

  @Override
  public List<Bill> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
    return super.findWithNamedQuery(queryName, parameters);
  }

  public List<Bill> findByUser(User user) {
    String queryName = "Bill.findByUser";
    Map<String, Object> param = new HashMap<>();
    param.put("user", user);
    return this.findWithNamedQuery(queryName, param);
  }

  @Override
  public List<Bill> pagination(int currentPage, int pageSize) {
    String queryName = "Bill.findAll";
    return super.pagination(queryName, Bill.class, currentPage, pageSize);
  }

}
