package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Category;
import utils.Common;

public class CategoryService {
  public List<Category> getAllShirtType() {
    EntityManager em = Common.getEntityManager();

    String typeProduct = "AO";
    String queryString = "SELECT c FROM Category c WHERE c.producttype ='" + typeProduct + "'";

    TypedQuery<Category> query = em.createQuery(queryString, Category.class);
    List<Category> categories = query.getResultList();
    return categories;
  }

  public List<Category> getAllShortType() {
    EntityManager em = Common.getEntityManager();

    String typeProduct = "QUAN";

    TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.producttype ='" + typeProduct + "'",
        Category.class);
    List<Category> categories = query.getResultList();
    return categories;
  }

//	Lấy sản phầm theo id của sản phẩm
  public Category findCategorydById(String CategoryId) {
    EntityManager em = Common.getEntityManager();
    Category category = em.find(Category.class, CategoryId);

    return category;
  }

  public List<Category> findAll() {
    EntityManager em = Common.getEntityManager();
    TypedQuery<Category> query = em.createNamedQuery("Category.findAll", Category.class);
    return query.getResultList();
  }

  public List<Category> findBy(String pType) {
    EntityManager em = Common.getEntityManager();
    TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.producttype = '" + pType + "'",
        Category.class);
    List<Category> categories = query.getResultList();
    return query.getResultList();
  }

}
