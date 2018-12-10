package cl.gestiona.appabeja.adapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cl.gestiona.appabeja.DetalleAbejaActivity;
import cl.gestiona.appabeja.DetalleFamiliaActivity;
import cl.gestiona.appabeja.R;
import cl.gestiona.appabeja.model.ItemAbeja;
import cl.gestiona.appabeja.model.ItemFlower;

/**
 * Created by roman on 29-07-18.
 */

public class AdapterFlower extends RecyclerView.Adapter<AdapterFlower.ItemViewHolder> {

    private List<ItemFlower> list;
    private int resource;
    private Activity activity;
    private ItemFlower item;

    public AdapterFlower(List<ItemFlower> list, int resource, Activity activity) {
        this.list = list;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        item = list.get(position);
        holder.title.setText(item.nombre);
        holder.description.setText(activity.getResources().getString(item.descripcion).substring(0, 36) + "...");
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

    public class ItemViewHolder extends RecyclerView.ViewHolder {

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
                    showDialogDescription(title.getText().toString(), getDescription(title.getText().toString()));
                }
            });

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialogImage(getImage(title.getText().toString()),title.getText().toString());
                }
            });



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

    public void showDialogDescription(String title, String content) {


        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myScrollView = inflater.inflate(R.layout.layout_dialogo, null, false);

        // textViewWithScroll is the name of our TextView on scroll_text.xml
        TextView tv = (TextView) myScrollView.findViewById(R.id.dialog_content);

        // Initializing a blank textview so that we can just append a text later
        tv.setText(content);



        new AlertDialog.Builder(activity).setView(myScrollView)
                .setTitle(title)
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @TargetApi(11)
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }

                }).show();

    }


    public void showDialogImage(int resource, String title) {


        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myScrollView = inflater.inflate(R.layout.layout_dialogo_img, null, false);

        // textViewWithScroll is the name of our TextView on scroll_text.xml
        ImageView tv = (ImageView) myScrollView.findViewById(R.id.dialog_img);

        // Initializing a blank textview so that we can just append a text later
        tv.setImageResource(resource);



        new AlertDialog.Builder(activity).setView(myScrollView)
                .setTitle(title)
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @TargetApi(11)
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }

                }).show();

    }


    public String getDescription(String title){
        for(ItemFlower i : list){
            if (title.equalsIgnoreCase(activity.getResources().getString(i.nombre))){
                return activity.getResources().getString(i.descripcion);
            }
        }
        return "none";
    }

    public int getImage(String title){
        for(ItemFlower i : list){
            if (title.equalsIgnoreCase(activity.getResources().getString(i.nombre))){
                return i.foto;
            }
        }
        return 0;
    }

/* AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle(title.getText().toString());
                    builder.setMessage(description.getText().toString());



                    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });


                    // Create the AlertDialog
                    AlertDialog dialog = builder.create();
                    dialog.getWindow().setLayout(100, 1000);
                    dialog.show();
                    */
}
