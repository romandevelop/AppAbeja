package cl.gestiona.appabeja;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cl.gestiona.appabeja.model.Abeja;

/**
 * Created by roman on 09-11-17.
 */

public class AdaptadorFamiliaAbeja extends ArrayAdapter<Abeja> {

    public AdaptadorFamiliaAbeja(Context context, List<Abeja> abejaList){
        super(context, 0, abejaList);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return convertView;
    }
}
