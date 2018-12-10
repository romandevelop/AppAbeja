package cl.gestiona.appabeja;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.img);

        //imageView.setBackgroundResource(R.drawable.animacion);
        //animation = (AnimationDrawable)imageView.getBackground();
        //animation.start();

        YoYo.with(Techniques.Tada)
                .duration(700)
                .repeat(5)
                .playOn(findViewById(R.id.img));

         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent i = new Intent(MainActivity.this, HomeActivity.class);
                 startActivity(i);
                 finish();
             }
         }, 4000);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Intent i = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(i);
        finish();
        super.onRestart();
    }
}
