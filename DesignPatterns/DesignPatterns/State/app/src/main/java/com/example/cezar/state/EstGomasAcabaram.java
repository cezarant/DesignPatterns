package com.example.cezar.state;

/**
 * Created by Cezar on 27/02/2016.
 */
public class EstGomasAcabaram implements State {

    @Override
    public String inserirMoeda()
    {
        return "Acabaram as gomas, imbecil..";
    }
    @Override
    public String ejetarMoeda() {
        return "Retire sua moeda";
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
