package com.example.cezar.adapter;

/**
 * Created by Cezar on 26/02/2016.
 */
public class AdaptadorPeruTentandoSerPato implements Pato  {
    Peru vo_Peru;

    public AdaptadorPeruTentandoSerPato(Peru aPeru)
    {
       this.vo_Peru = aPeru;
    }

    @Override
    public String fazerBarulho(){
        return vo_Peru.gorgolejar();
    }

    @Override
    public String voar(){
        StringBuilder vs_ResultadoVoo = new StringBuilder();
        for (int i = 0;i< 3;i++)
           vs_ResultadoVoo.append(vo_Peru.voar());

        return vs_ResultadoVoo.toString();
    }
}
