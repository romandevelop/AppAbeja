package cl.gestiona.appabeja;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cl.gestiona.appabeja.adapter.AdapterFamilyAbeja;
import cl.gestiona.appabeja.adapter.AdapterFlower;
import cl.gestiona.appabeja.model.FamiliaAbeja;
import cl.gestiona.appabeja.model.ItemFlower;

/**
 * Created by roman on 29-07-18.
 */

public class DetalleFlowerActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_flower);

        ImageView imageView = (ImageView) findViewById(R.id.img_flower) ;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String name = getIntent().getStringExtra("NAME");


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_items_flower);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);




        if (name.equalsIgnoreCase("nativa")){
            setTitle(getString(R.string.nativa));
            imageView.setImageResource(R.drawable.na_adesmia);
            recyclerView.setAdapter(new AdapterFlower(flowerList(R.string.nativa), R.layout.item_recycler_list_abeja, this));
        }else if (name.equalsIgnoreCase("exotica")){
            setTitle(R.string.exotica);
            imageView.setImageResource(R.drawable.ex_brassica);
            recyclerView.setAdapter(new AdapterFlower(flowerList(R.string.exotica), R.layout.item_recycler_list_abeja, this));
        }else if(name.equalsIgnoreCase("endemica")){
            setTitle(R.string.endemica);
            imageView.setImageResource(R.drawable.en_chloraea);
            recyclerView.setAdapter(new AdapterFlower(flowerList(R.string.endemica), R.layout.item_recycler_list_abeja, this));
        }








    }



    private List<ItemFlower> flowerList(int  tipo){
        ArrayList<ItemFlower> list = new ArrayList<>();
        for(ItemFlower i : FamiliaAbeja.flowerList()){
            if (i.tipo == tipo){
                list.add(i);
            }
        }
        return list;
    }



}
