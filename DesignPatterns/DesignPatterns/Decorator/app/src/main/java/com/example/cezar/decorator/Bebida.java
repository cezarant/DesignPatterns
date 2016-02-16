package com.example.cezar.decorator;

/**
 * Created by Cezar on 16/02/2016.
 */
public abstract  class Bebida {
    private String _descricao;

    public String get_descricao() {
        return _descricao;
    }
    public abstract double getCusto();

    public void set_descricao(String _descricao) {
        this._descricao = _descricao;
    }
}
