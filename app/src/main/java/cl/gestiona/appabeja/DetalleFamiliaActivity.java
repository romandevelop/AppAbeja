package cl.gestiona.appabeja;

import android.content.ClipData;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cl.gestiona.appabeja.model.FamiliaAbeja;
import cl.gestiona.appabeja.model.ItemAbeja;

public class DetalleFamiliaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_familia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String name = getIntent().getStringExtra("NAME");
        setTitle(name);

        ImageView imageView = (ImageView) findViewById(R.id.detalle_fa_img);
        TextView textView = (TextView) findViewById(R.id.detalle_fa_content);

        ItemAbeja itemAbeja = searchFamiliaAbeja(name);
        imageView.setImageResource(itemAbeja.foto);
        textView.setText(itemAbeja.descripcion);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_fa);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public ItemAbeja searchFamiliaAbeja(String nombre){
        for (FamiliaAbeja a: FamiliaAbeja.familiaList()) {
            for(ItemAbeja item : a.items){
                if (getResources().getString(item.nombre).equals(nombre)) {
                    return item;
                }
            }
        }
        return null;
    }
}
