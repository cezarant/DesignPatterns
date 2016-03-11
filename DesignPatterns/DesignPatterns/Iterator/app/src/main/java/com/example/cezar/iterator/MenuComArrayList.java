package com.example.cezar.iterator;

import java.util.ArrayList;

/**
 * Created by Cezar on 26/02/2016.
 */
public class MenuComArrayList implements Iterator
{
    private ArrayList<MenuItem> arItens;
    int posicao = 0;
    public MenuComArrayList()
    {
        arItens = new ArrayList<MenuItem>();
        arItens.add(new MenuItem("Item 1","Item 1",2.50));
        arItens.add(new MenuItem("Item 2","Item 1",3.50));
    }
    @Override
    public boolean hasNext()
    {
        if(posicao >= arItens.size())
            return false;
        else
            return true;
    }
    @Override
    public Object next()
    {
        MenuItem menuItem = arItens.get(posicao);
        posicao = posicao + 1;
        return menuItem;
    }
}
