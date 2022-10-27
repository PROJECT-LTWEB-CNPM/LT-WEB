package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name = "roles")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "role_id")
  private String roleId;

  @Column(name = "role_name")
  private String roleName;

  // bi-directional many-to-one association to User
  @OneToMany(mappedBy = "role")
  private List<User> users;

  public Role() {
  }

  public String getRoleId() {
    return this.roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return this.roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public List<User> getUsers() {
    return this.users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public User addUser(User user) {
    getUsers().add(user);
    user.setRole(this);

    return user;
  }

  public User removeUser(User user) {
    getUsers().remove(user);
    user.setRole(null);

    return user;
  }

}