package com.drpicox.ddd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


public class Shop {

    private int name;
    private ArrayList<Product> products = new ArrayList<Product>();

    public boolean addProduct(Product p){
        products.add(p);
        return true;
    }

    public boolean buyProduct(String id){
        var product = this.getProduct(id);
        if(product != null){
            if(product.getStock() > 0){
                product.decrementStock();
                return true;
            }
        }
        return false;
    }

    public boolean requestStock(String id){
        var product = this.getProduct(id);
        if (product != null){
            product.incrementStock();
            return true;
        }
        return false;
    }

    private Product getProduct(String id){
        for (Product p: products) {
           if(p.getId() == id) return p;
        }
        return null;
    }
}
