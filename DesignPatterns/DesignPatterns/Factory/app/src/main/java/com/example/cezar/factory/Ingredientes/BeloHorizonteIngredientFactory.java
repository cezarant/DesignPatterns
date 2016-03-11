package com.example.cezar.factory.Ingredientes;

/**
 * Created by Cezar on 22/02/2016.
 */
public class BeloHorizonteIngredientFactory implements PizzaIngredientFactory
{
    @Override
    public queijo criaQueijo() {
        queijo vo_Queijo = new queijo();
        vo_Queijo.setVs_NomeQueijo("Queijo de BH");
        vo_Queijo.set_vi_QtdFatias(2);
        return vo_Queijo;
    }
}
