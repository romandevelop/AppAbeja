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
        LayoutInflater inflater;
        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.card_abeja, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_abeja);
        TextView txt1 = (TextView) convertView.findViewById(R.id.name_abeja);
        TextView txt2 = (TextView) convertView.findViewById(R.id.description_abeja);

        Abeja abeja = getItem(position);
        imageView.setImageResource(abeja.foto);
        txt1.setText(abeja.nombre);
        txt2.setText(abeja.descricion);
        return convertView;
    }
}
