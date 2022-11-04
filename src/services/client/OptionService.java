package services.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Option;
import utils.Common;

public class OptionService {

  public OptionService() {

  }

  public List<Option> findBy(String pId) {
    EntityManager em = Common.getEntityManager();

    String queryString = "SELECT o FROM Option o WHERE o.product ='" + pId + "'";

    TypedQuery<Option> query = em.createQuery(queryString, Option.class);
    List<Option> options = query.getResultList();
    return options;
  }

  public Option find(String oId) {
    EntityManager em = Common.getEntityManager();
    Option o = em.find(Option.class, oId);
    return o;
  }
}
