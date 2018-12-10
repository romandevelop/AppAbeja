package cl.gestiona.appabeja;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.HashMap;
import java.util.Locale;

import cl.gestiona.appabeja.adapter.AdapterFamilyAbeja;
import cl.gestiona.appabeja.model.FamiliaAbeja;

public class DetalleAbejaActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private int resultTextToSpeech;
    private boolean stateSound=true;
    private FloatingActionButton fab;

    private FamiliaAbeja familiaAbeja;


    public static  ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_abeja);
        HomeActivity.progressDialog.cancel();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgressStyle(0);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        String name = getIntent().getStringExtra("NAME");
        setTitle(name);

        //SpannableStringBuilder str = new SpannableStringBuilder(name);
        //str.setSpan(new android.text.style.StyleSpan(Typeface.ITALIC), 0, name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //getSupportActionBar().setTitle(str);

        //DEFINE TITLE IN COLLAPSED TOOLBAR ITALIC TEXT
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        //collapsingToolbarLayout.setCollapsedTitleTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        //collapsingToolbarLayout.setExpandedTitleTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        //collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK);
        //collapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);

        familiaAbeja = searchAbeja(name);

        TextView txt = (TextView) findViewById(R.id.detalle_content);
        ImageView img = (ImageView) findViewById(R.id.detalle_img);

        txt.setText(getString(familiaAbeja.descricion));
        img.setImageResource(familiaAbeja.foto);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //load RecyclerView
        if (!familiaAbeja.items.isEmpty()) {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_items_familia);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(lm);
            recyclerView.setAdapter(new AdapterFamilyAbeja(familiaAbeja.items, R.layout.item_recycler_list_abeja, this));
        }


        textToSpeech = new TextToSpeech(DetalleAbejaActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    resultTextToSpeech = textToSpeech.setLanguage(new Locale("spa","MEX"));

                }else{
                    toast("Sonido no soportado");
                }
            }


        });






        fab= (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stateSound){
                    stateSound=false;
                    offIcon();
                    dialogo(getString(familiaAbeja.descricion));
                }else{
                    stateSound = true;
                    onIcon();
                    textToSpeech.stop();
                }
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(1)
                        .playOn(findViewById(R.id.fab));
            }
        });


        //event no use in this project
        /** textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {

            @Override
            public void onDone(String utteranceId) {


            }

            @Override
            public void onError(String utteranceId) {
                Log.e("MainActivity", "Error-----");
            }


            @Override
            public void onStart(String utteranceId) {
                Log.e("MainActivity", "On Start ---------");
            }
        });**/

    }


    public void onIcon(){
        fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_sound));
    }

    public void offIcon(){

        fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_stop));
    }




    public FamiliaAbeja searchAbeja(String nombre){
        for (FamiliaAbeja a: FamiliaAbeja.familiaList()) {
            if (getString(a.nombre).equals(nombre)){
                return a;
            }
        }
        return null;
    }

    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onDestroy() {
        textToSpeech.stop();
        textToSpeech.shutdown();
        super.onDestroy();

    }











}
