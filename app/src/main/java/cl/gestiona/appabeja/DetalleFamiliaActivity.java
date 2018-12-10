package cl.gestiona.appabeja;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

import cl.gestiona.appabeja.adapter.AdapterFlower;
import cl.gestiona.appabeja.model.FamiliaAbeja;
import cl.gestiona.appabeja.model.ItemAbeja;
import cl.gestiona.appabeja.model.ItemFlower;

public class DetalleFamiliaActivity extends AppCompatActivity {


    private TextToSpeech textToSpeech;
    private int resultTextToSpeech;
    private boolean stateSound=true;
    private FloatingActionButton fab;
    private ItemAbeja itemAbeja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_familia);

        DetalleAbejaActivity.progressDialog.cancel();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String name = getIntent().getStringExtra("NAME");
        setTitle(name);

        ImageView imageView = (ImageView) findViewById(R.id.detalle_fa_img);
        TextView textView = (TextView) findViewById(R.id.detalle_fa_content);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_items_plantas);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);

        itemAbeja = searchFamiliaAbeja(name);


        ArrayList<ItemFlower> listflower = new ArrayList<>();

        for(ItemFlower i:itemAbeja.flowers){
            listflower.add(i);
        }

        recyclerView.setAdapter(new AdapterFlower(listflower, R.layout.item_recycler_list_abeja, this));
        imageView.setImageResource(itemAbeja.foto);
        textView.setText(itemAbeja.descripcion);


       // WebView txtplantas = (WebView) findViewById(R.id.detalle_fa_planta);



       // String content = loadPlants(getResources().getString(itemAbeja.plantas));
       // txtplantas.loadDataWithBaseURL(null,content,"text/html","utf-8",null);








        textToSpeech = new TextToSpeech(DetalleFamiliaActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    resultTextToSpeech = textToSpeech.setLanguage(new Locale("spa","MEX"));

                }else{
                    toast("Sonido no soportado");
                }
            }


        });


        fab = (FloatingActionButton) findViewById(R.id.fab_fa);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stateSound){
                    stateSound=false;
                    offIcon();
                    Log.e("Error", "antes del dialogo");
                    dialogo(getString(itemAbeja.descripcion));
                    Log.e("Error","despues del dialogo");
                }else{
                    stateSound = true;
                    onIcon();
                    textToSpeech.stop();
                }
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(1)
                        .playOn(findViewById(R.id.fab_fa));
            }
        });
    }



    public void onIcon(){
        fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_sound));
    }

    public void offIcon(){

        fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_stop));
    }



    private void dialogo(String dialogo){
        if (textToSpeech!=null){
            textToSpeech.stop();
        }
        if (resultTextToSpeech == TextToSpeech.LANG_MISSING_DATA || resultTextToSpeech==TextToSpeech.LANG_NOT_SUPPORTED){
            toast("no soportado event");
        }else{
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, dialogo);
            textToSpeech.speak(dialogo, TextToSpeech.QUEUE_FLUSH, map);

        }
    }

    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        textToSpeech.stop();
        textToSpeech.shutdown();
        super.onDestroy();

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

    public String loadPlants(String str){
        String [] base = str.split("#");
        StringBuilder data = new StringBuilder();
        data.append("<h4>Plantas Asociadas</h4>\n");
        data.append("<ul>\n");
        for (String item: base) {
            data.append("<li>");
            data.append(item);
            data.append("</li>\n");
        }
        data.append("</ul>\n");
        return data.toString();
    }



}
