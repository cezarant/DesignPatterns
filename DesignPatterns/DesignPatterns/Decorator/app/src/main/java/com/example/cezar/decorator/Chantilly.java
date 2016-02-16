package com.example.cezar.decorator;

/**
 * Created by Cezar on 16/02/2016.
 */
public class Chantilly extends  Condimento
{
    public Bebida bebida;

    public Chantilly(Bebida vo_Bebida)
    {
       bebida = vo_Bebida;
    }
    @Override
    public String getDescricao(){
        return bebida.get_descricao() + " + Chantilly";
    }

    @Override
    public double getCusto() {
        return bebida.getCusto() + 0.80;
    }
}
