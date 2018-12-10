package cl.gestiona.appabeja;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by roman on 29-07-18.
 */

public class DetalleRecolectorNidoActivity extends AppCompatActivity{



    private TextToSpeech textToSpeech;
    private int resultTextToSpeech;
    private boolean stateSound=true;
    private FloatingActionButton fab;

    private String description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_recolector_nido);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imageView = (ImageView) findViewById(R.id.img_detalle_reco_nido);
        TextView textView = (TextView) findViewById(R.id.detalle_reco_nido);

        String name = getIntent().getStringExtra("NAME");


        if (name.equalsIgnoreCase("comportamiento recolector")){
            setTitle("C. Recolector");
            textView.setText(R.string.comportamiento_recolector_descripcion);
            imageView.setImageResource(R.drawable.card_recolector);
        }else if(name.equalsIgnoreCase("nidos")){
            setTitle("Nidos");
            textView.setText(R.string.nidos_descripcion);
            imageView.setImageResource(R.drawable.card_nido);
        }

        description = textView.getText().toString();

        textToSpeech = new TextToSpeech(DetalleRecolectorNidoActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    resultTextToSpeech = textToSpeech.setLanguage(new Locale("spa","MEX"));

                }else{
                    toast("Sonido no soportado");
                }
            }


        });

        fab = (FloatingActionButton) findViewById(R.id.fab_reco_nido);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stateSound){
                    stateSound=false;
                    offIcon();
                    dialogo(description);
                }else{
                    stateSound = true;
                    onIcon();
                    textToSpeech.stop();
                }
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(1)
                        .playOn(findViewById(R.id.fab_reco_nido));
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
}
