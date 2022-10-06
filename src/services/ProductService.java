package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Product;
import utils.Common;

public class ProductService {
	
	
	private List<Product> listP;
	public ProductService(String productType) {
		this.listP = new ArrayList<Product>(getProductByType(productType));
	}


	public List<Product> getListP() {
		return this.listP;
	}

	
	
	// Get Categories By Product Type Id
	public List<Product> getProductByType(String pt){
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
	
	
}
