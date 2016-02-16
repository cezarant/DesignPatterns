package com.example.cezar.decorator;

/**
 * Created by Cezar on 16/02/2016.
 */
public class CafeExpresso extends  Bebida {

    public CafeExpresso()
    {
        set_descricao("Café Expresso");
    }
    @Override
    public double getCusto() {
        return 2.99;
    }
}
