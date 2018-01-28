package cl.gestiona.appabeja;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cl.gestiona.appabeja.model.Abeja;

public class DetalleAbejaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_abeja);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String name = getIntent().getStringExtra("NAME");
        setTitle(name);
        Abeja abeja = searchAbeja(name);

        TextView txt = (TextView) findViewById(R.id.detalle_content);
        ImageView img = (ImageView) findViewById(R.id.detalle_img);

        txt.setText(getString(abeja.descricion));
        img.setImageResource(abeja.foto);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    public Abeja searchAbeja(String nombre){
        for (Abeja a: Abeja.familiaList()) {
            if (getString(a.nombre).equals(nombre)){
                return a;
            }
        }
        return null;
    }


}
