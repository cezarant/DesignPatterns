package com.example.cezar.factory.Pizzas;

import java.util.ArrayList;

/**
 * Created by Cezar on 21/02/2016.
 */
public abstract class Pizza
{
    private String name;
    private int fatiasQueijo;
    public abstract void prepare();
    public void bake(){}
    public void cut(){}
    public void box(){}
    public String getName(){return name;}
    public void setName(String name) {
        this.name = name;
    }

    public int getFatiasQueijo() {
        return fatiasQueijo;
    }

    public void setFatiasQueijo(int fatiasQueijo) {
        this.fatiasQueijo = fatiasQueijo;
    }
}
