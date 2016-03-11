package com.example.cezar.factory.Factory;

import com.example.cezar.factory.Pizzas.Pizza;

/**
 * Created by Cezar on 22/02/2016.
 */
public abstract class SimplePizzaFactory
{
    public abstract Pizza createPizza(String type);
}
