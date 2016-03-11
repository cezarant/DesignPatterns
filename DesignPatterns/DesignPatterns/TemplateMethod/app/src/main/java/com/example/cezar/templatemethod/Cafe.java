package com.example.cezar.templatemethod;

/**
 * Created by Cezar on 26/02/2016.
 */
public class Cafe extends bebidaCafeinada {
    @Override
    String fazerInfusao(){
        return "Colocando o pó do café...";
    }

    @Override
    String acrescentarCondimentos(){
        return "Colocando leite e açucar...";
    }
}
