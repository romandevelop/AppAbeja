package cl.gestiona.appabeja;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import cl.gestiona.appabeja.model.Abeja;


/**
 * A simple {@link Fragment} subclass.
 */
public class FamiliaAbejasFragment extends Fragment {


    public FamiliaAbejasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_familia_abejas, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_abejas);

        listView.setAdapter(new AdaptadorFamiliaAbeja(getContext(), Abeja.familiaList()));
        return view;
    }

}
