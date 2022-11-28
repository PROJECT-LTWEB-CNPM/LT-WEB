package com.shoplane.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name = "orders")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "order_id")
  private String orderId;

  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  @Column(name = "ordered_quantity")
  private int orderedQuantity;

  private int price;

  // bi-directional many-to-one association to Bill
  @ManyToOne
  @JoinColumn(name = "bill_id")
  private Bill bill;

  // bi-directional many-to-one association to Option
  @ManyToOne
  @JoinColumn(name = "option_id")
  private Option option;

  public Order() {
  }

  public Order(String orderId, Date date, int quanty, int price, Option option) {
    this.orderId = orderId;
    this.date = date;
    this.orderedQuantity = quanty;
    this.option = option;
    this.price = price;
  }

  public String getOrderId() {
    return this.orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getOrderedQuantity() {
    return this.orderedQuantity;
  }

  public void setOrderedQuantity(int orderedQuantity) {
    this.orderedQuantity = orderedQuantity;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Bill getBill() {
    return this.bill;
  }

  public void setBill(Bill bill) {
    this.bill = bill;
  }

  public Option getOption() {
    return this.option;
  }

  public void setOption(Option option) {
    this.option = option;
  }

}