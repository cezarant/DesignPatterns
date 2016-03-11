package com.example.cezar.proxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<Pessoa> pessoas;
    private TextView txtPessoa1;
    private TextView txtPessoa2;
    private TextView txtPessoa3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        pessoas = new ArrayList<Pessoa>();
        txtPessoa1 = (TextView) findViewById(R.id.textView);
        txtPessoa2 = (TextView) findViewById(R.id.textView2);
        txtPessoa3 = (TextView) findViewById(R.id.textView3);
    }
    public void executaProxy(View view)
    {
        pessoas.add(new ProxyPessoa(1));
        pessoas.add(new ProxyPessoa(2));
        pessoas.add(new ProxyPessoa(3));
        txtPessoa1.setText("Nome: " + pessoas.get(0).getNome());
        txtPessoa2.setText("Nome: " + pessoas.get(1).getNome());
        txtPessoa3.setText("Nome: " + pessoas.get(0).getNome());
    }
}
