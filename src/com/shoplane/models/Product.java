package com.shoplane.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name = "products")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductType", query = "SELECT p FROM Product p WHERE p.producttype = :productType"),
    @NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p WHERE p.category = :category"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName LIKE :productName"),
    @NamedQuery(name = "Product.findByCategoryAndProductType", query = "SELECT p FROM Product p WHERE p.category = :category AND p.producttype = :productType")
})
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "product_id")
  private String productId;

  @Lob
  private String description;

  @Column(name = "is_active")
  private byte isActive;

  @Column(name = "is_delete")
  private byte isDelete;

  @Lob
  @Column(name = "main_image_url")
  private String mainImageUrl;

  private String meterial;

  @Column(name = "new_price")
  private int newPrice;

  @Column(name = "old_price")
  private int oldPrice;

  private String origin;

  private String pattern;

  @Column(name = "product_name")
  private String productName;

  // bi-directional many-to-one association to Option
  @OneToMany(mappedBy = "product")
  private List<Option> options;

  // bi-directional many-to-one association to ProductImage
  @OneToMany(mappedBy = "product")
  private List<ProductImage> productimages;

  // bi-directional many-to-one association to Category
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  // bi-directional many-to-one association to ProductType
  @ManyToOne
  @JoinColumn(name = "product_type")
  private ProductType producttype;

  public Product() {
  }

  public Product(String productId, String productName, String mainImageUrl, int oldPrice, int newPrice,
      String description, String origin, String pattern, String meterial) {
    this.productId = productId;
    this.productName = productName;
    this.mainImageUrl = mainImageUrl;
    this.oldPrice = oldPrice;
    this.newPrice = newPrice;
    this.description = description;
    this.origin = origin;
    this.pattern = pattern;
    this.meterial = meterial;
  }

  public String getProductId() {
    return this.productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public byte getIsActive() {
    return this.isActive;
  }

  public void setIsActive(byte isActive) {
    this.isActive = isActive;
  }

  public byte getIsDelete() {
    return this.isDelete;
  }

  public void setIsDelete(byte isDelete) {
    this.isDelete = isDelete;
  }

  public String getMainImageUrl() {
    return this.mainImageUrl;
  }

  public void setMainImageUrl(String mainImageUrl) {
    this.mainImageUrl = mainImageUrl;
  }

  public String getMeterial() {
    return this.meterial;
  }

  public void setMeterial(String meterial) {
    this.meterial = meterial;
  }

  public int getNewPrice() {
    return this.newPrice;
  }

  public void setNewPrice(int newPrice) {
    this.newPrice = newPrice;
  }

  public int getOldPrice() {
    return this.oldPrice;
  }

  public void setOldPrice(int oldPrice) {
    this.oldPrice = oldPrice;
  }

  public String getOrigin() {
    return this.origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getPattern() {
    return this.pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public String getProductName() {
    return this.productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public List<Option> getOptions() {
    return this.options;
  }

  public void setOptions(List<Option> options) {
    this.options = options;
  }

  public Option addOption(Option option) {
    getOptions().add(option);
    option.setProduct(this);

    return option;
  }

  public Option removeOption(Option option) {
    getOptions().remove(option);
    option.setProduct(null);

    return option;
  }

  public List<ProductImage> getProductimages() {
    return this.productimages;
  }

  public void setProductimages(List<ProductImage> productimages) {
    this.productimages = productimages;
  }

  public ProductImage addProductimage(ProductImage productimage) {
    getProductimages().add(productimage);
    productimage.setProduct(this);

    return productimage;
  }

  public ProductImage removeProductimage(ProductImage productimage) {
    getProductimages().remove(productimage);
    productimage.setProduct(null);

    return productimage;
  }

  public Category getCategory() {
    return this.category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public ProductType getProducttype() {
    return this.producttype;
  }

  public void setProducttype(ProductType producttype) {
    this.producttype = producttype;
  }

}