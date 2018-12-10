package cl.gestiona.appabeja;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlantasFragment extends Fragment {


    public PlantasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_guia, container, false);

        CardView nativa = (CardView) view.findViewById(R.id.card_nativa);
        CardView exotica = (CardView) view.findViewById(R.id.card_exotica);
        CardView endemica = (CardView) view.findViewById(R.id.card_endemica);

        nativa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetalleActivity("nativa");
            }
        });

        exotica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetalleActivity("exotica");
            }
        });

        endemica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetalleActivity("endemica");
            }
        });


        return view;
    }

    public void launchDetalleActivity(String tipo){
        Intent i = new Intent(getActivity(), DetalleFlowerActivity.class);
        i.putExtra("NAME", tipo);
        startActivity(i);
    }

}
