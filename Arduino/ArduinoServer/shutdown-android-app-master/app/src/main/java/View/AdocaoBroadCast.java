package View;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;

import com.example.cezar.myapplication.Bussiness.Chato;
import com.example.cezar.myapplication.Bussiness.Mensagem;
import com.example.cezar.myapplication.Desligar.ShutdownThread;
import com.example.cezar.myapplication.NetWork.Downloader;
import com.example.cezar.myapplication.NetWork.MyAsyncTask;
import com.example.cezar.myapplication.NetWork.ServiceManager;
import com.example.cezar.myapplication.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import io.realm.Realm;

/**
 * Created by Cezar on 03/01/2016.
 */
public class AdocaoBroadCast extends BroadcastReceiver
{
    static final String TAG = AdocaoBroadCast.class.getSimpleName();
    private int IdUltimoArquivo()
    {
        String path = Environment.getExternalStorageDirectory().toString();
        File fl_Placar = new File(path, "adote.txt");
        int placar = 0;
        if (fl_Placar.exists())
        {
            try{
                String vs_Placar = lerArquivo("adote.txt");
                placar = Integer.parseInt(vs_Placar.replace("\n", ""));
            } catch (Exception exc){ }
        }
        return placar;
    }
    public static String lerArquivo(String vs_Arquivo) throws FileNotFoundException
    {
        StringBuilder text = new StringBuilder();
        String line = "";
        try {
            File arq = new File(Environment.getExternalStorageDirectory().toString(), vs_Arquivo);
            BufferedReader br = new BufferedReader(new FileReader(arq));
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        } catch (IOException exc) {
        }
        return text.toString();
    }

    public static void gravarArquivo(String vs_Bolinhas) throws FileNotFoundException
    {
        FileOutputStream fos;
        File arq = new File(Environment.getExternalStorageDirectory(), "adote.txt");
        byte[] vetBytes = vs_Bolinhas.getBytes();
        fos = new FileOutputStream(arq);
        try {
            fos.write(vetBytes);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static final int NOTIFICATION_ID = 1;
    private Chato vo_chato = null;
    private Bundle bundle = null;
    private NotificationCompat.Builder builder;
    private Context contextoAplicacao = null;
    @Override
    public void onReceive(Context context, Intent intent)
    {
        builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.jaobobo);
        bundle = intent.getExtras();
        contextoAplicacao = context;
        ServiceManager serviceManager = new ServiceManager(context);
        if (bundle != null && bundle.containsKey("chato"))
        {
            vo_chato = (Chato) bundle.getSerializable("chato");
            // Se existe internet.
            if (serviceManager.isNetworkAvailable())
            {
                MyAsyncTask asyncTask = new MyAsyncTask(new Downloader.AsyncResponse() {
                    @Override
                    public void processFinish(Object output)
                    {
                        criaNotificacao("");
                        if (!mensagemJaBuscada(contextoAplicacao,
                                Integer.parseInt(output.toString().split(";")[0])))
                            criaNotificacao("");
                    }
                });
                asyncTask.execute(vo_chato.get_webSite());
            }
        }
    }
    private void shutdown() {
        new ShutdownThread().start();
    }
    private static boolean mensagemJaBuscada(Context contexto,int numero)
    {
        boolean vbResultado = false;
        Realm realm = Realm.getInstance(contexto);
        Mensagem mensagem = realm.where(Mensagem.class).equalTo("name", "" + numero).findFirst();
        if(mensagem != null)
        {
            vbResultado = true;
        }else{
            mensagem = new Mensagem();
            mensagem.setName(""+numero);
            // Persist your data easily
            realm.beginTransaction();
            realm.copyToRealm(mensagem);
            realm.commitTransaction();
            vbResultado = false;
        }
        realm.close();
        return vbResultado;
    }
    private void criaNotificacao(String vs_Mensagem)
    {
        if (bundle != null && bundle.containsKey("chato"))
        {
            vo_chato = (Chato) bundle.getSerializable("chato");
            Intent intent1 = new Intent(contextoAplicacao, DesligarActivity.class);
            shutdown();
            //DesligarActivity.this.startActivity(intent1);
            /*PendingIntent pendingIntent = PendingIntent.getActivity(contextoAplicacao, 0, intent1, 0);
            pendingIntent.cancel();

            if(!vs_Mensagem.equals(""))
                vo_chato.set_FrasePadrao(vs_Mensagem);

            intent1 = new Intent(contextoAplicacao, VisualizacaoPrincipal.class);
            intent1.putExtra("chato",vo_chato );
            pendingIntent = PendingIntent.getActivity(contextoAplicacao, 0, intent1, 0);

            intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            builder.setContentIntent(pendingIntent);
            builder.setLargeIcon(BitmapFactory.decodeResource(contextoAplicacao.getResources(),
                   vo_chato.get_imagemInicial()));

            builder.setContentTitle(vo_chato.get_nome() + " chamando");
            builder.setContentText("Atenção pro " + vo_chato.get_nome() + "!!");*/
        }
        //NotificationManager notificationManager = (NotificationManager)
                //contextoAplicacao.getSystemService(Context.NOTIFICATION_SERVICE);
        //notificationManager.notify(1, builder.build());
    }
}

