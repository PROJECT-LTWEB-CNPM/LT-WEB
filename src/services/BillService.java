package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import utils.Common;

import models.Bill;
import models.User;
public class BillService {
  
    // get all bills
  public static List<Bill> getAll(){
    EntityManager em = Common.getEntityManager();
    String qString = "Select b from Bill b";
    
    TypedQuery<Bill> b = em.createQuery(qString, Bill.class);
    List<Bill> bills;
    try {
      bills = b.getResultList();
      if (bills == null || bills.isEmpty()) {
        bills = null;
      }
    }finally {
      em.close();
    }
    return bills;
  }
  
  public List<Bill> findByUser(User user) {
    EntityManager em = Common.getEntityManager();
    String qString = "Select b from Bill b" +
                      "where b.user='" + user.getUserId() + "'";

    TypedQuery<Bill> b = em.createQuery(qString, Bill.class);
    List<Bill> bills;
    try {
      bills = b.getResultList();
      if (bills == null || bills.isEmpty()) {
        bills = null;
      }
    }finally {
      em.close();
    }
    return bills;
  }
  
  public boolean add(Bill bill) {
    EntityManager em = Common.getEntityManager();
    EntityTransaction trans = em.getTransaction();
    try {
      trans.begin();
      em.persist(bill);
      trans.commit();
      return true;
    }catch (Exception ex){
      trans.rollback();
      return false;
    }finally {
      em.close();
    }
  }
  
  public static Bill findBillById(String Id) {
    EntityManager em = Common.getEntityManager();
    String qString = "SELECT b FROM Bill b " + 
                      "WHERE b.billId = :Id";
    TypedQuery<Bill> b = em.createQuery(qString, Bill.class);
    b.setParameter("Id", Id);
    
    Bill bill = null;
    try {
      bill = b.getSingleResult();
    }catch(Exception ex) {
      System.out.println(ex);
    }finally {
      em.close();
    }
    return bill;
  }
  
  public static boolean delete(Bill deletedBill) {
    EntityManager em = Common.getEntityManager();
    EntityTransaction trans = em.getTransaction();
    try {
      trans.begin();
      em.remove(em.merge(deletedBill));
      trans.commit();
      return true;
    }catch(Exception ex) {
      trans.rollback();
      return false;
    }finally {
      em.close();
    }
    
  }

}
