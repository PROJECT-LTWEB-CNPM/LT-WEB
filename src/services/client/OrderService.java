package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import models.Order;
import utils.Common;

public class OrderService {
  EntityManager em;
  EntityTransaction tss;

  public OrderService() {
    this.em = Common.getEntityManager();
    this.tss = this.em.getTransaction();
  }

  public boolean addList(List<Order> orders) {
    boolean isAdd = false;
    try {
      tss.begin();
      // Code here...
      for (Order order : orders) {
        em.persist(order);
      }
      tss.commit();
      isAdd = true;
    } catch (Exception e) {
      tss.rollback();
      System.out.println("Error when insert multiple order " + e.getMessage());
    } finally {
      // Close connection
      em.close();
    }
    return isAdd;
  }

  public boolean add(Order order) {
    boolean isAdd = false;
    try {
      tss.begin();
      // Code here...
      em.persist(order);
      tss.commit();
      isAdd = true;
    } catch (Exception e) {
      tss.rollback();
      System.out.println("here " + e.getMessage());
    } finally {
      // Close connection
      em.close();
    }
    return isAdd;
  }
}
