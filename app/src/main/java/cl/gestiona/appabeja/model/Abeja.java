package cl.gestiona.appabeja.model;

import java.util.ArrayList;
import java.util.List;

import cl.gestiona.appabeja.R;

/**
 * Created by roman on 09-11-17.
 */

public class Abeja {
    public int nombre;
    public int descricion;
    public int foto;
    private  static ArrayList<Abeja> list;


    public Abeja(int nombre, int descricion, int foto) {
        this.nombre = nombre;
        this.descricion = descricion;
        this.foto = foto;
    }

    public static List<Abeja> familiaList(){
        list = new ArrayList<>();
        //list.add(new Abeja(R.string.adrenidae_name, R.string.adrenaide_descripcion,R.drawable.test));
        list.add(new Abeja(R.string.colletidae_name, R.string.colletidae_descripcion,R.drawable.card_colletidae));
        list.add(new Abeja(R.string.halictidae_name, R.string.halictidae_descripcion,R.drawable.card_halictidae));
        //list.add(new Abeja(R.string.megachilidae_name, R.string.megachilidae_descripcion,R.drawable.megachilidae));
        list.add(new Abeja(R.string.apidae_name, R.string.apidae_descripcion,R.drawable.card_apidae));
        return list;
    }



}
