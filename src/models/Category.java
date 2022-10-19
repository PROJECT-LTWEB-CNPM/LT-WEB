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
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "category_id")
  private String categoryId;

  @Column(name = "category_name")
  private String categoryName;

  // bi-directional many-to-one association to ProductType
  @ManyToOne
  @JoinColumn(name = "product_type")
  private ProductType producttype;

  // bi-directional many-to-one association to Product
  @OneToMany(mappedBy = "category")
  private List<Product> products;

  public Category() {
  }

  public String getCategoryId() {
    return this.categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return this.categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public ProductType getProducttype() {
    return this.producttype;
  }

  public void setProducttype(ProductType producttype) {
    this.producttype = producttype;
  }

  public List<Product> getProducts() {
    return this.products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public Product addProduct(Product product) {
    getProducts().add(product);
    product.setCategory(this);

    return product;
  }

  public Product removeProduct(Product product) {
    getProducts().remove(product);
    product.setCategory(null);

    return product;
  }

}