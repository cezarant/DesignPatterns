package com.example.cezar.templatemethod;

/**
 * Created by Cezar on 26/02/2016.
 */
public class Cha extends bebidaCafeinada
{
    @Override
    String fazerInfusao() {
        return "Colocando saquinho ná agua...";
    }

    @Override
    String acrescentarCondimentos()
    {
        return "Colocando limão...";
    }
}
