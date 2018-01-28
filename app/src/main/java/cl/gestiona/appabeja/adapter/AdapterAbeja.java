package cl.gestiona.appabeja.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.gestiona.appabeja.DetalleAbejaActivity;
import cl.gestiona.appabeja.R;
import cl.gestiona.appabeja.model.Abeja;

/**
 * Created by roman on 28-01-18.
 */
//segundo se crea el extends de la clase contenedora
public class AdapterAbeja  extends RecyclerView.Adapter<AdapterAbeja.AbejaViewHolder>{

    private List<Abeja> list;
    private int resource;
    private Activity activity;

    private Abeja abeja;

    public AdapterAbeja(List<Abeja> list, int resource, Activity activity) {
        this.list = list;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public AbejaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new AbejaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AbejaViewHolder holder, int position) {
        abeja = list.get(position);
        holder.item_card_title.setText(abeja.nombre);
        holder.item_card_img.setImageResource(abeja.foto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //primero se crea el item de la tarjeta
    public class AbejaViewHolder extends RecyclerView.ViewHolder{
        private ImageView item_card_img;
        private TextView item_card_title;

        public AbejaViewHolder(View view){
            super(view);
            item_card_img = (ImageView) view.findViewById(R.id.item_card_img);
            item_card_title = (TextView) view.findViewById(R.id.item_card_title);

            item_card_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(activity,DetalleAbejaActivity.class);
                    i.putExtra("NAME", item_card_title.getText().toString());
                    activity.startActivity(i);
                }
            });

        }


    }

}
