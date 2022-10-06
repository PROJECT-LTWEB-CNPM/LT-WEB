package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.ProductType;
import utils.Common;


public class ProductTypeService {
	private List<ProductType> listProductType;

	
	public ProductTypeService() {
		this.listProductType = new ArrayList<ProductType>(getAllProductType());
	}


	public List<ProductType> getListProductType() {
		return listProductType;
	}


	public List<ProductType> getAllProductType(){
		EntityManager em = Common.getEntityManager();
		
		String qString = "Select pt from ProductType pt";
		
		TypedQuery<ProductType> q = em.createQuery(qString, ProductType.class);
		
		List <ProductType> lProductType;
		try {
			lProductType = q.getResultList();
			if (lProductType == null || lProductType.isEmpty()) {
				lProductType = null;
			}
			
		}finally {
			em.close();
		}
		
		return lProductType;
	}
		
}
