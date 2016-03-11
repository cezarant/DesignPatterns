package com.example.cezar.factory.Lojas;

import com.example.cezar.factory.Factory.SimplePizzaFactory;
import com.example.cezar.factory.Pizzas.Pizza;

/**
 * Created by Cezar on 21/02/2016.
 */
public class PizzaStore
{
    SimplePizzaFactory factory;
    public PizzaStore(SimplePizzaFactory aFactory)
    {
        this.factory = aFactory;
    }
    public Pizza orderPizza(String type)
    {
       Pizza pizza;
       pizza = factory.createPizza(type);
       pizza.bake();
       pizza.box();
       pizza.cut();
       pizza.prepare();
       return pizza;
    }
}
