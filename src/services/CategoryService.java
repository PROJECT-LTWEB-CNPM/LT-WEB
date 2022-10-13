package services;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Category;
import utils.Common;


public class CategoryService {
	
	
	
	private List<Category> listCategories;

	
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
	
	
	
}
