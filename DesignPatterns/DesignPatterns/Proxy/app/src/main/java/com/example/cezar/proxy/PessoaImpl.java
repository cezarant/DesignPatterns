package com.example.cezar.proxy;

import android.util.Log;

/**
 * Created by Cezar on 29/02/2016.
 */
public class PessoaImpl implements Pessoa
{
    private String nome; private int id;
    public PessoaImpl(int id,String nome)
    {
        this.id = id;
        this.nome = nome;
        Log.d("PROXY","Retornou a pessoa do banco de dados -> " + nome);
    }
    public String getNome()
    {
        return nome;
    }
    public int getId()
    {
        return this.id;
    }
}


