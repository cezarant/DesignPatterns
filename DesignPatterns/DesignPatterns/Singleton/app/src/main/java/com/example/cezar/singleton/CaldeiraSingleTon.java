package com.example.cezar.singleton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Cezar on 24/02/2016.
 */
public class CaldeiraSingleTon
{
    public static CaldeiraSingleTon caldeiraUnica;
    private String horaLigacaoCaldeira;

    public static String buscaHoraFormatada()
    {
        // Coloca a hora da ligação da caldeira
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date hora = Calendar.getInstance().getTime();
        return sdf.format(hora);
    }
    public CaldeiraSingleTon()
    {
        this.setHoraLigacaoCaldeira(buscaHoraFormatada());
    }
    public static CaldeiraSingleTon buscaCaldeira()
    {
        if (caldeiraUnica == null) {
            caldeiraUnica = new CaldeiraSingleTon();
        }
        return caldeiraUnica;
    }

    public String getHoraLigacaoCaldeira() {
        return horaLigacaoCaldeira;
    }

    public void setHoraLigacaoCaldeira(String horaLigacaoCaldeira) {
        this.horaLigacaoCaldeira = horaLigacaoCaldeira;
    }
}
