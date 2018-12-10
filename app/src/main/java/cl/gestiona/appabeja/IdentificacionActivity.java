package cl.gestiona.appabeja;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

public class IdentificacionActivity extends AppCompatActivity {

    private ListView listView;
    private String[] data={"Demostración","Megachilidae","Halictidae","Colletidae","Apidae","Adrenidae"};
    private VideoView videoView;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacion);

        listView = (ListView) findViewById(R.id.playList);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setItemChecked(-1,true);

        videoView = (VideoView) findViewById(R.id.video1);
        /*final VideoView videoView = (VideoView) findViewById(R.id.video1);*/
        Uri path = Uri.parse("android.resource://cl.gestiona.appabeja/"+R.raw.final2);
        videoView.setVideoURI(path);
        videoView.start();

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                parent.setSelection(position);

                switch (position){
                    case 0:
                        url = "android.resource://cl.gestiona.appabeja/"+R.raw.final2;
                        break;
                    case 1:
                        url = "android.resource://cl.gestiona.appabeja/"+R.raw.v2;
                        break;
                    case 2:
                        url = "android.resource://cl.gestiona.appabeja/"+R.raw.v3;
                        break;
                    case 3:
                        url = "android.resource://cl.gestiona.appabeja/"+R.raw.v4;
                        break;
                    case 4:
                        url = "android.resource://cl.gestiona.appabeja/"+R.raw.v5;
                        break;
                    case 5:
                        url = "android.resource://cl.gestiona.appabeja/"+R.raw.v6;
                        break;

                }
                Uri path = Uri.parse(url);
                videoView.setVideoURI(path);
                videoView.setMediaController(new MediaController(IdentificacionActivity.this));
                videoView.requestFocus();
                videoView.start();

            }
        });
        //https://www.youtube.com/watch?v=f2MOYNTe2oU
        //videoView.setMediaController(new MediaController(this));

    }
}
