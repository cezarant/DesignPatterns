package com.example.cezar.proxy;

import android.util.Log;

/**
 * Created by Cezar on 29/02/2016.
 */
public class PessoaDAO{
    public static Pessoa getPessoaByID(int id)
    {
        Log.d("PROXY","select * from PESSOA where id="+ id);
        return new PessoaImpl(id," Pessoa " + id);
    }
}
