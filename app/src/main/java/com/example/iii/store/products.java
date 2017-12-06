package com.example.iii.store;

/**
 * Created by iii on 2017/11/30.
 */

public class products {

    private String name;
    private int price;

    public products(String name,int price){
        this.name = name;
        this.price = price;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(int price){
        this.price=price;
    }

    public int getPrice() {
        return price;
    }
}
