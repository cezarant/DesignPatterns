package com.example.cezar.templatemethod;
/**
 * Created by Cezar on 26/02/2016.
 */
public abstract class bebidaCafeinada
{
    String prepararBebida()
    {
        StringBuilder vs_ResultadoBebida = new StringBuilder();
        vs_ResultadoBebida.append(esquentarAgua());
        vs_ResultadoBebida.append(fazerInfusao());
        vs_ResultadoBebida.append(despejarBebida());
        vs_ResultadoBebida.append(acrescentarCondimentos());
        return vs_ResultadoBebida.toString();
    }
    String esquentarAgua() { return "Esquetando água";}
    String despejarBebida(){ return "Despejando bebida na xícara";}
    abstract String fazerInfusao();
    abstract String acrescentarCondimentos();
}
