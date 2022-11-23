package com.shoplane.services.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.shoplane.models.Bill;
import com.shoplane.models.Order;
import com.shoplane.utils.Common;

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
  
  
//  public static List<Order> findOrderByBillId (String BillId){
//    EntityManager em = Common.getEntityManager();
//    String qString = "SELECT o FROM Order o " + 
//        "WHERE o.BillId = :BillId";
//    TypedQuery<Order> o = em.createQuery(qString, Order.class);
//    o.setParameter("BillId", BillId);
//    
//    List<Order> orders = null;
//    try {
//      orders = o.getResultList();
//      if (orders == null || orders.isEmpty()) {
//        orders = null;
//      }
//    }finally {
//      em.close();
//    }
//    return orders;
//  }
  
  
}
