package com.ou.unitest.lab2;

import java.util.*;

public class ShoppingCart {
    private final List<LineItem> items = new ArrayList<>();

    public void addItem(Product product, int quanlity) {
        if(product == null || quanlity <= 0) {
            throw new IllegalArgumentException("Product and quantity must be positity");
        }
        items.add(new LineItem(product, quanlity));
    }

    public double calculateTotal(Discount discount) {
        double subtotal = 0;
        for(LineItem line : items) {
            subtotal += line.getProduct().getPrice() * line.getQuanlity();
        }

        if(discount != null) {
            subtotal = subtotal * (100 - discount.getPercentage()) / 100;
        }

        return Math.round(subtotal * 100.0) / 100.0;
    }

    private static class LineItem {
        private final Product product;
        private final int quantity;

        LineItem(Product product, int quanlity) {
            this.product = product;
            this.quantity = quanlity;
        }

        Product getProduct() {
            return product;
        }

        int getQuanlity() {
            return quantity;
        }
        
    }
}
