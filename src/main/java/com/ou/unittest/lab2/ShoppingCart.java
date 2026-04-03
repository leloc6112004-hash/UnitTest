package com.ou.unittest.lab2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    //private final List<>
    private final List<LineItem> items=new ArrayList<>();

    public void addItem(Product product, int quantity)
    {
        if(product==null || quantity <=0)
        {
            throw new IllegalArgumentException("Product and quantity must be positity");
        }
        items.add(new LineItem(product, quantity));
    }

    public double CalculateTotal(Discount discount)
    {
        double subtotal=0;
        for(LineItem line: items){
            subtotal+=line.getProduct().getPrice()*line.getQuantity(); 
        }
        if(discount!=null)
        {
            subtotal=subtotal*(100-discount.getPercentage()) / 100;
        }

        return Math.round(subtotal*100.0)/100.0;
    }

    private static class LineItem {
        private final Product product;
        private final int quantity;

        LineItem(Product product, int quantity)
        {
            this.product=product;
            this.quantity=quantity;
        }

        Product getProduct()
        {
            return product;
        }

        int getQuantity()
        {
            return quantity;
        }
    }

}
