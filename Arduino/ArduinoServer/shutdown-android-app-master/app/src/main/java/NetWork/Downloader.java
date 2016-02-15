package NetWork;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by 412001 on 30/12/2015.
 */
public class Downloader  extends AsyncTask
{
    public interface AsyncResponse
    {
        void processFinish(Object output);
    }
    @Override
    protected Object doInBackground(Object[] params) {
        try {
            downloadBitmap(params[0].toString());
        }catch (Exception exc){
        }
        return null;
    }
    @Override
    protected void onPreExecute() {
        Log.i("Async-Example", "onPreExecute Called");
    }
    protected void onPostExecute(String result)
    {
        String teste = "";
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
        } catch (IOException exc){
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

    private String downloadBitmap(String url) throws IOException
    {
        String vs_Mensagem = "";
        try {
            URL urli = new URL(url);
            BufferedReader in = new BufferedReader( new InputStreamReader(urli.openStream()));
            String inputLine;
            StringBuilder vs_Text = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                vs_Text.append(inputLine);
            in.close();
            //if (Integer.parseInt(vs_Text.toString().split(";")[0]) != ultimoArquivo)
            //{
            vs_Mensagem = vs_Text.toString().split(";")[1];
            gravarArquivo(vs_Text.toString().split(";")[0]);
            //}
        }catch (Exception exc){
        }
        return vs_Mensagem;
    }
}



