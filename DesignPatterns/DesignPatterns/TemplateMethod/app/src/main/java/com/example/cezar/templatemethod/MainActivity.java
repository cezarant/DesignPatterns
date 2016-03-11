package com.example.cezar.templatemethod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView txtEtapa1;
    private TextView txtEtapa2;
    private TextView txtEtapa3;
    private TextView txtEtapa4;
    private bebidaCafeinada Bebida;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEtapa1 = (TextView)findViewById(R.id.txtEtapa1);
        txtEtapa2 = (TextView)findViewById(R.id.txtEtapa2);
        txtEtapa3 = (TextView)findViewById(R.id.txtEtapa3);
        txtEtapa4 = (TextView)findViewById(R.id.txtEtapa4);
    }
    public void templateCafe(View view)
    {
        mostraResultados(new Cafe());
    }
    private void mostraResultados(bebidaCafeinada vo_Bebida)
    {
        txtEtapa1.setText(vo_Bebida.esquentarAgua());
        txtEtapa2.setText(vo_Bebida.fazerInfusao());
        txtEtapa3.setText(vo_Bebida.despejarBebida());
        txtEtapa4.setText(vo_Bebida.acrescentarCondimentos());
    }
    public void templateCha(View view)
    {
        mostraResultados(new Cha());
    }
}
