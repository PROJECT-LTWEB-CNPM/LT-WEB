package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Product;
import utils.Common;

public class ProductService {
	
	
	private List<Product> listP = new ArrayList<>();
	private List<Product> listPC = new ArrayList<>();
	
	public ProductService(String productType, String categoryId) {
		this.listP =  getProductByType(productType);
		this.listPC = getProductByCategory(categoryId);
	}


	public List<Product> getListP() {
		return this.listP;
	}
	
	public List<Product> getListPC() {
		return this.listPC;
	}

	
	
	// Get Categories By Product Type Id
	private List<Product> getProductByType(String pt){
		
		EntityManager em = Common.getEntityManager();
	
		String qString = "Select pt from Product pt where pt.producttype='" + pt + "'" ;
		
		TypedQuery<Product> q = em.createQuery(qString, Product.class);
		
		List <Product> listP;
		try {
			listP = q.getResultList();
			if (listP == null || listP.isEmpty()) {
				listP = null;
			}			
		}finally {
			em.close();
		}
		
		return listP;
	}
	
	
	public List<Product> getProductByCategory(String ct){
		
		EntityManager em = Common.getEntityManager();
		
		String qString = "Select p from Product p where p.category='" + ct + "'" ;
		
		TypedQuery<Product> q = em.createQuery(qString, Product.class);
		
		List <Product> listP;
		
		try {
			listP = q.getResultList();
			if (listP == null || listP.isEmpty()) {
				listP = null;
			}			
		}finally {
			em.close();
		}
		

		return listP;
	}
	
	
}
