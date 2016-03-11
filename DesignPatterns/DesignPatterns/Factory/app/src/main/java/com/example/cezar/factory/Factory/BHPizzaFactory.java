package com.example.cezar.factory.Factory;

import com.example.cezar.factory.Ingredientes.BeloHorizonteIngredientFactory;
import com.example.cezar.factory.Pizzas.Pizza;
import com.example.cezar.factory.Pizzas.BHPizzaQueijo;
import com.example.cezar.factory.Pizzas.BHPizzaVegetariana;

/**
 * Created by Cezar on 22/02/2016.
 */
public class BHPizzaFactory extends SimplePizzaFactory {
    @Override
    public Pizza createPizza(String type)
    {
            Pizza vo_Pizza = null;
            if(type.equals("queijo"))
                vo_Pizza = new BHPizzaQueijo(new BeloHorizonteIngredientFactory());

            if(type.equals("Vegetariano"))
                vo_Pizza = new BHPizzaVegetariana();

            return vo_Pizza;
    }
}
