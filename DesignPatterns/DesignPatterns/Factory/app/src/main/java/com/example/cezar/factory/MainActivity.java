package com.example.cezar.factory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cezar.factory.Factory.BHPizzaFactory;
import com.example.cezar.factory.Factory.SaoPauloPizzaFactory;
import com.example.cezar.factory.Lojas.BHPizzaStore;
import com.example.cezar.factory.Lojas.PizzaStore;
import com.example.cezar.factory.Lojas.SaoPauloPizzaStore;
import com.example.cezar.factory.Pizzas.Pizza;

public class MainActivity extends Activity
{
    private Pizza pizzaPedida;
    private TextView txtPizza;
    private PizzaStore loja;
    private StringBuilder vs_Retorno;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        vs_Retorno = new StringBuilder();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void mostraNaTela(TextView txtDestino)
    {
        vs_Retorno.delete(0,vs_Retorno.length());
        vs_Retorno.append(pizzaPedida.getName());
        vs_Retorno.append("Quantidade de queijos:" + pizzaPedida.getFatiasQueijo());
        txtDestino.setText(vs_Retorno.toString());
    }
    public void criaPizzas(View view)
    {
        // Cria pizza com características de BH
        // ----------------------------------------------------------------
        loja = new  BHPizzaStore(new BHPizzaFactory());
        pizzaPedida = loja.orderPizza("queijo");
        // ----------------------------------------------------------------
        mostraNaTela((TextView) findViewById(R.id.txtPizzaBH));
        // Cria pizza com características de São Paulo
        // ----------------------------------------------------------------
        loja = new SaoPauloPizzaStore(new SaoPauloPizzaFactory());
        pizzaPedida = loja.orderPizza("queijo");
        // ----------------------------------------------------------------
        mostraNaTela((TextView) findViewById(R.id.txtPizzaSaoPaulo));
    }
}
