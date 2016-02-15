package NetWork;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by 412001 on 30/12/2015.
 */
public class MyAsyncTask extends AsyncTask<Object, Object, Object>
{
    public Downloader.AsyncResponse delegate = null;//Call back interface
    private Object result;
    public MyAsyncTask(Downloader.AsyncResponse asyncResponse)
    {
        delegate = asyncResponse;//Assigning call back interfacethrough constructor
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
            vs_Mensagem = vs_Text.toString();
        }catch (Exception exc){}
        return vs_Mensagem;
    }
    @Override
    protected Object doInBackground(Object... params)
    {
        Object vs_MensagemRetorno = null;
        try {
            vs_MensagemRetorno = downloadBitmap(params[0].toString());
        }catch (Exception exc){
        }
        return vs_MensagemRetorno;
    }
    @Override
    protected void onPostExecute(Object result)
    {
        delegate.processFinish(result);
    }
}
