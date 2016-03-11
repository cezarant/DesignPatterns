package com.example.cezar.iterator;

/**
 * Created by Cezar on 26/02/2016.
 */
public class MenuItem
{
    private String name;
    private String descricao;
    private double preco;

    public MenuItem(String name, String descricao, double preco)
    {
        this.name = name;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
