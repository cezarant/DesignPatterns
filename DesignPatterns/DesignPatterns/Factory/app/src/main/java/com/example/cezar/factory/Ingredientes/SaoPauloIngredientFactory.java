package com.example.cezar.factory.Ingredientes;

/**
 * Created by Cezar on 22/02/2016.
 */
public class SaoPauloIngredientFactory implements PizzaIngredientFactory
{
    @Override
    public queijo criaQueijo() {
        queijo vo_Queiro = new queijo();
        vo_Queiro.setVs_NomeQueijo("Queijo de São Paulo");
        vo_Queiro.set_vi_QtdFatias(1);
        return vo_Queiro;
    }
}
