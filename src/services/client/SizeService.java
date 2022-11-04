package services.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import models.Size;
import utils.Common;

public class SizeService {

  public SizeService() {

  }

  public Size getSize(String sizeId, String sizeName) {
    Size s = new Size();
    s.setSizeId(sizeId);
    s.setSizeName(sizeName);
    return s;
  }

  public int addSize(Size size) {
    EntityManager em = Common.getEntityManager();
    EntityTransaction tss = em.getTransaction();
    try {
      tss.begin();
      // Code here...
      System.out.println(size.getSizeId() + size.getSizeName());
      em.persist(size);
      tss.commit();
    } catch (Exception e) {
      tss.rollback();
      System.out.println("Eror from add size");
      return -1;
    } finally {
      // Close connection
      em.close();
    }
    return 1;
  }

  public List<Size> findAll() {
    EntityManager em = Common.getEntityManager();
    String queryString = "Size.findAll";
    Query q = em.createNamedQuery(queryString);
    return q.getResultList();
  }
}
