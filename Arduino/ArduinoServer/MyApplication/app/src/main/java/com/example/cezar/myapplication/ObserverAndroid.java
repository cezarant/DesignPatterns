package com.example.cezar.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cezar on 15/02/2016.
 */
public class ObserverAndroid extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observerandroid);
        final Button button = (Button) findViewById(R.id.btnobserver);
        ArrayList<View.OnClickListener> listeners = new ArrayList<>();
        listeners.add(new ObservadorAnjinho());
        listeners.add(new ObservadorDiabinho());
        ColecaoObservadores colecaoObservadores = new ColecaoObservadores(listeners);
        button.setOnClickListener(colecaoObservadores);
    }

    private class ColecaoObservadores implements View.OnClickListener
    {
        private ArrayList<View.OnClickListener> listeners;

        private ColecaoObservadores(ArrayList<View.OnClickListener> listeners) {
            this.listeners = listeners;
        }

        public void addOnclickListener(View.OnClickListener listener){
            listeners.add(listener);
        }

        @Override
        public void onClick(View v)
        {
            for(View.OnClickListener l : listeners){
                l.onClick(v);
            }

        }
    }
    class ObservadorAnjinho implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            final TextView txtAnjinho = (TextView) findViewById(R.id.txtAnjinho);
            txtAnjinho.setText("Não coma bacon");
        }
    }

    class ObservadorDiabinho implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            final TextView txtMaldoso = (TextView) findViewById(R.id.txtDiabinho);
            txtMaldoso.setText("Coma bacon até o fim dos tempos");
        }
    }
}
