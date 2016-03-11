package com.example.cezar.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtPatoComum;
    private TextView txtPatoMeiaBoca;
    private Pato vo_Pato;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void patoComum(View view)
    {
        vo_Pato = new PatoComum();
        txtPatoComum = (TextView) findViewById(R.id.txtPatoComum);
        txtPatoComum.setText(vo_Pato.fazerBarulho());
    }
    public void patoMeiaBoca(View view)
    {
        vo_Pato = new AdaptadorPeruTentandoSerPato(new PeruQualquer());
        txtPatoMeiaBoca = (TextView) findViewById(R.id.txtMeiaBoca);
        txtPatoMeiaBoca.setText(vo_Pato.fazerBarulho());
    }
}
