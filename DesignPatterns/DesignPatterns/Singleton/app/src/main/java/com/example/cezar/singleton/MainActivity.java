package com.example.cezar.singleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView txtCaldeira;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ligaCaldeira(View view)
    {
        CaldeiraSingleTon vo_caldeira = CaldeiraSingleTon.buscaCaldeira();
        txtCaldeira = (TextView)findViewById(R.id.txtLigarCaldeira);
        txtCaldeira.setText(" Botão acionado em:"+ CaldeiraSingleTon.buscaHoraFormatada() +
                            " Caldeira ligada com sucesso em:"+ vo_caldeira.getHoraLigacaoCaldeira());
    }
}
