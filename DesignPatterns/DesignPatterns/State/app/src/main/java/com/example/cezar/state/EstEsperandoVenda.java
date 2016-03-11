package com.example.cezar.state;

/**
 * Created by Cezar on 27/02/2016.
 */
public class EstEsperandoVenda implements State
{

    @Override
    public String inserirMoeda()
    {
        return "Insira moeda";
    }

    @Override
    public String ejetarMoeda(){
        return "*";
    }

    @Override
    public String virarAlavanca() {
        return "*";
    }

    @Override
    public String dispensar() {
        return "*";
    }
}
