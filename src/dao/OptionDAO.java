package dao;

import java.util.List;
import java.util.Map;

import models.Option;

public class OptionDAO extends JpaDAO<Option> implements GenericDAO<Option> {
  public OptionDAO() {
  }

  @Override
  public Option create(Option entity) {
    return super.create(entity);
  }

  @Override
  public Option update(Option entity) {
    // TODO Auto-generated method stub
    return super.update(entity);
  }

  @Override
  public void delete(Object id) {
    // TODO Auto-generated method stub

  }

  @Override
  public Option find(Object primaryKey) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Option> findAll(String queryString) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Option> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
    // TODO Auto-generated method stub
    return super.findWithNamedQuery(queryName, parameters);
  }
}
