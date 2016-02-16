package com.example.cezar.decorator;

/**
 * Created by Cezar on 16/02/2016.
 */
public class CafeComum extends Bebida
{
    public CafeComum()
    {
       set_descricao("Café comum");
    }

    @Override
    public double getCusto()
    {
        return 1.99;
    }
}
