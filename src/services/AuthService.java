package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import models.User;
import utils.Common;

public class AuthService {
  // User login
  public User userLogin(String email, String pwd) {
    EntityManager em = Common.getEntityManager();
    EntityTransaction tss = em.getTransaction();
    try {
      tss.begin();
      // Code here...
      em.find(User.class, email);
      tss.commit();
    } catch (Exception e) {
      tss.rollback();
      System.out.println("Eror from add user");
      return null;
    } finally {
      // Close connection
      em.close();
    }
    return null;
  }
}
