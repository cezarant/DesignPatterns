package View;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.KeyEvent;

import com.example.cezar.myapplication.Desligar.OnErrorListener;

/**
 * Created by Cezar on 25/01/2016.
 */
public class DesligarActivity extends Activity implements OnErrorListener, DialogInterface.OnKeyListener {
    @Override
    public void onError(String msg) {

    }

    @Override
    public void onError(Exception exc) {

    }

    @Override
    public void onNotRoot() {

    }

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        return false;
    }
}
