package services.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import models.Role;
import utils.Common;

public class RoleService {
  public RoleService() {

  }

  public Role getRoleByRoleId(String roleId) {
    Role r = null;
    EntityManager em = Common.getEntityManager();
    EntityTransaction tss = em.getTransaction();
    try {
      tss.begin();
      // Code here...
      r = em.find(Role.class, roleId);
      tss.commit();
    } catch (Exception e) {
      tss.rollback();
      System.out.println("Eror from add user");
      em.close();
      return null;
    }
    em.close();
    return r;
  }

  public List<Role> findAll() {
    List<Role> roles = null;
    EntityManager em = Common.getEntityManager();
    TypedQuery<Role> query = em.createNamedQuery("Role.findAll", Role.class);

    roles = query.getResultList();
    return roles;
  }
}
