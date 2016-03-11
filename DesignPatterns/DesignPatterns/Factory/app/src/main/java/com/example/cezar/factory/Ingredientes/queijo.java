package com.example.cezar.factory.Ingredientes;

/**
 * Created by Cezar on 21/02/2016.
 */
public class queijo
{
    private int _vi_QtdFatias;
    private String vs_NomeQueijo;
    public String getVs_NomeQueijo(){ return vs_NomeQueijo;}
    public void setVs_NomeQueijo(String vs_NomeQueijo) {
        this.vs_NomeQueijo = vs_NomeQueijo;
    }
    public int get_vi_QtdFatias(){return _vi_QtdFatias;}
    public void set_vi_QtdFatias(int _vi_QtdFatias){this._vi_QtdFatias = _vi_QtdFatias;}
}
