package View;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cezar.myapplication.R;

/**
 * Created by Cezar on 03/01/2016.
 */
public class CustomListAdapter extends ArrayAdapter<String>
{
    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private int vi_NotasLiberadas;
    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid,
                             int aiNotasLiberadas)
    {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub
        vi_NotasLiberadas = aiNotasLiberadas;
        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
    }
    public View getView(int position, View view, ViewGroup parent)
    {
        View rowView = null;
        LayoutInflater inflater = context.getLayoutInflater();
        rowView = inflater.inflate(R.layout.mylist, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        if ((position % 2) == 0)
        {
            rowView.setBackgroundColor(Color.GRAY);
            txtTitle.setTextColor(Color.WHITE);
        }
        extratxt.setText("Nível de chatisse:Alto");
        return rowView;
    };
}

