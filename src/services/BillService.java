package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import models.Bill;
import models.User;
import utils.Common;

public class BillService {
  EntityManager em;
  EntityTransaction tss;

  public BillService() {
    this.em = Common.getEntityManager();
    this.tss = this.em.getTransaction();
  }

// Add new bill
  public boolean add(Bill bill) {
    boolean isAdd = false;
    try {
      tss.begin();
      // Code here...
      em.persist(bill);
      tss.commit();
      isAdd = true;
    } catch (Exception e) {
      tss.rollback();
      System.out.println(e.getMessage());
    } finally {
      // Close connection
      em.close();
    }
    return isAdd;
  }

  public List<Bill> findByUser(User user) {
    try {
      String queryString = "SELECT b FROM Bill b WHERE b.user = ?1";

      TypedQuery<Bill> query = this.em.createQuery(queryString, Bill.class);
      query.setParameter(1, user);
      return query.getResultList();
    } catch (Exception e) {
      System.out.println("Error when get list bill by user id" + e.getMessage());
      return null;
    }
  }
}
