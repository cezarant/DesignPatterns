package com.example.cezar.factory.Pizzas;

import com.example.cezar.factory.Ingredientes.PizzaIngredientFactory;

/**
 * Created by Cezar on 22/02/2016.
 */
public class BHPizzaQueijo extends Pizza
{
    PizzaIngredientFactory fabricaDeIngredientes;
    public BHPizzaQueijo(PizzaIngredientFactory aFabricaDeIngredientes)
    {
        this.fabricaDeIngredientes = aFabricaDeIngredientes;
    }

    @Override
    public void prepare()
    {
       this.setName(" Pizza de queijo com jeitinho mineirim...");
       this.setFatiasQueijo(fabricaDeIngredientes.criaQueijo().get_vi_QtdFatias());
    }
}
