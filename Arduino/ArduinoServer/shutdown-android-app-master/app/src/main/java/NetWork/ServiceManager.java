package NetWork;

import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by 412001 on 30/12/2015.
 */
public class ServiceManager extends ContextWrapper
{
    public ServiceManager(Context base) {
        super(base);
    }
    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }catch(Exception exc){
            String s = ""+ exc.getMessage();
        }
        return false;
    }
}

