package com.example.cezar.iterator;

import android.view.Menu;

/**
 * Created by Cezar on 26/02/2016.
 */
public class MenuComArrays implements Iterator
{
    MenuItem[] itens;
    int posicao = 0;
    public MenuComArrays()
    {
        itens = new MenuItem[2];
        itens[0] = new MenuItem("Item 1","Item 1",6.20);
        itens[1] = new MenuItem("Item 2","Item 2",7.20);
    }
    @Override
    public boolean hasNext()
    {
        if(posicao >= itens.length || itens[posicao] == null)
        {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object next()
    {
        MenuItem menuItem = itens[posicao];
        posicao = posicao + 1;
        return menuItem;
    }
}
