package com.drpicox.ddd;

public class Tshirt implements Product {


    protected String id;
    protected String name;
    protected double price;
    protected int stock;


    public Tshirt(String id, String name, double price, int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId(){
        return this.id;
    }

    public int getStock(){
        return this.stock;
    }

    public void decrementStock(){
        this.stock--;
    }

    public void incrementStock(){
        this.stock = 10;
    }

}
