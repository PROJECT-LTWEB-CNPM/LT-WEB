package services;

import java.util.Comparator;

import models.Product;

public class CompareProduct {

  public CompareProduct() {

  }

  static final Comparator<Product> LOWEST_PRICE = new Comparator<Product>() {

    @Override
    public int compare(Product p1, Product p2) {
      if (p1.getNewPrice() > p2.getNewPrice()) {
        return 1;
      } else if (p1.getNewPrice() < p2.getNewPrice()) {
        return -1;
      } else {
        return 0;
      }
    }

  };

  static final Comparator<Product> HIGHEST_PRICE = new Comparator<Product>() {

    @Override
    public int compare(Product p1, Product p2) {
      if (p1.getNewPrice() < p2.getNewPrice()) {
        return 1;
      } else if (p1.getNewPrice() > p2.getNewPrice()) {
        return -1;
      } else {
        return 0;
      }
    }

  };

}
