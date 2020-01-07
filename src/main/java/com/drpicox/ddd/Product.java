package com.drpicox.ddd;

public interface Product {

    public String getId();

    public int getStock();

    public void decrementStock();

    public void incrementStock();

}
