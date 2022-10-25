package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "user_id")
  private String userId;

  private String address;

  private String email;

  private String fullname;

  private String code;

  @Column(name = "is_active_acc")
  private byte isActiveAcc;

  @Column(name = "is_delete_acc")
  private byte isDeleteAcc;

  private String password;

  private String phonenumber;

  // bi-directional many-to-one association to Bill
  @OneToMany(mappedBy = "user")
  private List<Bill> bills;

  // bi-directional many-to-one association to Role
  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  public User() {
  }

  public User(String userId, String fullname, String address, String phonenumber, String email, String pwd) {
    this.userId = userId;
    this.fullname = fullname;
    this.address = address;
    this.phonenumber = phonenumber;
    this.email = email;
    this.password = pwd;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFullname() {
    return this.fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public byte getIsActiveAcc() {
    return this.isActiveAcc;
  }

  public void setIsActiveAcc(byte isActiveAcc) {
    this.isActiveAcc = isActiveAcc;
  }

  public byte getIsDeleteAcc() {
    return this.isDeleteAcc;
  }

  public void setIsDeleteAcc(byte isDeleteAcc) {
    this.isDeleteAcc = isDeleteAcc;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhonenumber() {
    return this.phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public List<Bill> getBills() {
    return this.bills;
  }

  public void setBills(List<Bill> bills) {
    this.bills = bills;
  }

  public Bill addBill(Bill bill) {
    getBills().add(bill);
    bill.setUser(this);

    return bill;
  }

  public Bill removeBill(Bill bill) {
    getBills().remove(bill);
    bill.setUser(null);

    return bill;
  }

  public Role getRole() {
    return this.role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }

}