package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import models.Category;
import utils.Common;

public class CategoryService {
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
//	Lấy danh mục sản phẩm theo category name --> return List các category thỏa điều kiện
	public  List<Category> getCategoryByCategoryName(String categoryName) {
		EntityManager em = Common.getEntityManager();
		EntityTransaction tss = em.getTransaction();
		
		TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.categoryName like '%" + categoryName + "%'", Category.class);
		List<Category> categories = query.getResultList();
		return categories;
	}
}
