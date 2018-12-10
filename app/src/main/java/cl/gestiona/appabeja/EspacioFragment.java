package cl.gestiona.appabeja;


import android.content.Intent;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */


public class EspacioFragment extends Fragment {


    private ImageView identificacion, comportamiento,nidos;

    public EspacioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_espacio, container, false);

        identificacion = (ImageView) view.findViewById(R.id.item_card_img_identificacion);
        comportamiento = (ImageView) view.findViewById(R.id.item_card_img_comportamiento);
        nidos = (ImageView) view.findViewById(R.id.item_card_img_nidos);



        identificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LOG","event identification");
                startActivity(new Intent(getActivity(), IdentificacionActivity.class));
            }
        });

        comportamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),DetalleRecolectorNidoActivity.class);
                i.putExtra("NAME","Comportamiento Recolector");
                startActivity(i);
            }
        });

        nidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),DetalleRecolectorNidoActivity.class);
                i.putExtra("NAME","Nidos");
                startActivity(i);
            }
        });



        return view;
    }




}
