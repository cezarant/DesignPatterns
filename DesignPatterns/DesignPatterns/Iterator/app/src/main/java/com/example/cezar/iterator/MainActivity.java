package com.example.cezar.iterator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity
{
    private MenuComArrayList menuArray;
    private MenuComArrays menuVetor;
    private EditText edtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtResultado = (EditText) findViewById(R.id.editText);
    }
    public void arrayList(View view)
    {
        menuArray = new MenuComArrayList();
        imprimirIterator(menuArray);
    }
    public void vetor(View view)
    {
        menuVetor = new MenuComArrays();
        imprimirIterator(menuVetor);
    }
    private void imprimirIterator(Iterator vIterator)
    {
       edtResultado.setText("");
       MenuItem vMenuItem;
       StringBuilder vs_Resultado = new StringBuilder();
       while (vIterator.hasNext())
       {
            vMenuItem = (MenuItem) vIterator.next();
            vs_Resultado.append(" " + vMenuItem.getName() + " - "+ vMenuItem.getPreco());
       }
       edtResultado.setText(vs_Resultado.toString());
    }
}
