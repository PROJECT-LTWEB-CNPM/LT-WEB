package services;

import javax.persistence.EntityManager;

import models.ProductType;
import utils.Common;

public class ProductTypeService {
  public ProductType findBy(String typeId) {
    EntityManager em = Common.getEntityManager();
    ProductType pt = em.find(ProductType.class, typeId);
    return pt;
  }
}
