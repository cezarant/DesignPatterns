package com.example.cezar.state;

/**
 * Created by Cezar on 27/02/2016.
 */
public class EstAlavancaLiberada implements State
{
    @Override
    public String inserirMoeda() {
        return "*";
    }

    @Override
    public String ejetarMoeda() {
        return "*";
    }

    @Override
    public String virarAlavanca() {
        return "*";
    }

    @Override
    public String dispensar() {
        return "Retire sua balinha..";
    }
}
