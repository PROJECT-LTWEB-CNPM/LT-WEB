package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import models.Category;
import utils.Common;

public class CategoryService {
  
  
  
  // Code của Duy
  private List<Category> listCategories;

  
  public CategoryService() {
    
  }
  
  public CategoryService(String productType) {
      this.listCategories = new ArrayList<Category>(getCategoriesByType(productType));
  }


  public List<Category> getListCategories() {
      return this.listCategories;
  }

  
  
  // Get Categories By Product Type Id
  public List<Category> getCategoriesByType(String pt){
      
      EntityManager em = Common.getEntityManager();
      String qString = "Select pt from Category pt where pt.producttype='" + pt + "'" ;
      
      TypedQuery<Category> q = em.createQuery(qString, Category.class);
      
      List <Category> listCats;
      try {
          listCats = q.getResultList();
          if (listCats == null || listCats.isEmpty()) {
              listCats = null;
          }
          
          
      }finally {
          em.close();
      }
      return listCats;
  }
  

  public String getCategoryNameById (String Cid) {
      EntityManager em = Common.getEntityManager();
      String categoryName = "";
      try {
          if (Cid == null || Cid == "") {
              categoryName = "TẤT CẢ";
          }else {
              Category cat = em.find(Category.class, Cid);
              categoryName = cat.getCategoryName();
          }
      }finally {
          em.close();
      }
      return categoryName;
  }
  
  
  
 // code của Trường
	public List<Category> getAllShirtType() {
		EntityManager em = Common.getEntityManager();
		EntityTransaction tss = em.getTransaction();
		
		String typeProduct = "AO";
		
		TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.producttype ='" + typeProduct + "'", Category.class);
		List<Category> categories = query.getResultList();
		return categories;
	}
	
	public List<Category> getAllShortType() {
		EntityManager em = Common.getEntityManager();
		EntityTransaction tss = em.getTransaction();
		
		String typeProduct = "QUAN";
		
		TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.producttype ='" + typeProduct + "'", Category.class);
		List<Category> categories = query.getResultList();
		return categories;
	}
	
	
	
//	Lấy sản phầm theo id của sản phẩm
	public Category findCategorydById(String CategoryId) {
		EntityManager em = Common.getEntityManager();
		Category category = em.find(Category.class, CategoryId);
	
		return category;
	}

}
