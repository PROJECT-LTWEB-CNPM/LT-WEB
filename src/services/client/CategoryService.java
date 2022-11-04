package services.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Category;
import utils.Common;

public class CategoryService {

  public CategoryService() {
  }

  public List<Category> getAllShirtType() {
    String typeProduct = "AO";
    return this.findBy(typeProduct);
  }

  public List<Category> getAllShortType() {
    String typeProduct = "QUAN";
    return this.findBy(typeProduct);

  }

  // Lấy sản phầm theo id của sản phẩm
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
    return query.getResultList();
  }
  
  public  List<Category> getCategoryByCategoryName(String categoryName) {
    EntityManager em = Common.getEntityManager();
    
    TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.categoryName like '%" + categoryName + "%'", Category.class);
    List<Category> categories = query.getResultList();
    return categories;
}

}
