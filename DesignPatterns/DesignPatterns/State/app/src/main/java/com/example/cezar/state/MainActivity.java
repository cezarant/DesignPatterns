package com.example.cezar.state;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private int qtdGomas = 3;
    private EstEsperandoVenda espVenda;
    private EstGomasAcabaram moeAcabou;
    private EstVendaRealizada vendRealizada;
    private EstAlavancaLiberada alvVirada;
    private State statusAtual;
    private TextView txtView1;
    private TextView txtView2;
    private TextView txtView3;
    private TextView txtView4;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        inicializaComponentes();
        inicializaMaquinaEstados();
        imprimeStatus(statusAtual);
    }
    private void inicializaMaquinaEstados()
    {
        espVenda = new EstEsperandoVenda();
        moeAcabou = new EstGomasAcabaram();
        vendRealizada = new EstVendaRealizada();
        alvVirada = new EstAlavancaLiberada();
    }
    private void inicializaComponentes()
    {
        txtView1 = (TextView) findViewById(R.id.textView);
        txtView2 = (TextView) findViewById(R.id.textView2);
        txtView3 = (TextView) findViewById(R.id.textView3);
        txtView4 = (TextView) findViewById(R.id.textView4);
    }
    private void imprimeStatus(State statusAImprimir)
    {
        if(statusAImprimir == null)
        {
            txtView1.setText("Máquina em stand by");
            txtView2.setText("");
            txtView3.setText("");
            txtView4.setText("");
        }else{
            txtView1.setText(statusAImprimir.inserirMoeda());
            txtView2.setText(statusAImprimir.ejetarMoeda());
            txtView3.setText(statusAImprimir.virarAlavanca());
            txtView4.setText(statusAImprimir.dispensar());
        }
    }
    public void compraGomas(View view)
    {
        // Se as gomas se acabaram
        if(qtdGomas > 0)
        {
            gerenciaMaquinaDeGoma();
        }else{
            // Gomas acabaram. Avisa ao cliente e devolve a moeda
            statusAtual = moeAcabou;
            imprimeStatus(statusAtual);
        }
    }
    private void gerenciaMaquinaDeGoma()
    {
        if(statusAtual == null)
        {
            // Se a máquina está desligada
            // Coloca para esperar venda
            statusAtual = espVenda;
            imprimeStatus(statusAtual);
        }else{
            // Se a alvanca foi acionada
            // Volta para o status atual
            if(statusAtual == alvVirada)
            {
                statusAtual = null;
                imprimeStatus(statusAtual);
            }
            // Se a venda foi realizada ok
            // Libera a alavanca
            if(statusAtual == vendRealizada)
            {
                statusAtual = alvVirada;
                imprimeStatus(statusAtual);
            }
            // Se a máquina está esperando uma venda
            // Realiza a venda
            if(statusAtual == espVenda)
            {
               statusAtual = vendRealizada;
               imprimeStatus(statusAtual);
               qtdGomas--;
            }
        }
    }
}
