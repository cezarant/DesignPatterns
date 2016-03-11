package com.example.cezar.factory.Factory;
import com.example.cezar.factory.Ingredientes.SaoPauloIngredientFactory;
import com.example.cezar.factory.Pizzas.Pizza;
import com.example.cezar.factory.Pizzas.SaoPauloPizzaQueijo;
import com.example.cezar.factory.Pizzas.SaoPauloPizzaVegetariana;
/**
 * Created by Cezar on 22/02/2016.
 */
public class SaoPauloPizzaFactory extends SimplePizzaFactory
{
    @Override
    public Pizza createPizza(String type) {
        Pizza vo_Pizza = null;
        if(type.equals("queijo"))
            vo_Pizza = new SaoPauloPizzaQueijo(new SaoPauloIngredientFactory());

        if(type.equals("Vegetariano"))
            vo_Pizza = new SaoPauloPizzaVegetariana();

        return vo_Pizza;
    }
}
