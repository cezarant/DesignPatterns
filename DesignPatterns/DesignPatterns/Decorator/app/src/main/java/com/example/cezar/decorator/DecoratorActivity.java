package com.example.cezar.decorator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by Cezar on 16/02/2016.
 */
public class DecoratorActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decorator);

        final Button btnCafe = (Button) findViewById(R.id.btnCafe);
        final Button btnChantilly = (Button) findViewById(R.id.btnCafeChantilly);
        final Button btnCafeLeite = (Button) findViewById(R.id.btnCafeLeite);

        btnCafe.setOnClickListener(new cafeComum());
        btnChantilly.setOnClickListener(new cafeComChantilly());
        btnCafeLeite.setOnClickListener(new cafeComLeite());
    }
    class cafeComChantilly implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Bebida vo_Bebida = new CafeComum();
            vo_Bebida = new Chantilly(vo_Bebida);
            vo_Bebida = new Chantilly(vo_Bebida);
            final TextView txtResultado = (TextView) findViewById(R.id.txtValorFinal);
            txtResultado.setText("Valor:" + vo_Bebida.getCusto());
        }
    }
    class cafeComLeite implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Bebida vo_Bebida = new CafeComum();
            vo_Bebida = new Leite(vo_Bebida);
            vo_Bebida = new Leite(vo_Bebida);
            final TextView txtResultado = (TextView) findViewById(R.id.txtValorFinal);
            txtResultado.setText("Valor:" + vo_Bebida.getCusto());
        }
    }
    class cafeComum implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Bebida vo_Bebida = new CafeComum();
            final TextView txtResultado = (TextView) findViewById(R.id.txtValorFinal);
            txtResultado.setText("Valor:" + vo_Bebida.getCusto());
        }
    }
}
