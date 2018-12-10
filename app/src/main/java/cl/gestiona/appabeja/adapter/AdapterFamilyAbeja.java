package cl.gestiona.appabeja.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cl.gestiona.appabeja.DetalleAbejaActivity;
import cl.gestiona.appabeja.DetalleFamiliaActivity;
import cl.gestiona.appabeja.HomeActivity;
import cl.gestiona.appabeja.R;
import cl.gestiona.appabeja.model.FamiliaAbeja;
import cl.gestiona.appabeja.model.ItemAbeja;

/**
 * Created by roman on 12-07-18.
 */

public class AdapterFamilyAbeja extends RecyclerView.Adapter<AdapterFamilyAbeja.ItemViewHolder> {

    private List<ItemAbeja> list;
    private int resource;
    private Activity activity;
    private ItemAbeja item;

    public AdapterFamilyAbeja(List<ItemAbeja> list, int resource, Activity activity) {
        this.list = list;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        item = list.get(position);
        holder.title.setText(item.nombre);
        holder.description.setText(activity.getResources().getString(item.descripcion).substring(0,36)+"...");
        holder.img.setImageResource(item.foto);
        BitmapDrawable drawable = (BitmapDrawable) holder.img.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
       RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(activity.getResources(), createSquaredBitmap(bitmap));

        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(bitmap.getHeight());


        holder.img.setImageDrawable(roundedDrawable);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView img;
        public TextView description;

        public ItemViewHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_list_title);
            img = (ImageView) itemView.findViewById(R.id.item_list_perfil);
            description = (TextView) itemView.findViewById(R.id.item_list_description);


            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DetalleAbejaActivity.progressDialog.show();
                    //Toast.makeText(activity, title.getText().toString(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(activity, DetalleFamiliaActivity.class);
                    i.putExtra("NAME", title.getText().toString());
                    activity.startActivity(i);
                }
            });

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(itemView, "Pinche en el título de la familia", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            /*img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "pincha en el titulo de la abeja :)",Toast.LENGTH_SHORT).show();
                }
            });
    */

        }







    }

    private static Bitmap createSquaredBitmap(Bitmap srcBmp) {
        int dim = Math.max(srcBmp.getWidth(), srcBmp.getHeight());
        Bitmap dstBmp = Bitmap.createBitmap(dim, dim, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(dstBmp);
        canvas.drawColor(Color.DKGRAY);
        canvas.drawBitmap(srcBmp, (dim - srcBmp.getWidth()) / 2, (dim - srcBmp.getHeight()) / 2, null);

        return dstBmp;
    }






}
