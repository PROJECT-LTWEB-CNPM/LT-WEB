package services.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.UserDAO;
import models.User;
import utils.Common;

public class UserService {

  EntityManager em;
  EntityTransaction tss;
  private UserDAO userDAO = null;

  public UserService() {
    this.em = Common.getEntityManager();
    this.tss = this.em.getTransaction();
    this.userDAO = new UserDAO();
  }

  // Add new user
  public boolean add(User user) {
    boolean isAdd = false;
    try {
      tss.begin();
      // Code here...
      em.persist(user);
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

  // Update user by id => Update general
//  public int update(String userId, String fullname, String phonenumber, String address) {
//    try {
//      User uSelected = this.findBy("user_id", userId);
//      if (uSelected != null) {
//        tss.begin();
//        uSelected.setFullname(fullname);
//        uSelected.setAddress(address);
//        uSelected.setPhonenumber(phonenumber);
//        em.merge(uSelected);
//        tss.commit();
//        return 1;
//      }
//      return 0;
//    } catch (Exception e) {
//      tss.rollback();
//      return -1;
//    }
//  }
  
  public void update(User user) {
    try {
        EntityTransaction trans = this.em.getTransaction();
        trans.begin();
        em.merge(user);
        trans.commit();
        System.out.print("----------Cap nhat Thanh cong DAO------------");

    } catch (Exception e) {
        System.out.print("----------Cap nhat That bai DAO--------------");
    }
}

  // Delete user by user id
  public int delete(String uid) {
    try {
      User u = this.findBy("user_id", uid);
      if (u != null) {
        tss.begin();
        em.remove(u);
        tss.commit();
        // 1 row deleted;
        return 1;
      }
      // 0 row deleted;
      return 0;

    } catch (Exception e) {
      System.out.println(e.getMessage());
      // Error;
      return -1;
    }
  }

  // Find by id or email
  public User findBy(String field, String value) {
    User uSelected = null;
    try {
      String qString = "SELECT * FROM Users AS U WHERE U." + field + " = :field";
      Query q = this.em.createNativeQuery(qString, User.class);
      q.setParameter("field", value);
      uSelected = (User) q.getSingleResult();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return uSelected;
  }
  // Get all user account in database
  public List<User> getAll() {
    TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
    return query.getResultList();
  }
  
//get all user accounts as long as is_delete_acc = 0 (not deleted)
  public List<User> getAll(String field, String value) {
    List< User> uSelected = null;
    try {
      String qString = "SELECT * FROM Users AS U WHERE U." + field + " = :field";
      Query q = this.em.createNativeQuery(qString, User.class);
      q.setParameter("field", value);
      uSelected = q.getResultList();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return uSelected;
  }

}
