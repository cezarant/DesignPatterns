package com.example.cezar.decorator;

/**
 * Created by Cezar on 16/02/2016.
 */
public class Leite extends Condimento {
    private Bebida bebida;

    public Leite(Bebida vo_Bebida){
        bebida = vo_Bebida;
    }

    @Override
    public String getDescricao(){
        return bebida.get_descricao() + " + Leite ";
    }

    @Override
    public double getCusto(){
        return bebida.getCusto() + 0.50;
    }
}
