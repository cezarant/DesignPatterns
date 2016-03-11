package com.example.cezar.state;

/**
 * Created by Cezar on 27/02/2016.
 */
public class EstVendaRealizada implements State
{
    @Override
    public String inserirMoeda()
    {
        return "Moeda recebida";
    }
    @Override
    public String ejetarMoeda() {
        return "*";
    }

    @Override
    public String virarAlavanca() {
        return "Vire a alavanca";
    }

    @Override
    public String dispensar() {
        return "*";
    }
}
